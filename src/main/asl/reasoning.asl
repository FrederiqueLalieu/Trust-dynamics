//////////////////////////////////////////////////////////////////////
// This file contains all the definitions and plans that are necessary
// to simulate the behaviour of an agent receiving new information and
// deciding what to belief.
//////////////////////////////////////////////////////////////////////

agent(A) :- belief(Y, agent, A).
trust(A, V) :- belief(Y, trust, A, V).
benevolence(A, V, X1, X2) :- belief(Y, benevolence, A, V, X1, X2).
principle(A, V, X) :- belief(Y, principle, A, V, X).
intention(A, P) :- belief(Y, intention, A, P).
offer(A, P1, P2, O) :- belief(Y, offer, A, P1, P2, O).
reject(A, O, V) :- belief(Y, reject, A, O, V).
accept(A, O) :- belief(Y, accept, A, O).
succes(A, P) :- belief(Y, succes, A, P).
failure(A, P, C) :- belief(Y, failure, A, P, C).
value(A, V, P, X) :- belief(Y, value, A, V, P, X).
value(P, V, X) :- belief(Y, value, P, V, X).
subplan(P1, P2) :- belief(Y, subplan, P1, P2).
knowledge(P, C, X) :- belief(Y, knowledge, P, C, X).
resource(P, C, X) :- belief(Y, resource, P, C, X).
skill(P, C, X) :- belief(Y, skill, P, C, X).

+!update_predictability(Agent) =>
    #println("-------------------PREDICTABILITY---------------------");
    for (Plan in intention(Agent, Plan)) {
        #println(Agent + " intends to do " + Plan + ".");
        !get_principle_intention(Agent, Plan);
        for (Subplan in subplan(Plan, Subplan)) {
            !get_principle_intention(Agent, Subplan);
        };
    }.

// +!update_trustworthiness() =>
//     for (Agent in agent(Agent)) {
//     !update_benevolence(Agent);
//     !update_predictability(Agent);
//     !update_competence(Agent);
//     }.

+!get_principle_intention(Agent, Plan) =>
    for (P in principle(Agent, P, _)) {
        !get_weight(Agent, P, Plan);
    }.

+!get_weight(Agent, P, Plan) :
    principle(Agent, P, X1) &&
    value(Plan, P, X2) &&
    insincere(Agent, P, X3) &&
    D is (X1 - X2) =>
    if (D > X3) {
        -insincere(Agent, P, X3);
        +insincere(Agent, P, D);
    #println("The intentions of " + Agent + " show that they deviate " + D + " from what I believed about how they value " + P + ".");
    }.

+!get_weight(Agent, P, Plan) :
    principle(Agent, P, X1) &&
    value(Plan, P, X2) &&
    D is (X1 - X2) =>
    +insincere(Agent, P, D);
    #println("The intentions of " + Agent + " show that they deviate " + D + " from what I believed about how they value " + P + ".").


+!get_weight(Agent, P, Plan) =>
    +insincere(Agent, P, 0);
    #println("The intentions of " + Agent + " do not tell me anything about how they value principle " + P + ". Their behaviour does not influence how I view their predictability.").

+!is_contradiction() :
    belief(Y1, accept, A, B) &&
    belief(Y2, reject, A, B, C) =>
    if (Y1 > Y2) {
        -belief(Y2, reject, A, B, C);
        #println("Contradiction.");
    } else if (Y2 > Y1) {
        -belief(Y1, accept, A, B);
        #println("Contradiction.");
    };
    !is_contradiction().

+!is_contradiction() :
    belief(Y1, failure, A, Plan, B) &&
    belief(Y2, succes, A, Plan) =>
    if (Y1 > Y2) {
        -belief(Y2, succes, A, Plan);
        #println("Contradiction.");
    } else if (Y2 > Y1) {
        -belief(Y1, failure, A, Plan, B);
        #println("Contradiction");
    };
    !is_contradiction().

+!is_contradiction() :
    belief(Y1, mighthave, A, B) &&
    belief(Y2, hasnot, A, B) || belief(Y2, has, A, B) =>
    if (Y1 > Y2) {
        -belief(Y2, hasnot, A, B);
        -belief(Y2, has, A, B);
        #println("Contradiction.");
    } else if (Y2 > Y1) {
        -belief(Y1, mighthave, A, B);
        #println("Contradiction");
    };
    !is_contradiction().

+!is_contradiction() :
    belief(Y1, competent, A, B) &&
    belief(Y2, incompetent, A, B) =>
    if (Y1 > Y2) {
        -belief(Y2, incompetent, A, B);
        #println("COntradiction.");
    } else if (Y2 > Y1) {
        -belief(Y1, competent, A, B);
        #println("Contradiction");
    };
    !is_contradiction().

+!is_contradiction() :
    belief(Y1, unknown, A, B) &&
    belief(Y2, incompetent, A, B) || belief(Y2, competent, A, B) =>
    if (Y1 > Y2) {
        -belief(Y2, incompetent, A, B);
        -belief(Y2, competent, A, B);
        #println("Contradiction.");
    } else if (Y2 > Y1){
        -belief(Y1, unknown, A, B);
        #println("Contradiction");
    };
    !is_contradiction().

+!is_contradiction() :
    belief(Y1, value, A, B, C, D) &&
    belief(Y2, value, A, B, C, E) &&
    D != E &&
    F is ((Y1 * D + Y2 * E)/(Y1+Y2)) =>
    #println("There was a contradiction between something.");
    -belief(Y1, value, A, B, C, D);
    -belief(Y2, value, A, B, C, E);
    +belief(Y1, value, A, B, C, F);
    !is_contradiction().

+!is_contradiction(A, Rumour1, Rumour2) :
    belief(Y1, principle, A, B, C) &&
    belief(Y2, principle, A, B, D) &&
    C != D &&
    E is ((Y1 * C + Y2 * D)/(Y1+Y2)) =>
    #println("There was a contradiction between something.");
    -belief(Y1, principle, A, B, C);
    -belief(Y2, principle, A, B, D);
    +belief(Y1, principle, A, B, E);
    !is_contradiction().

    +belief(Y, Z, A) :
    trust(Y, X) =>
    -belief(Y, Z, A);
    +belief(X, Z, A);
    !is_contradiction().

+belief(Y, Z, A, B) :
    trust(Y, X) =>
    -belief(Y, Z, A, B);
    +belief(X, Z, A, B);
    !is_contradiction().

+belief(Y, Z, A, B, C) :
    trust(Y, X) =>
    -belief(Y, Z, A, B, C);
    +belief(X, Z, A, B, C);
    !is_contradiction().

+belief(Y, Z, A, B, C, D):
    trust(Y, X) =>
    -belief(Y, Z, A, B, C, D);
    +belief(X, Z, A, B, C, D);
    !is_contradiction().

+belief(Y, Z, A, B, C, D, E) :
    trust(Y, X) =>
    -belief(Y, Z, A, B, C, D, E);
    +belief(X, Z, A, B, C, D, E);
    !is_contradiction().


// +ready() =>
//     !update_trustworthiness().
