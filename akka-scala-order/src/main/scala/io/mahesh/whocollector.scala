package io.mahesh

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.Behavior
import io.mahesh.VaccineDistributor.Vaccine
import io.mahesh.WhoCollector.Country


object RegionalCountry {
  final case class 
}

object VaccineDistributor {

  final case class Vaccine(country: String, volume: Long)

  def apply() : Behavior[Vaccine] = Behaviors.receive {
    (context,message) =>
        context.log.info(s"${message}")
      Behaviors.same
  }
}


object WhoCollector {
  final case class Country (country: String, postiveCases: Int)

  def apply() : Behavior[Country] = Behaviors.setup {
    context =>
     val vaccineDbtorRef = context.spawn(VaccineDistributor(),"vaccine")
      Behaviors.receiveMessage {
        message =>
          println(message.toString)
          context.log.info(message.toString)
          vaccineDbtorRef ! Vaccine(message.country, message.postiveCases)
          Behaviors.same
      }


  }
}

object Main extends App {
  println("hello")
  val whoCollector : ActorSystem[WhoCollector.Country] = ActorSystem(WhoCollector(), "collector")
  whoCollector ! Country("US", 100)
  whoCollector ! Country("SG", 100)
  whoCollector ! Country("SL", 100)


}