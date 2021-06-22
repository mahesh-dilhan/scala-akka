package io.mahesh

import akka.actor.typed.ActorSystem
import akka.actor.typed.ActorRef
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.Behavior
import io.mahesh.WhoCollector.Country

object WhoCollector {
  final case class Country (country: String, postiveCases: Int)

  def apply() : Behavior[Country] = Behaviors.receiveMessage {
    message =>
        println(message.toString)

      Behaviors.same
  }
}

object Main extends App {
  println("hello")
  val whoCollector : ActorSystem[WhoCollector.Country] = ActorSystem(WhoCollector(), "collector")
  whoCollector ! Country("US", 100)
}