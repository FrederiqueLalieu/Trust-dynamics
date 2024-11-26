//////////////////////////////////////////////////////////////////////
///////////////////// INTIAL BELIEFS /////////////////////////////////
//////////////////////////////////////////////////////////////////////


/////////////////// AGENTS ///////////////////////////////////////////

belief(0.3, trust, predictability, 0.6).

// Optional input for benevolence, competence
belief(0.8, benevolence, tom, fun, 0, 0.5).
belief(0.7, benevolence, tom, comfort, 0.2, 0.6).

// Input for predictability
belief(0.6, principle, tom, p1, 0.8).
belief(0.2, principle, tom, p2, 0.2).
belief(0.5, principle, tom, p3, 0.6).
belief(0.9, principle, tom, p4, 0.4).
belief(0.1, principle, tom, p5, 0.2).

/////////////////// INTENTIONS ///////////////////////////////////////
// Input for competence, predictability
// Output of benevolence

belief(0.7, intention, tom, gardening).
belief(0.5, intention, tom, shopping).
belief(0.8, intention, tom, swimming).
belief(0.3, intention, tom, plan1).
belief(0.4, intention, tom, plan2).
belief(0.9, intention, tom, plan1).
belief(0.2, intention, tom, plan2).

///////////////// ACTIONS ////////////////////////////////////////////
// Input for benevolence

belief(0.1, offer, tom, gardening, chilling, offer1).
belief(0.6, reject, tom, offer1, comfort).
belief(0.3, reject, tom, offer1, fun).

belief(0.4, offer, tom, cooking, shopping, offer2).

belief(0.8, accept, tom, offer2).
// belief(0.8, reject, tom, offer2, reason).
belief(0.2, reject, tom, offer2, reason).

///////////////// RESULTS ////////////////////////////////////////////
// Input for competence
belief(0.2, succes, tom, gardening).
belief(0.7, succes, tom, shopping).
belief(0.5, failure, tom, swimming, time).

////////////// VALUE OF PLANS ////////////////////////////////////////
belief(0.6, value, tom, fun, shopping, 0.7).
belief(0.9, value, tom, fun, cooking, 0.3).
belief(0.1, value, tom, fun, chilling, 0.4).
belief(0.3, value, tom, fun, gardening, 0.3).

belief(0.5, value, tom, comfort, gardening, 0.4).
belief(0.4, value, tom, comfort, chilling, 0.2).

belief(0.8, value, plan1, p1, 0.5).
belief(0.3, value, plan1, p2, 0.6).
belief(0.9, value, plan1, p4, 0.8).
belief(0.2, value, plan1, p5, 0.9).

belief(0.7, value, plan2, p2, 0.8).
belief(0.4, value, plan2, p3, 0.7).
belief(0.1, value, plan2, p4, 0.6).
belief(0.6, value, plan2, p5, 0.5).

/////////////// ACTIONS ////////////////////////////////
belief(0.5, subplan, swimming, driving).
belief(0.3, subplan, gardening, weeding).

belief(0.8, knowledge, driving, knowledge, 0.7).

belief(0.2, resource, weeding, tools, 0.6).

belief(0.7, resource, shopping, money, 0.5).
belief(0.4, resource, shopping, bag, 0.4).
belief(0.3, skill, shopping, preference, 0.3).
belief(0.5, resource, shopping, time, 0.6).

belief(0.6, resource, gardening, time, 0.7).
belief(0.4, knowledge, gardening, edible, 0.8).
belief(0.7, resource, gardening, tools, 0.2).

belief(0.5, resource, swimming, time, 0.6).
belief(0.6, skill, swimming, floating, 0.5).
belief(0.2, knowledge, swimming, technique, 0.5).


///////////// DEFINITIONS //////////////////////////////////
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

//////////////////////////////////////////////////////////////////////
// MAIN PROGRAM
/////////////////////////////////////////////////////////////////////
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

// This is so that another agent can let this agent now that they have no more messages for this agent
+ready() =>
    !update_trustworthiness().

+!update_trustworthiness() =>
    for (Agent in agent(Agent)) {
    !update_benevolence(Agent);
    !update_predictability(Agent);
    !update_competence(Agent);
    }.

//////////////////////////////////////////////////////////////////////
// BENEVOLENCE
/////////////////////////////////////////////////////////////////////

+!update_benevolence(A) =>
    #println("-------------------BENEVOLENCE-------------------------");
    for (Offer in offer(A, NewPlan, OldPlan, Offer)) {
        #println("We are now updating according to " + Offer + ".");
        #println("We don't know if " + Offer + " is accepted. We will try to find out now.");
        !evaluate_offer(A, Offer);}.


+!evaluate_offer(A, Offer) :
    offer(A, NewPlan, OldPlan, Offer) &&
    accept(A, Offer) =>
    #println("The offer was accepted.");
    +intention(A, NewPlan);
    for (Value in value(A, Value, NewPlan, X1)) {
        #println("We will check if " + Value + " is relevant.");
        !update_benevolence_accept(A, Value, NewPlan, OldPlan);
    }.

+!evaluate_offer(A, Offer) :
    reject(A, Offer, _) =>
    #println("The offer was rejected.");
    for (Value in reject(Offer, Value)) {
            #println("It was rejected on the basis of " + Value + ".");
            !update_benevolence_reject(A, Offer, Value);
            }.

+!evaluate_offer(A, Offer) =>
    #println("It is not known yet whether " + A + " accepted or rejected the offer.").

+!update_benevolence_accept(A, Value, NewPlan, OldPlan) :
    value(A, Value, NewPlan, X1) &&
    value(A, Value, OldPlan, X2) &&
    benevolence(A, Value, Bmin, Bmax) =>
    #println("One of the relevant values was " + Value + ".");
    B = X2 - X1;
    if (B < 0) {
        #println("It seems " + A + " did not need to sacrifice " + Value + " to accept this plan.");
        -benevolence(A, Value, Bmin, Bmax);
        +benevolence(A, Value, 0, Bmax);
        #println("The previous interval was " + Bmin + ", " + Bmax);
        #println("The benefits of the old versus the new plan are " + X2 + " versus " + X1 + ".");
        #println("The new benevolence interval is " + B + ", " + Bmax + ".");
    } else if (B > Bmax) {
        #println("It seems " + A + " is even more benevolent than you thought was possible.");
        -benevolence(A, Value, Bmin, Bmax);
        +benevolence(A, Value, B, 1);
        #println("The previous interval was " + Bmin + ", " + Bmax + ".");
        #println("The benefits of the old versus the new plan are " + X2 + " versus " + X1 + ".");
        #println("The new benevolence interval is " + B + ", " + 1 + ".");
    } else {
        -benevolence(A, Value, Bmin, Bmax);
        +benevolence(A, Value, B, Bmax);
        #println("The previous interval was " + Bmin + ", " + Bmax + ".");
        #println("The benefits of the old versus the new plan are " + X2 + " versus " + X1 + ".");
        #println("The new benevolence interval is " + B + ", " + Bmax + ".");
    }.

+!update_benevolence_reject(A, Offer, Value) :
    offer(A, NewPlan, OldPlan, Offer) &&
    value(A, Value, NewPlan, X1) &&
    value(A, Value, OldPlan, X2) &&
    benevolence(A, Value, Bmin, Bmax) =>
    B = X2 - X1;
    if (B < 0) {
        #println("Either " + A + " did not actually reject the offer on the basis of " + Value + " or your assesment of his enjoyment of the plans is incorrect.");
        #println("His benevolence will therefore not be updated according to this information.");
    } else if (B < Bmin ) {
        #println("Your previous assesment of his benevolence seems to have been too high.");
        -benevolence(A, Value, Bmin, Bmax);
        +benevolence(A, Value, 0, B);
        #println("The offer was rejected on the basis of " + Value + ".");
        #println("The previous interval was " + Bmin + ", " + Bmax + ".");
        #println("The benefits of the old versus the new are " + X2 + " versus " + X1 + ".");
        #println("The new benevolence interval is " + Bmin + ", " + B + ".");
    }
    else {
        -benevolence(A, Value, Bmin, Bmax);
        +benevolence(A, Value, Bmin, B);
        #println("The offer was rejected on the basis of " + Value + ".");
        #println("The previous interval was " + Bmin + ", " + Bmax);
        #println("The benefits of the old versus the new are " + X2 + " versus " + X1 + ".");
        #println("The new benevolence interval is " + Bmin + ", " + B + ".");
    }.

//////////////////////////////////////////////////////////////////////
// COMPETENCE
/////////////////////////////////////////////////////////////////////
+!update_competence(A) =>
    #println("---------------COMPETENCE----------------");
    for (Action in succes(A, Action)) {
        !update_competence_succes(A, Action);};

    for (Action in failure(A, Action, _)) {
        !update_competence_failures(A, Action);
    }.

+!add_info(A, Action, Condition) :
    knowledge(Action, Condition, X) &&
    knowledge(A, Condition, Low, High) =>
    if ((X >= Low) && (X < High)) {
        -knowledge(A, Condition, Low, High);
        +knowledge(A, Condition, X, High);}.

+!add_info(A, Action, Condition) :
    knowledge(Action, Condition, X) =>
    +knowledge(A, Condition, X, 1).

+!add_info(A, Action, Condition) :
    resource(Action, Condition, X) &&
    resource(A, Condition, Low, High) =>
    if ((X >= Low) && (X < High)) {
        -resource(A, Condition, Low, High);
        +resource(A, Condition, X, High);}.

+!add_info(A, Action, Condition) :
    resource(Action, Condition, X) =>
    +resource(A, Condition, X, 1).

+!add_info(A, Action, Condition) :
    skill(Action, Condition, X) &&
    skill(A, Condition, Low, High) =>
    if ((X >= Low) && (X < High)) {
        -skill(A, Condition, Low, High);
        +skill(A, Condition, X, High);}.

+!add_info(A, Action, Condition) :
    skill(Action, Condition, X) =>
    +skill(A, Condition, X, 1).

+!update_competence_succes(A, Action) :
    intention(A, Action) =>
    #println(A + " intended to go " + Action + " and succeeded.");
    +competent(A, Action);
    for (Knowledge in knowledge(Action, Knowledge, X)) {
        !add_info(A, Action, Knowledge);
    };
    for (Resource in resource(Action, Resource, X)) {
        !add_info(A, Action, Resource);
    };
    for (Skill in skill(Action, Skill, X)) {
        !add_info(A, Action, Skill);
    };
    for (Subaction in subplan(Action, Subaction)) {
        #println(A + " intended to go " + Subaction + " and succeeded.");
        +competent(A, Subaction);
        for (Knowledge in knowledge(subaction, Knowledge, X)) {
            +knowledge(A, Knowledge, X);
        };
        for (Resource in resource(Subaction, Resource)) {
            +resource(A, Resource, X);
        };
        for (Skill in skill(Subaction, Skill, X)) {
            +skill(A, Skill, X);
        };
        }.

+!update_competence_failures(A, Action) :
    intention(A, Action) =>
    #println(A + " intended to go " + Action + " and failed.");
    for (Reason in failure(A, Action, Reason)) {
        #println(A + " failed because of " + Reason + ".");
        !update_competence_failure(A, Action, Reason);
    }.

// Update with priory to new beliefs
+!update_competence_failure(A, Action, Condition) :
    resource(Action, Condition, X) &&
    resource(A, Condition, Low, High) =>
    if ((X < High) && (X > Low)) {
        -resource(A, Condition, Low, High);
        +resource(A, Condition, Low, X);}
    else if (X =< Low) {
        -resource(A, Condition, Low, High);
        +resource(A, Condition, 0, X);
    }.

+!update_competence_failure(A, Action, Condition) :
    resource(Action, Condition, X)=>
    +resource(A, Condition, 0, X).

+!update_competence_failure(A, Action, Condition) :
    knowledge(Action, Condition, X) &&
    knowledge(A, Condition, Low, High) =>
    if ((X < High) && (X > Low)) {
        +knowledge(A, Condition, Low, X);}
    else if (X =< Low) {
        -knowledge(A, Condition, Low, High);
        +knowledge(A, Condition, 0, X);        
    }.

+!update_competence_failure(A, Action, Condition) :
    knowledge(Action, Condition, X)=>
    +knowledge(A, Condition, 0, X).

+!update_competence_failure(A, Action, Condition) :
    skill(Action, Condition, X) &&
    skill(A, Condition, Low, High) =>
    if ((X < High) && (X > Low)) {
        +skill(A, Condition, Low, X);}
    else if (X =< Low) {
        -skill(A, Condition, Low, High);
        +skill(A, Condition, 0, X);
    }.

+!update_competence_failure(A, Action, Condition) :
    skill(Action, Condition, X) =>
    +skill(A, Condition, 0, X).

// +skill(A, Condition, Low, High) =>
//     #println(A + " has mastered " + Condition + " between " + Low + " and " + High).

// +resource(A, Condition, Low, High) =>
//     #println(A + " has " + Condition + " between " + Low + " and " + High).

// +knowledge(A, Condition, Low, High) =>
//     #println(A + " has knowledge of " + Condition + " between " + Low + " and " + High).

//////////////////////////////////////////////////////////////////////
// PREDICTABILITY
/////////////////////////////////////////////////////////////////////
+!update_predictability(Agent) =>
    #println("-------------------PREDICTABILITY---------------------");
    for (Plan in intention(Agent, Plan)) {
        #println(Agent + " intends to do " + Plan + ".");
        !get_principle_intention(Agent, Plan);
        for (Subplan in subplan(Plan, Subplan)) {
            !get_principle_intention(Agent, Subplan);
        };
    }.


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

//////////////////////////////////////////////////////////////////////
// REASONING
/////////////////////////////////////////////////////////////////////

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