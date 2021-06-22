package io.mahesh

import akka.actor.typed.ActorRef
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.Behavior
import io.mahesh.Notifer.Notification
import io.mahesh.VaccineDistributor.Vaccine
import io.mahesh.WhoCollector.Country


object Notifer {
  final case class Notification(message: String, donation: Long)
  def apply() : Behavior[Notification] = Behaviors.receive{
    (context, message) =>
        context.log.info(s"${message}")
      Behaviors.same
  }
}

object VaccineDistributor {

  final case class Vaccine(country: String, volume: Long, replyTo: ActorRef[Notification])

  def apply() : Behavior[Vaccine] = Behaviors.receive {
    (context,message) =>
        context.log.info(s"${message}")
      message.replyTo ! Notification(s"New shipment of vaccine to ${message.country}", message.volume)
      Behaviors.same
  }
}


object WhoCollector {
  final case class Country (country: String, postiveCases: Int)

  def apply() : Behavior[Country] = Behaviors.setup {
    context =>
     val vaccineDbtorRef = context.spawn(VaccineDistributor(),"vaccine")
      val notiferRef = context.spawn(Notifer(),"notifer")
      Behaviors.receiveMessage {
        message =>
          println(message.toString)
          context.log.info(message.toString)
          vaccineDbtorRef ! Vaccine(message.country, message.postiveCases, notiferRef)
          Behaviors.same
      }


  }
}

object Main extends App {
  val whoCollector : ActorSystem[WhoCollector.Country] = ActorSystem(WhoCollector(), "collector")
  whoCollector ! Country("US", 100)
  whoCollector ! Country("SG", 100)
  whoCollector ! Country("SL", 100)


}