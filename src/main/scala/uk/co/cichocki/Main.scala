package uk.co.cichocki

import uk.co.cichocki.inheritance.{Communicative, Creature, Human}

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success}

object Main extends App {

  val ww = new PersonWithId("dupa") {
    override def id: String = "whatever"
  }
//  Car("mercedes").doStuff()
//  println("Hello, World! " + args.length)
//  val str = TrafficLightColor.values.mkString(" ")
//  val h = Human()
//  val a = h.isInstanceOf[Creature]
//  val b = h.getClass == classOf[Creature]
//  println(s"a=$a b=$b")
//
//  val descr = h match {
//    case _: Communicative => "comm"
//    case _: Human => "human"
//  }
//  println(ww.id)
implicit val ec = ExecutionContext.global
  val f: Future[Int] = Future {
    Thread.sleep(2000)
    100
  }.map(a => a + 9)
    f.onComplete {
    case Success(value) => println(value)
    case Failure(exception) => println(exception.getMessage)
  }

  import scala.concurrent.duration._
  private val i: Int = Await.result(f, 100 minutes)
  println(s"i=$i")
}
