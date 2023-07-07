package model

import play.api.http.Writeable
import play.api.libs.json._
import play.api.mvc.Request

case class MyForm(
  name: String
)
object MyForm {
  implicit val MyFormFormats: Format[MyForm] = Json.format[MyForm]
}

object PureScala extends App {
  def hof(input: Int)(fn: Int => String): String = fn.apply(input)
  def hof2(input: Int)(fn: Function1[Int, String]): String = fn.apply(input)
  def intStringifier(input: Int): String = input.toString

  val x = hof(3)(intStringifier)

  val y = hof(3) {
    println("Hello world")
    intStringifier
  }

  println(x)
  println(y)
}

object PureScala2 {
  def myFirstImplicit(implicit request: Request[MyForm]): String = "any old"
  def mySecondImplicit(implicit request: Request[MyForm]): String = s"Welcome, ${request.body.name}"
}