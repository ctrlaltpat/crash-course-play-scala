package controllers

import model.{MyForm, PureScala2}
import model.MyForm._

import javax.inject._
import play.api._
import play.api.libs.json.JsValue
import play.api.libs.json._
import play.api.mvc._

import scala.Predef.println

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def form(): Action[MyForm] = Action(parse.json[MyForm]) { implicit request: Request[MyForm] =>
//    implicit val x = request

    val s: String = PureScala2.mySecondImplicit
//    Ok(s"Welcome, ${request.body.name}!")
    Ok(s)
  }
}
