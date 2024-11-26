package asl
 import _root_.scala.collection.mutable.HashMap

 import _root_.akka.actor.typed.{ActorRef, Behavior, SupervisorStrategy}
 import _root_.akka.actor.typed.scaladsl.{ActorContext, Behaviors, Routers}
 import java.util.logging.Logger
 import _root_.scala.util.Failure
 import _root_.scala.util.Success
 import _root_.akka.util.Timeout
 import _root_.scala.concurrent.duration._
 import _root_.akka.actor.typed.scaladsl.AskPattern._
 import _root_.scala.language.implicitConversions
 import _root_.scala.concurrent.{Await, Future}
 import _root_.scala.jdk.CollectionConverters._
 import std.converters._

 import scala.util.Random
 import bb._
 import infrastructure._
 import bb.expstyla.exp._
 import std.{AgentCommunicationLayer, DefaultCommunications}

 class agent  (coms: AgentCommunicationLayer = new  DefaultCommunications,
                                     beliefBaseFactory: IBeliefBaseFactory = new StylaBeliefBaseFactory)
                      extends IntentionalAgentFactory {


 object Intention {

       def apply(p_executionContext: ExecutionContext): Behavior[ISubGoalMessage] = Behaviors.setup { context =>

         Behaviors.receive {
         (context, message) =>

          implicit val executionContext = p_executionContext.copy(intention = context, src = message.source)

         message match {
            case SubGoalMessage(_,_,r) =>
               message.goal match {

                   case agent.this.adopt_belief_belief_3 =>
                     agent.this.adopt_belief_belief_3.execute(message.params.asInstanceOf[Parameters])

                   case agent.this.adopt_belief_belief_4 =>
                     agent.this.adopt_belief_belief_4.execute(message.params.asInstanceOf[Parameters])

                   case agent.this.adopt_belief_belief_5 =>
                     agent.this.adopt_belief_belief_5.execute(message.params.asInstanceOf[Parameters])

                   case agent.this.adopt_belief_belief_6 =>
                     agent.this.adopt_belief_belief_6.execute(message.params.asInstanceOf[Parameters])

                   case agent.this.adopt_belief_belief_7 =>
                     agent.this.adopt_belief_belief_7.execute(message.params.asInstanceOf[Parameters])

                   case agent.this.adopt_belief_ready_0 =>
                     agent.this.adopt_belief_ready_0.execute(message.params.asInstanceOf[Parameters])

                   case agent.this.adopt_achievement_update_trustworthiness_0 =>
                     agent.this.adopt_achievement_update_trustworthiness_0.execute(message.params.asInstanceOf[Parameters])

                   case agent.this.adopt_achievement_update_benevolence_1 =>
                     agent.this.adopt_achievement_update_benevolence_1.execute(message.params.asInstanceOf[Parameters])

                   case agent.this.adopt_achievement_evaluate_offer_2 =>
                     agent.this.adopt_achievement_evaluate_offer_2.execute(message.params.asInstanceOf[Parameters])

                   case agent.this.adopt_achievement_update_benevolence_accept_4 =>
                     agent.this.adopt_achievement_update_benevolence_accept_4.execute(message.params.asInstanceOf[Parameters])

                   case agent.this.adopt_achievement_update_benevolence_reject_3 =>
                     agent.this.adopt_achievement_update_benevolence_reject_3.execute(message.params.asInstanceOf[Parameters])

                   case agent.this.adopt_achievement_update_competence_1 =>
                     agent.this.adopt_achievement_update_competence_1.execute(message.params.asInstanceOf[Parameters])

                   case agent.this.adopt_achievement_add_info_3 =>
                     agent.this.adopt_achievement_add_info_3.execute(message.params.asInstanceOf[Parameters])

                   case agent.this.adopt_achievement_update_competence_succes_2 =>
                     agent.this.adopt_achievement_update_competence_succes_2.execute(message.params.asInstanceOf[Parameters])

                   case agent.this.adopt_achievement_update_competence_failures_2 =>
                     agent.this.adopt_achievement_update_competence_failures_2.execute(message.params.asInstanceOf[Parameters])

                   case agent.this.adopt_achievement_update_competence_failure_3 =>
                     agent.this.adopt_achievement_update_competence_failure_3.execute(message.params.asInstanceOf[Parameters])

                   case agent.this.adopt_achievement_update_predictability_1 =>
                     agent.this.adopt_achievement_update_predictability_1.execute(message.params.asInstanceOf[Parameters])

                   case agent.this.adopt_achievement_get_principle_intention_2 =>
                     agent.this.adopt_achievement_get_principle_intention_2.execute(message.params.asInstanceOf[Parameters])

                   case agent.this.adopt_achievement_get_weight_3 =>
                     agent.this.adopt_achievement_get_weight_3.execute(message.params.asInstanceOf[Parameters])

                   case agent.this.adopt_achievement_is_contradiction_0 =>
                     agent.this.adopt_achievement_is_contradiction_0.execute(message.params.asInstanceOf[Parameters])

                   case agent.this.adopt_achievement_is_contradiction_3 =>
                     agent.this.adopt_achievement_is_contradiction_3.execute(message.params.asInstanceOf[Parameters])


           case _ =>
             context.log.error("This actor can not handle goal of type {}", message.goal)
         }
           r match {
                 case a : AkkaMessageSource => 
                   a.src ! IntentionDoneMessage(AkkaMessageSource(executionContext.agent.self))
                 case DummyMessageSource(_) => 
                   context.log.error("Intention Done!")
               }

               Behaviors.same
             case InitEndMessage(r) =>
               Behaviors.stopped
       }
      }
     }
     }

 override def agentBuilder: Agent = new Agent()
 class Agent extends IAgent {

         override def agent_type: String = "agent"

         var vars = VarMap()

         def initGoals()(implicit executionContext: ExecutionContext) = List[StructTerm](
         )

         def initBeliefs()(implicit executionContext: ExecutionContext) = List[StructTerm](
                     StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.3),StructTerm("trust",Seq[GenericTerm]()),StructTerm("predictability",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.8),StructTerm("benevolence",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]()),IntTerm(0),DoubleTerm(0.5)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.7),StructTerm("benevolence",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("comfort",Seq[GenericTerm]()),DoubleTerm(0.2),DoubleTerm(0.6)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.6),StructTerm("principle",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("p1",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.2),StructTerm("principle",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("p2",Seq[GenericTerm]()),DoubleTerm(0.2)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.5),StructTerm("principle",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("p3",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.9),StructTerm("principle",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("p4",Seq[GenericTerm]()),DoubleTerm(0.4)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.1),StructTerm("principle",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("p5",Seq[GenericTerm]()),DoubleTerm(0.2)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.7),StructTerm("intention",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]())))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.5),StructTerm("intention",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("shopping",Seq[GenericTerm]())))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.8),StructTerm("intention",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("swimming",Seq[GenericTerm]())))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.3),StructTerm("intention",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("plan1",Seq[GenericTerm]())))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.4),StructTerm("intention",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("plan2",Seq[GenericTerm]())))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.9),StructTerm("intention",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("plan1",Seq[GenericTerm]())))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.2),StructTerm("intention",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("plan2",Seq[GenericTerm]())))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.1),StructTerm("offer",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("chilling",Seq[GenericTerm]()),StructTerm("offer1",Seq[GenericTerm]())))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.6),StructTerm("reject",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("offer1",Seq[GenericTerm]()),StructTerm("comfort",Seq[GenericTerm]())))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.3),StructTerm("reject",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("offer1",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]())))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.4),StructTerm("offer",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("cooking",Seq[GenericTerm]()),StructTerm("shopping",Seq[GenericTerm]()),StructTerm("offer2",Seq[GenericTerm]())))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.8),StructTerm("accept",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("offer2",Seq[GenericTerm]())))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.2),StructTerm("reject",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("offer2",Seq[GenericTerm]()),StructTerm("reason",Seq[GenericTerm]())))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.2),StructTerm("succes",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]())))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.7),StructTerm("succes",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("shopping",Seq[GenericTerm]())))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.5),StructTerm("failure",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("swimming",Seq[GenericTerm]()),StructTerm("time",Seq[GenericTerm]())))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.6),StructTerm("value",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]()),StructTerm("shopping",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.9),StructTerm("value",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]()),StructTerm("cooking",Seq[GenericTerm]()),DoubleTerm(0.3)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.1),StructTerm("value",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]()),StructTerm("chilling",Seq[GenericTerm]()),DoubleTerm(0.4)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.3),StructTerm("value",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("fun",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.3)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.5),StructTerm("value",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("comfort",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),DoubleTerm(0.4)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.4),StructTerm("value",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("comfort",Seq[GenericTerm]()),StructTerm("chilling",Seq[GenericTerm]()),DoubleTerm(0.2)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.8),StructTerm("value",Seq[GenericTerm]()),StructTerm("plan1",Seq[GenericTerm]()),StructTerm("p1",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.3),StructTerm("value",Seq[GenericTerm]()),StructTerm("plan1",Seq[GenericTerm]()),StructTerm("p2",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.9),StructTerm("value",Seq[GenericTerm]()),StructTerm("plan1",Seq[GenericTerm]()),StructTerm("p4",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.2),StructTerm("value",Seq[GenericTerm]()),StructTerm("plan1",Seq[GenericTerm]()),StructTerm("p5",Seq[GenericTerm]()),DoubleTerm(0.9)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.7),StructTerm("value",Seq[GenericTerm]()),StructTerm("plan2",Seq[GenericTerm]()),StructTerm("p2",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.4),StructTerm("value",Seq[GenericTerm]()),StructTerm("plan2",Seq[GenericTerm]()),StructTerm("p3",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.1),StructTerm("value",Seq[GenericTerm]()),StructTerm("plan2",Seq[GenericTerm]()),StructTerm("p4",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.6),StructTerm("value",Seq[GenericTerm]()),StructTerm("plan2",Seq[GenericTerm]()),StructTerm("p5",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.5),StructTerm("subplan",Seq[GenericTerm]()),StructTerm("swimming",Seq[GenericTerm]()),StructTerm("driving",Seq[GenericTerm]())))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.3),StructTerm("subplan",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("weeding",Seq[GenericTerm]())))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.8),StructTerm("knowledge",Seq[GenericTerm]()),StructTerm("driving",Seq[GenericTerm]()),StructTerm("knowledge",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.2),StructTerm("resource",Seq[GenericTerm]()),StructTerm("weeding",Seq[GenericTerm]()),StructTerm("tools",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.7),StructTerm("resource",Seq[GenericTerm]()),StructTerm("shopping",Seq[GenericTerm]()),StructTerm("money",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.4),StructTerm("resource",Seq[GenericTerm]()),StructTerm("shopping",Seq[GenericTerm]()),StructTerm("bag",Seq[GenericTerm]()),DoubleTerm(0.4)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.3),StructTerm("skill",Seq[GenericTerm]()),StructTerm("shopping",Seq[GenericTerm]()),StructTerm("preference",Seq[GenericTerm]()),DoubleTerm(0.3)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.5),StructTerm("resource",Seq[GenericTerm]()),StructTerm("shopping",Seq[GenericTerm]()),StructTerm("time",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.6),StructTerm("resource",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("time",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.4),StructTerm("knowledge",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("edible",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.7),StructTerm("resource",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]()),StructTerm("tools",Seq[GenericTerm]()),DoubleTerm(0.2)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.5),StructTerm("resource",Seq[GenericTerm]()),StructTerm("swimming",Seq[GenericTerm]()),StructTerm("time",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.6),StructTerm("skill",Seq[GenericTerm]()),StructTerm("swimming",Seq[GenericTerm]()),StructTerm("floating",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("belief",Seq[GenericTerm](DoubleTerm(0.2),StructTerm("knowledge",Seq[GenericTerm]()),StructTerm("swimming",Seq[GenericTerm]()),StructTerm("technique",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("agent",Seq[GenericTerm](vars("A"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("agent",Seq[GenericTerm]()),vars("A")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("trust",Seq[GenericTerm](vars("A"),vars("V"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("trust",Seq[GenericTerm]()),vars("A"),vars("V")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("V"),vars("X1"),vars("X2"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("benevolence",Seq[GenericTerm]()),vars("A"),vars("V"),vars("X1"),vars("X2")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("principle",Seq[GenericTerm](vars("A"),vars("V"),vars("X"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("principle",Seq[GenericTerm]()),vars("A"),vars("V"),vars("X")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("intention",Seq[GenericTerm](vars("A"),vars("P"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("intention",Seq[GenericTerm]()),vars("A"),vars("P")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("offer",Seq[GenericTerm](vars("A"),vars("P1"),vars("P2"),vars("O"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("offer",Seq[GenericTerm]()),vars("A"),vars("P1"),vars("P2"),vars("O")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("reject",Seq[GenericTerm](vars("A"),vars("O"),vars("V"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("reject",Seq[GenericTerm]()),vars("A"),vars("O"),vars("V")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("accept",Seq[GenericTerm](vars("A"),vars("O"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("accept",Seq[GenericTerm]()),vars("A"),vars("O")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("succes",Seq[GenericTerm](vars("A"),vars("P"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("succes",Seq[GenericTerm]()),vars("A"),vars("P")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("failure",Seq[GenericTerm](vars("A"),vars("P"),vars("C"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("failure",Seq[GenericTerm]()),vars("A"),vars("P"),vars("C")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("value",Seq[GenericTerm](vars("A"),vars("V"),vars("P"),vars("X"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("value",Seq[GenericTerm]()),vars("A"),vars("V"),vars("P"),vars("X")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("value",Seq[GenericTerm](vars("P"),vars("V"),vars("X"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("value",Seq[GenericTerm]()),vars("P"),vars("V"),vars("X")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("subplan",Seq[GenericTerm](vars("P1"),vars("P2"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("subplan",Seq[GenericTerm]()),vars("P1"),vars("P2")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("knowledge",Seq[GenericTerm](vars("P"),vars("C"),vars("X"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("knowledge",Seq[GenericTerm]()),vars("P"),vars("C"),vars("X")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("resource",Seq[GenericTerm](vars("P"),vars("C"),vars("X"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("resource",Seq[GenericTerm]()),vars("P"),vars("C"),vars("X")))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("skill",Seq[GenericTerm](vars("P"),vars("C"),vars("X"))),StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("skill",Seq[GenericTerm]()),vars("P"),vars("C"),vars("X")))))


         )

         def planApplicabilities()(implicit executionContext: ExecutionContext) = List[StructTerm](

                 )



      def apply(name: String, yellowPages: IYellowPages, MAS: ActorRef[IMessage], parent: IMessageSource): Behavior[IMessage] = {
           Behaviors.setup { context =>
             val yp: IYellowPages = yellowPages
             val bb: IBeliefBase[GenericTerm] = beliefBaseFactory()
             implicit val executionContext: ExecutionContext = ExecutionContext(
                            name = name,
                            agentType = agent_type,
                            agent = context,
                            yellowPages = yp,
                            beliefBase = bb,
                            logger = context.log,
                            goalParser = GoalParser,
                            parent = parent
                          )
             bb.assert(initBeliefs)
             bb.assert(planApplicabilities)

         val initiator = context.spawn(Intention(executionContext), "initiator")

         MAS ! ReadyMessage(context.self)
         Behaviors.receive {
           (context, message) =>
             message match {
               case StartMessage() =>


                 implicit val timeout: Timeout = 99999.seconds
                 implicit val ec = context.executionContext
                 implicit val scheduler = context.system.scheduler


                 //              initGoals.foreach( tuple => initiator ! SubGoalMessage(tuple._1,tuple._2,context.self))
                 initGoals.foreach(struct => {


                   val result: Future[IMessage] = initiator.ask[IMessage](ref => {
                     val subGoal = GoalParser.create_goal_message(struct, AkkaMessageSource(ref))
                     if (subGoal.isDefined)
                       subGoal.get
                     else
                       throw new RuntimeException(s"No plan for initial goal $struct")
                     }
                   )


                   //result.onComplete {
                   //  case Success(IntentionDoneMessage(r)) => IntentionDoneMessage(r)
                   //  case Failure(_) => IntentionErrorMessage(src = null)
                   //}

                   //Await.result(result, timeout.duration)

                   val res = Await.result(result, timeout.duration)

                   if(!res.isInstanceOf[IntentionDoneMessage]) {
                     throw new RuntimeException(s"Issue with initial goal $struct")
                     context.system.terminate()
                   }

                   //                context.ask[ISubGoalMessage, IMessage](initiator, ref => SubGoalMessage(tuple._1, tuple._2,name, ref)) {
                   //                  case Success(IntentionDoneMessage(_, _)) => IntentionDoneMessage()
                   //                  case Failure(_) => IntentionErrorMessage()
                   //                }
                 }
                 )

                 initiator ! InitEndMessage(context.self)
                 normal_behavior(MAS)

               //            case InitEndMessage(_) =>
               //              context.log.debug(f"$name: I have started, switching behavior")
               //              normal_behavior()
             }

         }
       }
     }

     def normal_behavior(MAS: ActorRef[IMessage])(implicit executionContext: ExecutionContext): Behavior[IMessage] = {
       Behaviors.setup { context =>

         val pool = Routers.pool(poolSize = 8)(
           Behaviors.supervise(Intention(executionContext)).onFailure[Exception](SupervisorStrategy.restart))

         val router = context.spawn(pool, "intention-pool")
         //MAS ! ReadyMessage(context.self)
         Behaviors.receive {
           (context, message) =>
             message match {
               case IntentionDoneMessage(s) =>
                 context.log.debug(f"${executionContext.name}: an intention was done by $s")
               case IntentionErrorMessage(c,s) =>
                 context.log.debug(f"${executionContext.name}: an intention was done by $s: $c")
               case SubGoalMessage(_, _, _) =>
                 router ! message.asInstanceOf[SubGoalMessage]
               case GoalMessage(m, ref) =>
                 m match {
                   case t: StructTerm =>
                     val subGoal = GoalParser.create_goal_message(t, ref)

                     if (subGoal.isDefined)
                       context.self ! subGoal.get
                     else
                       ref.asInstanceOf[AkkaMessageSource].src ! IntentionErrorMessage(NoPlanMessage(),AkkaMessageSource(executionContext.agent.self))


                 }

                case AskMessage(m, ref) =>
                                m match {
                                  case t: StructTerm =>
                                    val subGoal = GoalParser.create_test_message(t, ref)

                                    if (subGoal.isDefined)
                                      context.self ! subGoal.get
                                    else
                                      ref.asInstanceOf[AkkaMessageSource].src ! IntentionErrorMessage(NoPlanMessage(),AkkaMessageSource(executionContext.agent.self))
                                }
             case BeliefMessage(m, ref) =>
                  m match {
                    case t: StructTerm =>
                    if(executionContext.beliefBase.assertOne(t)) {
                      val subGoal = GoalParser.create_belief_message(t, ref)

                      if (subGoal.isDefined)
                        context.self ! subGoal.get
                    }
                  }

              case UnBeliefMessage(m, ref) =>
                   m match {
                     case t: StructTerm =>
                     if(executionContext.beliefBase.retractOne(t)) {
                       val subGoal = GoalParser.create_unbelief_message(t, ref)

                       if (subGoal.isDefined)
                         context.self ! subGoal.get
                     }
                   }
             }
             Behaviors.same
         }
       }
     }
   }



   object GoalParser extends IAgentGoalParser {
        override def create_goal_message(t: StructTerm, ref: IMessageSource) (implicit executionContext: ExecutionContext): Option[SubGoalMessage] = {
                        
                                   if(t.matchOnlyFunctorAndArity("update_trustworthiness",0)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_update_trustworthiness_0, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("update_benevolence",1)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_update_benevolence_1, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("evaluate_offer",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_evaluate_offer_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("update_benevolence_accept",4)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_update_benevolence_accept_4, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("update_benevolence_reject",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_update_benevolence_reject_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("update_competence",1)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_update_competence_1, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("add_info",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_add_info_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("update_competence_succes",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_update_competence_succes_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("update_competence_failures",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_update_competence_failures_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("update_competence_failure",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_update_competence_failure_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("update_predictability",1)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_update_predictability_1, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("get_principle_intention",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_get_principle_intention_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("get_weight",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_get_weight_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("is_contradiction",0)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_is_contradiction_0, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("is_contradiction",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_is_contradiction_3, args, ref))
                                   } else   {
                    Option.empty[SubGoalMessage]
                    }

                }

        override def create_belief_message(t: StructTerm, ref: IMessageSource) (implicit executionContext: ExecutionContext): Option[SubGoalMessage] = {
                                   if(t.matchOnlyFunctorAndArity("belief",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_belief_belief_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("belief",4)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_belief_belief_4, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("belief",5)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_belief_belief_5, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("belief",6)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_belief_belief_6, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("belief",7)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_belief_belief_7, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("ready",0)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_belief_ready_0, args, ref))
                                   } else                  {
                    Option.empty[SubGoalMessage]
                    }

                }

         override def create_test_message(t: StructTerm, ref: IMessageSource) (implicit executionContext: ExecutionContext): Option[SubGoalMessage] = {
                                                {
                            Option.empty[SubGoalMessage]
                            }
                        }
          override def create_unbelief_message(t: StructTerm, ref: IMessageSource) (implicit executionContext: ExecutionContext): Option[SubGoalMessage] = {
                                                         {
                                     Option.empty[SubGoalMessage]
                                     }
                                 }



        }


      object adopt_belief_belief_3 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "Y" -> params.l_params(0))
                          vars +=(   "Z" -> params.l_params(1))
                          vars +=(   "A" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm("trust",Seq[GenericTerm](vars("Y"),vars("X"))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y"),vars("Z"),vars("A")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("belief",Seq[GenericTerm](vars("X"),vars("Z"),vars("A")))),GoalParser)
                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }


      }

      object adopt_belief_belief_4 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "Y" -> params.l_params(0))
                          vars +=(   "Z" -> params.l_params(1))
                          vars +=(   "A" -> params.l_params(2))
                          vars +=(   "B" -> params.l_params(3))

                         val r0 = executionContext.beliefBase.query(StructTerm("trust",Seq[GenericTerm](vars("Y"),vars("X"))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y"),vars("Z"),vars("A"),vars("B")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("belief",Seq[GenericTerm](vars("X"),vars("Z"),vars("A"),vars("B")))),GoalParser)
                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }


      }

      object adopt_belief_belief_5 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "Y" -> params.l_params(0))
                          vars +=(   "Z" -> params.l_params(1))
                          vars +=(   "A" -> params.l_params(2))
                          vars +=(   "B" -> params.l_params(3))
                          vars +=(   "C" -> params.l_params(4))

                         val r0 = executionContext.beliefBase.query(StructTerm("trust",Seq[GenericTerm](vars("Y"),vars("X"))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y"),vars("Z"),vars("A"),vars("B"),vars("C")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("belief",Seq[GenericTerm](vars("X"),vars("Z"),vars("A"),vars("B"),vars("C")))),GoalParser)
                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }


      }

      object adopt_belief_belief_6 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "Y" -> params.l_params(0))
                          vars +=(   "Z" -> params.l_params(1))
                          vars +=(   "A" -> params.l_params(2))
                          vars +=(   "B" -> params.l_params(3))
                          vars +=(   "C" -> params.l_params(4))
                          vars +=(   "D" -> params.l_params(5))

                         val r0 = executionContext.beliefBase.query(StructTerm("trust",Seq[GenericTerm](vars("Y"),vars("X"))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y"),vars("Z"),vars("A"),vars("B"),vars("C"),vars("D")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("belief",Seq[GenericTerm](vars("X"),vars("Z"),vars("A"),vars("B"),vars("C"),vars("D")))),GoalParser)
                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }


      }

      object adopt_belief_belief_7 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "Y" -> params.l_params(0))
                          vars +=(   "Z" -> params.l_params(1))
                          vars +=(   "A" -> params.l_params(2))
                          vars +=(   "B" -> params.l_params(3))
                          vars +=(   "C" -> params.l_params(4))
                          vars +=(   "D" -> params.l_params(5))
                          vars +=(   "E" -> params.l_params(6))

                         val r0 = executionContext.beliefBase.query(StructTerm("trust",Seq[GenericTerm](vars("Y"),vars("X"))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y"),vars("Z"),vars("A"),vars("B"),vars("C"),vars("D"),vars("E")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("belief",Seq[GenericTerm](vars("X"),vars("Z"),vars("A"),vars("B"),vars("C"),vars("D"),vars("E")))),GoalParser)
                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }


      }

      object adopt_belief_ready_0 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          adopt_achievement_update_trustworthiness_0.execute(Parameters(List(  )))


                     }


      }

      object adopt_achievement_update_trustworthiness_0 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                               val ex_L83180 = executionContext.beliefBase.bufferedQuery( StructTerm("agent",Seq[GenericTerm](vars("L83180"))) )
                                               while (ex_L83180.hasNext) {
                                                   val sol_L83180 = ex_L83180.next
                                                   if(sol_L83180.result) {
                                                   vars += ("Agent" -> sol_L83180.bindings("L83180").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_update_benevolence_1.execute(Parameters(List( vars("Agent")  )))
                                                                       adopt_achievement_update_predictability_1.execute(Parameters(List( vars("Agent")  )))
                                                                       adopt_achievement_update_competence_1.execute(Parameters(List( vars("Agent")  )))

                                                   }
                                               }
                                           vars -= ("Agent")


                     }


      }

      object adopt_achievement_update_benevolence_1 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("-------------------BENEVOLENCE-------------------------"))))
                                               val ex_L6031 = executionContext.beliefBase.bufferedQuery( StructTerm("offer",Seq[GenericTerm](vars("A"),vars("NewPlan"),vars("OldPlan"),vars("L6031"))) )
                                               while (ex_L6031.hasNext) {
                                                   val sol_L6031 = ex_L6031.next
                                                   if(sol_L6031.result) {
                                                   vars += ("Offer" -> sol_L6031.bindings("L6031").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("We are now updating according to ") + vars("Offer"))  + StringTerm(".")) )))
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("We dont know if ") + vars("Offer"))  + StringTerm(" is accepted. We will try to find out now.")) )))
                                                                       adopt_achievement_evaluate_offer_2.execute(Parameters(List( vars("A") , vars("Offer")  )))

                                                   }
                                               }
                                           vars -= ("Offer")


                     }


      }

      object adopt_achievement_evaluate_offer_2 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Offer" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("offer",Seq[GenericTerm](vars("A"),vars("NewPlan"),vars("OldPlan"),vars("Offer"))),StructTerm("accept",Seq[GenericTerm](vars("A"),vars("Offer"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end



                 //plan 1 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Offer" -> params.l_params(1))

                         val r1 = executionContext.beliefBase.query(StructTerm("reject",Seq[GenericTerm](vars("A"),vars("Offer"),vars("_"))))

                         if (r1.result) {
                             r1.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan1(vars)
                             return
                          }

                          // plan 1 end



                 //plan 2 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Offer" -> params.l_params(1))

                             plan2(vars)
                             return
                          // plan 2 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("The offer was accepted."))))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("intention",Seq[GenericTerm](vars("A"),vars("NewPlan")))),GoalParser)
                                               val ex_L57189 = executionContext.beliefBase.bufferedQuery( StructTerm("value",Seq[GenericTerm](vars("A"),vars("L57189"),vars("NewPlan"),vars("X1"))) )
                                               while (ex_L57189.hasNext) {
                                                   val sol_L57189 = ex_L57189.next
                                                   if(sol_L57189.result) {
                                                   vars += ("Value" -> sol_L57189.bindings("L57189").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("We will check if ") + vars("Value"))  + StringTerm(" is relevant.")) )))
                                                                       adopt_achievement_update_benevolence_accept_4.execute(Parameters(List( vars("A") , vars("Value") , vars("NewPlan") , vars("OldPlan")  )))

                                                   }
                                               }
                                           vars -= ("Value")


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("The offer was rejected."))))
                                               val ex_L56069 = executionContext.beliefBase.bufferedQuery( StructTerm("reject",Seq[GenericTerm](vars("Offer"),vars("L56069"))) )
                                               while (ex_L56069.hasNext) {
                                                   val sol_L56069 = ex_L56069.next
                                                   if(sol_L56069.result) {
                                                   vars += ("Value" -> sol_L56069.bindings("L56069").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("It was rejected on the basis of ") + vars("Value"))  + StringTerm(".")) )))
                                                                       adopt_achievement_update_benevolence_reject_3.execute(Parameters(List( vars("A") , vars("Offer") , vars("Value")  )))

                                                   }
                                               }
                                           vars -= ("Value")


                     }
                      def plan2(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("It is not known yet whether ") + vars("A"))  + StringTerm(" accepted or rejected the offer.")) )))


                     }


      }

      object adopt_achievement_update_benevolence_accept_4 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Value" -> params.l_params(1))
                          vars +=(   "NewPlan" -> params.l_params(2))
                          vars +=(   "OldPlan" -> params.l_params(3))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("value",Seq[GenericTerm](vars("A"),vars("Value"),vars("NewPlan"),vars("X1"))),StructTerm("value",Seq[GenericTerm](vars("A"),vars("Value"),vars("OldPlan"),vars("X2"))))),StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("Bmin"),vars("Bmax"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("One of the relevant values was ") + vars("Value"))  + StringTerm(".")) )))
                                           vars += ("B" ->  (vars("X2") - vars("X1")) )
                                          if(( (vars("B") < IntTerm(0)) ).holds) {
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("It seems ") + vars("A"))  + StringTerm(" did not need to sacrifice "))  + vars("Value"))  + StringTerm(" to accept this plan.")) )))
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("Bmin"),vars("Bmax")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),IntTerm(0),vars("Bmax")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm("The previous interval was ") + vars("Bmin"))  + StringTerm(", "))  + vars("Bmax")) )))
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The benefits of the old versus the new plan are ") + vars("X2"))  + StringTerm(" versus "))  + vars("X1"))  + StringTerm(".")) )))
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The new benevolence interval is ") + vars("B"))  + StringTerm(", "))  + vars("Bmax"))  + StringTerm(".")) )))

                                          }
                                                               else if(( (vars("B") > vars("Bmax")) ).holds) {
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("It seems ") + vars("A"))  + StringTerm(" is even more benevolent than you thought was possible.")) )))
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("Bmin"),vars("Bmax")))),GoalParser)
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("B"),IntTerm(1)))),GoalParser)
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The previous interval was ") + vars("Bmin"))  + StringTerm(", "))  + vars("Bmax"))  + StringTerm(".")) )))
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The benefits of the old versus the new plan are ") + vars("X2"))  + StringTerm(" versus "))  + vars("X1"))  + StringTerm(".")) )))
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The new benevolence interval is ") + vars("B"))  + StringTerm(", "))  + IntTerm(1))  + StringTerm(".")) )))

                                                               }

                                           else {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("Bmin"),vars("Bmax")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("B"),vars("Bmax")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The previous interval was ") + vars("Bmin"))  + StringTerm(", "))  + vars("Bmax"))  + StringTerm(".")) )))
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The benefits of the old versus the new plan are ") + vars("X2"))  + StringTerm(" versus "))  + vars("X1"))  + StringTerm(".")) )))
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The new benevolence interval is ") + vars("B"))  + StringTerm(", "))  + vars("Bmax"))  + StringTerm(".")) )))

                                           }


                     }


      }

      object adopt_achievement_update_benevolence_reject_3 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Offer" -> params.l_params(1))
                          vars +=(   "Value" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("offer",Seq[GenericTerm](vars("A"),vars("NewPlan"),vars("OldPlan"),vars("Offer"))),StructTerm("value",Seq[GenericTerm](vars("A"),vars("Value"),vars("NewPlan"),vars("X1"))))),StructTerm("value",Seq[GenericTerm](vars("A"),vars("Value"),vars("OldPlan"),vars("X2"))))),StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("Bmin"),vars("Bmax"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           vars += ("B" ->  (vars("X2") - vars("X1")) )
                                          if(( (vars("B") < IntTerm(0)) ).holds) {
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("Either ") + vars("A"))  + StringTerm(" did not actually reject the offer on the basis of "))  + vars("Value"))  + StringTerm(" or your assesment of his enjoyment of the plans is incorrect.")) )))
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("His benevolence will therefore not be updated according to this information."))))

                                          }
                                                               else if(( (vars("B") < vars("Bmin")) ).holds) {
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Your previous assesment of his benevolence seems to have been too high."))))
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("Bmin"),vars("Bmax")))),GoalParser)
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),IntTerm(0),vars("B")))),GoalParser)
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("The offer was rejected on the basis of ") + vars("Value"))  + StringTerm(".")) )))
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The previous interval was ") + vars("Bmin"))  + StringTerm(", "))  + vars("Bmax"))  + StringTerm(".")) )))
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The benefits of the old versus the new are ") + vars("X2"))  + StringTerm(" versus "))  + vars("X1"))  + StringTerm(".")) )))
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The new benevolence interval is ") + vars("Bmin"))  + StringTerm(", "))  + vars("B"))  + StringTerm(".")) )))

                                                               }

                                           else {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("Bmin"),vars("Bmax")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("benevolence",Seq[GenericTerm](vars("A"),vars("Value"),vars("Bmin"),vars("B")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("The offer was rejected on the basis of ") + vars("Value"))  + StringTerm(".")) )))
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm("The previous interval was ") + vars("Bmin"))  + StringTerm(", "))  + vars("Bmax")) )))
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The benefits of the old versus the new are ") + vars("X2"))  + StringTerm(" versus "))  + vars("X1"))  + StringTerm(".")) )))
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The new benevolence interval is ") + vars("Bmin"))  + StringTerm(", "))  + vars("B"))  + StringTerm(".")) )))

                                           }


                     }


      }

      object adopt_achievement_update_competence_1 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("---------------COMPETENCE----------------"))))
                                               val ex_L84534 = executionContext.beliefBase.bufferedQuery( StructTerm("succes",Seq[GenericTerm](vars("A"),vars("L84534"))) )
                                               while (ex_L84534.hasNext) {
                                                   val sol_L84534 = ex_L84534.next
                                                   if(sol_L84534.result) {
                                                   vars += ("Action" -> sol_L84534.bindings("L84534").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_update_competence_succes_2.execute(Parameters(List( vars("A") , vars("Action")  )))

                                                   }
                                               }
                                           vars -= ("Action")
                                               val ex_L60279 = executionContext.beliefBase.bufferedQuery( StructTerm("failure",Seq[GenericTerm](vars("A"),vars("L60279"),vars("_"))) )
                                               while (ex_L60279.hasNext) {
                                                   val sol_L60279 = ex_L60279.next
                                                   if(sol_L60279.result) {
                                                   vars += ("Action" -> sol_L60279.bindings("L60279").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_update_competence_failures_2.execute(Parameters(List( vars("A") , vars("Action")  )))

                                                   }
                                               }
                                           vars -= ("Action")


                     }


      }

      object adopt_achievement_add_info_3 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("knowledge",Seq[GenericTerm](vars("Action"),vars("Condition"),vars("X"))),StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("High"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end



                 //plan 1 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r1 = executionContext.beliefBase.query(StructTerm("knowledge",Seq[GenericTerm](vars("Action"),vars("Condition"),vars("X"))))

                         if (r1.result) {
                             r1.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan1(vars)
                             return
                          }

                          // plan 1 end



                 //plan 2 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r2 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("resource",Seq[GenericTerm](vars("Action"),vars("Condition"),vars("X"))),StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("High"))))))

                         if (r2.result) {
                             r2.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan2(vars)
                             return
                          }

                          // plan 2 end



                 //plan 3 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r3 = executionContext.beliefBase.query(StructTerm("resource",Seq[GenericTerm](vars("Action"),vars("Condition"),vars("X"))))

                         if (r3.result) {
                             r3.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan3(vars)
                             return
                          }

                          // plan 3 end



                 //plan 4 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r4 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("skill",Seq[GenericTerm](vars("Action"),vars("Condition"),vars("X"))),StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("High"))))))

                         if (r4.result) {
                             r4.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan4(vars)
                             return
                          }

                          // plan 4 end



                 //plan 5 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r5 = executionContext.beliefBase.query(StructTerm("skill",Seq[GenericTerm](vars("Action"),vars("Condition"),vars("X"))))

                         if (r5.result) {
                             r5.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan5(vars)
                             return
                          }

                          // plan 5 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          if(( ( (vars("X") >= vars("Low"))  &&  (vars("X") < vars("High")) ) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("High")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Condition"),vars("X"),vars("High")))),GoalParser)

                                          }


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Condition"),vars("X"),IntTerm(1)))),GoalParser)


                     }
                      def plan2(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          if(( ( (vars("X") >= vars("Low"))  &&  (vars("X") < vars("High")) ) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("High")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Condition"),vars("X"),vars("High")))),GoalParser)

                                          }


                     }
                      def plan3(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Condition"),vars("X"),IntTerm(1)))),GoalParser)


                     }
                      def plan4(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          if(( ( (vars("X") >= vars("Low"))  &&  (vars("X") < vars("High")) ) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("High")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Condition"),vars("X"),vars("High")))),GoalParser)

                                          }


                     }
                      def plan5(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Condition"),vars("X"),IntTerm(1)))),GoalParser)


                     }


      }

      object adopt_achievement_update_competence_succes_2 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm("intention",Seq[GenericTerm](vars("A"),vars("Action"))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (vars("A") + StringTerm(" intended to go "))  + vars("Action"))  + StringTerm(" and succeeded.")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("competent",Seq[GenericTerm](vars("A"),vars("Action")))),GoalParser)
                                               val ex_L88887 = executionContext.beliefBase.bufferedQuery( StructTerm("knowledge",Seq[GenericTerm](vars("Action"),vars("L88887"),vars("X"))) )
                                               while (ex_L88887.hasNext) {
                                                   val sol_L88887 = ex_L88887.next
                                                   if(sol_L88887.result) {
                                                   vars += ("Knowledge" -> sol_L88887.bindings("L88887").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_add_info_3.execute(Parameters(List( vars("A") , vars("Action") , vars("Knowledge")  )))

                                                   }
                                               }
                                           vars -= ("Knowledge")
                                               val ex_L35767 = executionContext.beliefBase.bufferedQuery( StructTerm("resource",Seq[GenericTerm](vars("Action"),vars("L35767"),vars("X"))) )
                                               while (ex_L35767.hasNext) {
                                                   val sol_L35767 = ex_L35767.next
                                                   if(sol_L35767.result) {
                                                   vars += ("Resource" -> sol_L35767.bindings("L35767").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_add_info_3.execute(Parameters(List( vars("A") , vars("Action") , vars("Resource")  )))

                                                   }
                                               }
                                           vars -= ("Resource")
                                               val ex_L73009 = executionContext.beliefBase.bufferedQuery( StructTerm("skill",Seq[GenericTerm](vars("Action"),vars("L73009"),vars("X"))) )
                                               while (ex_L73009.hasNext) {
                                                   val sol_L73009 = ex_L73009.next
                                                   if(sol_L73009.result) {
                                                   vars += ("Skill" -> sol_L73009.bindings("L73009").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_add_info_3.execute(Parameters(List( vars("A") , vars("Action") , vars("Skill")  )))

                                                   }
                                               }
                                           vars -= ("Skill")
                                               val ex_L58903 = executionContext.beliefBase.bufferedQuery( StructTerm("subplan",Seq[GenericTerm](vars("Action"),vars("L58903"))) )
                                               while (ex_L58903.hasNext) {
                                                   val sol_L58903 = ex_L58903.next
                                                   if(sol_L58903.result) {
                                                   vars += ("Subaction" -> sol_L58903.bindings("L58903").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (vars("A") + StringTerm(" intended to go "))  + vars("Subaction"))  + StringTerm(" and succeeded.")) )))
                                                                        BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("competent",Seq[GenericTerm](vars("A"),vars("Subaction")))),GoalParser)
                                                                            val ex_L52175 = executionContext.beliefBase.bufferedQuery( StructTerm("knowledge",Seq[GenericTerm](StructTerm("subaction",Seq[GenericTerm]()),vars("L52175"),vars("X"))) )
                                                                            while (ex_L52175.hasNext) {
                                                                                val sol_L52175 = ex_L52175.next
                                                                                if(sol_L52175.result) {
                                                                                vars += ("Knowledge" -> sol_L52175.bindings("L52175").asInstanceOf[GenericTerm])
                                                                                                     BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Knowledge"),vars("X")))),GoalParser)

                                                                                }
                                                                            }
                                                                        vars -= ("Knowledge")
                                                                            val ex_L78085 = executionContext.beliefBase.bufferedQuery( StructTerm("resource",Seq[GenericTerm](vars("Subaction"),vars("L78085"))) )
                                                                            while (ex_L78085.hasNext) {
                                                                                val sol_L78085 = ex_L78085.next
                                                                                if(sol_L78085.result) {
                                                                                vars += ("Resource" -> sol_L78085.bindings("L78085").asInstanceOf[GenericTerm])
                                                                                                     BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Resource"),vars("X")))),GoalParser)

                                                                                }
                                                                            }
                                                                        vars -= ("Resource")
                                                                            val ex_L44666 = executionContext.beliefBase.bufferedQuery( StructTerm("skill",Seq[GenericTerm](vars("Subaction"),vars("L44666"),vars("X"))) )
                                                                            while (ex_L44666.hasNext) {
                                                                                val sol_L44666 = ex_L44666.next
                                                                                if(sol_L44666.result) {
                                                                                vars += ("Skill" -> sol_L44666.bindings("L44666").asInstanceOf[GenericTerm])
                                                                                                     BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Skill"),vars("X")))),GoalParser)

                                                                                }
                                                                            }
                                                                        vars -= ("Skill")

                                                   }
                                               }
                                           vars -= ("Subaction")


                     }


      }

      object adopt_achievement_update_competence_failures_2 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm("intention",Seq[GenericTerm](vars("A"),vars("Action"))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (vars("A") + StringTerm(" intended to go "))  + vars("Action"))  + StringTerm(" and failed.")) )))
                                               val ex_L63004 = executionContext.beliefBase.bufferedQuery( StructTerm("failure",Seq[GenericTerm](vars("A"),vars("Action"),vars("L63004"))) )
                                               while (ex_L63004.hasNext) {
                                                   val sol_L63004 = ex_L63004.next
                                                   if(sol_L63004.result) {
                                                   vars += ("Reason" -> sol_L63004.bindings("L63004").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (vars("A") + StringTerm(" failed because of "))  + vars("Reason"))  + StringTerm(".")) )))
                                                                       adopt_achievement_update_competence_failure_3.execute(Parameters(List( vars("A") , vars("Action") , vars("Reason")  )))

                                                   }
                                               }
                                           vars -= ("Reason")


                     }


      }

      object adopt_achievement_update_competence_failure_3 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("resource",Seq[GenericTerm](vars("Action"),vars("Condition"),vars("X"))),StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("High"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end



                 //plan 1 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r1 = executionContext.beliefBase.query(StructTerm("resource",Seq[GenericTerm](vars("Action"),vars("Condition"),vars("X"))))

                         if (r1.result) {
                             r1.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan1(vars)
                             return
                          }

                          // plan 1 end



                 //plan 2 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r2 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("knowledge",Seq[GenericTerm](vars("Action"),vars("Condition"),vars("X"))),StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("High"))))))

                         if (r2.result) {
                             r2.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan2(vars)
                             return
                          }

                          // plan 2 end



                 //plan 3 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r3 = executionContext.beliefBase.query(StructTerm("knowledge",Seq[GenericTerm](vars("Action"),vars("Condition"),vars("X"))))

                         if (r3.result) {
                             r3.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan3(vars)
                             return
                          }

                          // plan 3 end



                 //plan 4 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r4 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("skill",Seq[GenericTerm](vars("Action"),vars("Condition"),vars("X"))),StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("High"))))))

                         if (r4.result) {
                             r4.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan4(vars)
                             return
                          }

                          // plan 4 end



                 //plan 5 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Action" -> params.l_params(1))
                          vars +=(   "Condition" -> params.l_params(2))

                         val r5 = executionContext.beliefBase.query(StructTerm("skill",Seq[GenericTerm](vars("Action"),vars("Condition"),vars("X"))))

                         if (r5.result) {
                             r5.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan5(vars)
                             return
                          }

                          // plan 5 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          if(( ( (vars("X") < vars("High"))  &&  (vars("X") > vars("Low")) ) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("High")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("X")))),GoalParser)

                                          }
                                                               else if(( (vars("X") <= vars("Low")) ).holds) {
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("High")))),GoalParser)
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Condition"),IntTerm(0),vars("X")))),GoalParser)

                                                               }



                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("resource",Seq[GenericTerm](vars("A"),vars("Condition"),IntTerm(0),vars("X")))),GoalParser)


                     }
                      def plan2(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          if(( ( (vars("X") < vars("High"))  &&  (vars("X") > vars("Low")) ) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("X")))),GoalParser)

                                          }
                                                               else if(( (vars("X") <= vars("Low")) ).holds) {
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("High")))),GoalParser)
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Condition"),IntTerm(0),vars("X")))),GoalParser)

                                                               }



                     }
                      def plan3(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("knowledge",Seq[GenericTerm](vars("A"),vars("Condition"),IntTerm(0),vars("X")))),GoalParser)


                     }
                      def plan4(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          if(( ( (vars("X") < vars("High"))  &&  (vars("X") > vars("Low")) ) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("X")))),GoalParser)

                                          }
                                                               else if(( (vars("X") <= vars("Low")) ).holds) {
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Condition"),vars("Low"),vars("High")))),GoalParser)
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Condition"),IntTerm(0),vars("X")))),GoalParser)

                                                               }



                     }
                      def plan5(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("skill",Seq[GenericTerm](vars("A"),vars("Condition"),IntTerm(0),vars("X")))),GoalParser)


                     }


      }

      object adopt_achievement_update_predictability_1 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "Agent" -> params.l_params(0))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("-------------------PREDICTABILITY---------------------"))))
                                               val ex_L39732 = executionContext.beliefBase.bufferedQuery( StructTerm("intention",Seq[GenericTerm](vars("Agent"),vars("L39732"))) )
                                               while (ex_L39732.hasNext) {
                                                   val sol_L39732 = ex_L39732.next
                                                   if(sol_L39732.result) {
                                                   vars += ("Plan" -> sol_L39732.bindings("L39732").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (vars("Agent") + StringTerm(" intends to do "))  + vars("Plan"))  + StringTerm(".")) )))
                                                                       adopt_achievement_get_principle_intention_2.execute(Parameters(List( vars("Agent") , vars("Plan")  )))
                                                                            val ex_L14626 = executionContext.beliefBase.bufferedQuery( StructTerm("subplan",Seq[GenericTerm](vars("Plan"),vars("L14626"))) )
                                                                            while (ex_L14626.hasNext) {
                                                                                val sol_L14626 = ex_L14626.next
                                                                                if(sol_L14626.result) {
                                                                                vars += ("Subplan" -> sol_L14626.bindings("L14626").asInstanceOf[GenericTerm])
                                                                                                    adopt_achievement_get_principle_intention_2.execute(Parameters(List( vars("Agent") , vars("Subplan")  )))

                                                                                }
                                                                            }
                                                                        vars -= ("Subplan")

                                                   }
                                               }
                                           vars -= ("Plan")


                     }


      }

      object adopt_achievement_get_principle_intention_2 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "Agent" -> params.l_params(0))
                          vars +=(   "Plan" -> params.l_params(1))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                               val ex_L45550 = executionContext.beliefBase.bufferedQuery( StructTerm("principle",Seq[GenericTerm](vars("Agent"),vars("L45550"),vars("_"))) )
                                               while (ex_L45550.hasNext) {
                                                   val sol_L45550 = ex_L45550.next
                                                   if(sol_L45550.result) {
                                                   vars += ("P" -> sol_L45550.bindings("L45550").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_get_weight_3.execute(Parameters(List( vars("Agent") , vars("P") , vars("Plan")  )))

                                                   }
                                               }
                                           vars -= ("P")


                     }


      }

      object adopt_achievement_get_weight_3 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "Agent" -> params.l_params(0))
                          vars +=(   "P" -> params.l_params(1))
                          vars +=(   "Plan" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("principle",Seq[GenericTerm](vars("Agent"),vars("P"),vars("X1"))),StructTerm("value",Seq[GenericTerm](vars("Plan"),vars("P"),vars("X2"))))),StructTerm("insincere",Seq[GenericTerm](vars("Agent"),vars("P"),vars("X3"))))),StructTerm("is",Seq[GenericTerm](vars("D"),StructTerm("-",Seq[GenericTerm](vars("X1"),vars("X2"))))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end



                 //plan 1 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "Agent" -> params.l_params(0))
                          vars +=(   "P" -> params.l_params(1))
                          vars +=(   "Plan" -> params.l_params(2))

                         val r1 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("principle",Seq[GenericTerm](vars("Agent"),vars("P"),vars("X1"))),StructTerm("value",Seq[GenericTerm](vars("Plan"),vars("P"),vars("X2"))))),StructTerm("is",Seq[GenericTerm](vars("D"),StructTerm("-",Seq[GenericTerm](vars("X1"),vars("X2"))))))))

                         if (r1.result) {
                             r1.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan1(vars)
                             return
                          }

                          // plan 1 end



                 //plan 2 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "Agent" -> params.l_params(0))
                          vars +=(   "P" -> params.l_params(1))
                          vars +=(   "Plan" -> params.l_params(2))

                             plan2(vars)
                             return
                          // plan 2 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          if(( (vars("D") > vars("X3")) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("insincere",Seq[GenericTerm](vars("Agent"),vars("P"),vars("X3")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("insincere",Seq[GenericTerm](vars("Agent"),vars("P"),vars("D")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( (StringTerm("The intentions of ") + vars("Agent"))  + StringTerm(" show that they deviate "))  + vars("D"))  + StringTerm(" from what I believed about how they value "))  + vars("P"))  + StringTerm(".")) )))

                                          }


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("insincere",Seq[GenericTerm](vars("Agent"),vars("P"),vars("D")))),GoalParser)
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( (StringTerm("The intentions of ") + vars("Agent"))  + StringTerm(" show that they deviate "))  + vars("D"))  + StringTerm(" from what I believed about how they value "))  + vars("P"))  + StringTerm(".")) )))


                     }
                      def plan2(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("insincere",Seq[GenericTerm](vars("Agent"),vars("P"),IntTerm(0)))),GoalParser)
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The intentions of ") + vars("Agent"))  + StringTerm(" do not tell me anything about how they value principle "))  + vars("P"))  + StringTerm(". Their behaviour does not influence how I view their predictability.")) )))


                     }


      }

      object adopt_achievement_is_contradiction_0 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("accept",Seq[GenericTerm]()),vars("A"),vars("B"))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("reject",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end



                 //plan 1 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         val r1 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("failure",Seq[GenericTerm]()),vars("A"),vars("Plan"),vars("B"))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("succes",Seq[GenericTerm]()),vars("A"),vars("Plan"))))))

                         if (r1.result) {
                             r1.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan1(vars)
                             return
                          }

                          // plan 1 end



                 //plan 2 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         val r2 = executionContext.beliefBase.query(StructTerm(";",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("mighthave",Seq[GenericTerm]()),vars("A"),vars("B"))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("hasnot",Seq[GenericTerm]()),vars("A"),vars("B"))))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("has",Seq[GenericTerm]()),vars("A"),vars("B"))))))

                         if (r2.result) {
                             r2.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan2(vars)
                             return
                          }

                          // plan 2 end



                 //plan 3 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         val r3 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("competent",Seq[GenericTerm]()),vars("A"),vars("B"))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("incompetent",Seq[GenericTerm]()),vars("A"),vars("B"))))))

                         if (r3.result) {
                             r3.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan3(vars)
                             return
                          }

                          // plan 3 end



                 //plan 4 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         val r4 = executionContext.beliefBase.query(StructTerm(";",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("unknown",Seq[GenericTerm]()),vars("A"),vars("B"))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("incompetent",Seq[GenericTerm]()),vars("A"),vars("B"))))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("competent",Seq[GenericTerm]()),vars("A"),vars("B"))))))

                         if (r4.result) {
                             r4.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan4(vars)
                             return
                          }

                          // plan 4 end



                 //plan 5 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         val r5 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("value",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"),vars("D"))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("value",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"),vars("E"))))),StructTerm("\\=",Seq[GenericTerm](vars("D"),vars("E"))))),StructTerm("is",Seq[GenericTerm](vars("F"),StructTerm("/",Seq[GenericTerm](StructTerm("+",Seq[GenericTerm](StructTerm("*",Seq[GenericTerm](vars("Y1"),vars("D"))),StructTerm("*",Seq[GenericTerm](vars("Y2"),vars("E"))))),StructTerm("+",Seq[GenericTerm](vars("Y1"),vars("Y2"))))))))))

                         if (r5.result) {
                             r5.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan5(vars)
                             return
                          }

                          // plan 5 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          if(( (vars("Y1") > vars("Y2")) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("reject",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction."))))

                                          }
                                                               else if(( (vars("Y2") > vars("Y1")) ).holds) {
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("accept",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction."))))

                                                               }

                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          if(( (vars("Y1") > vars("Y2")) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("succes",Seq[GenericTerm]()),vars("A"),vars("Plan")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction."))))

                                          }
                                                               else if(( (vars("Y2") > vars("Y1")) ).holds) {
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("failure",Seq[GenericTerm]()),vars("A"),vars("Plan"),vars("B")))),GoalParser)
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction"))))

                                                               }

                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }
                      def plan2(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          if(( (vars("Y1") > vars("Y2")) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("hasnot",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("has",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction."))))

                                          }
                                                               else if(( (vars("Y2") > vars("Y1")) ).holds) {
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("mighthave",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction"))))

                                                               }

                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }
                      def plan3(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          if(( (vars("Y1") > vars("Y2")) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("incompetent",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("COntradiction."))))

                                          }
                                                               else if(( (vars("Y2") > vars("Y1")) ).holds) {
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("competent",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction"))))

                                                               }

                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }
                      def plan4(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          if(( (vars("Y1") > vars("Y2")) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("incompetent",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("competent",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction."))))

                                          }
                                                               else if(( (vars("Y2") > vars("Y1")) ).holds) {
                                                                                          BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("unknown",Seq[GenericTerm]()),vars("A"),vars("B")))),GoalParser)
                                                                                         PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Contradiction"))))

                                                               }

                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }
                      def plan5(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("There was a contradiction between something."))))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("value",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"),vars("D")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("value",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"),vars("E")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("value",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"),vars("F")))),GoalParser)
                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }


      }

      object adopt_achievement_is_contradiction_3 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Rumour1" -> params.l_params(1))
                          vars +=(   "Rumour2" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("principle",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C"))),StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("principle",Seq[GenericTerm]()),vars("A"),vars("B"),vars("D"))))),StructTerm("\\=",Seq[GenericTerm](vars("C"),vars("D"))))),StructTerm("is",Seq[GenericTerm](vars("E"),StructTerm("/",Seq[GenericTerm](StructTerm("+",Seq[GenericTerm](StructTerm("*",Seq[GenericTerm](vars("Y1"),vars("C"))),StructTerm("*",Seq[GenericTerm](vars("Y2"),vars("D"))))),StructTerm("+",Seq[GenericTerm](vars("Y1"),vars("Y2"))))))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("There was a contradiction between something."))))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("principle",Seq[GenericTerm]()),vars("A"),vars("B"),vars("C")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("belief",Seq[GenericTerm](vars("Y2"),StructTerm("principle",Seq[GenericTerm]()),vars("A"),vars("B"),vars("D")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("belief",Seq[GenericTerm](vars("Y1"),StructTerm("principle",Seq[GenericTerm]()),vars("A"),vars("B"),vars("E")))),GoalParser)
                                          adopt_achievement_is_contradiction_0.execute(Parameters(List(  )))


                     }


      }





 }
object agent_companion { 
   def create() = new agent().agentBuilder 
   def create(in_coms : AgentCommunicationLayer) = new agent(coms = in_coms).agentBuilder 
   def create(in_beliefBaseFactory: IBeliefBaseFactory) = new agent(beliefBaseFactory = in_beliefBaseFactory).agentBuilder 
   def create(in_coms : AgentCommunicationLayer, in_beliefBaseFactory: IBeliefBaseFactory) = new agent(coms = in_coms, beliefBaseFactory = in_beliefBaseFactory).agentBuilder 
} 
