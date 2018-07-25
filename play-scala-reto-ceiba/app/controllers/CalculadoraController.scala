package controllers

import javax.inject._
import play.api.mvc._
import services.{Calculadora, Counter}

/**
 * This controller demonstrates how to use dependency injection to
 * bind a component into a controller class. The class creates an
 * `Action` that shows an incrementing count to users. The [[Counter]]
 * object is injected by the Guice dependency injection system.
 */
@Singleton
class CalculadoraController @Inject()(cc: ControllerComponents, calculadora: Calculadora) extends AbstractController(cc) {

  /**
   * Create an action that responds with the [[Calculadora]]'s current
   * count. The result is plain text. This `Action` is mapped to
   * `GET /count` requests by an entry in the `routes` config file.
   */
  def sum  = Action { Ok(calculadora.sum(1,1).toString) }
  def rest = Action { Ok(calculadora.rest(1,1).toString) }
  def mul  = Action { Ok(calculadora.mul(1,1).toString) }
  def div  = Action { Ok(calculadora.div(1,1).toString) }

}
