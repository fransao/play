import controllers.CalculadoraController
import org.scalatestplus.play.PlaySpec
import services.{Calculadora, OpeCalculadora}
import play.api.test.FakeRequest
import play.api.test.Helpers._

class CalculadoraTest extends PlaySpec{

  "CalculadoraController" should {
    "return la suma con un valid result with action" in {
      val calculadora: OpeCalculadora = new OpeCalculadora
      val controller = new CalculadoraController(stubControllerComponents(), calculadora)
      val result = controller.sum(FakeRequest())
      contentAsString(result) must equal("2")
    }

    "return la resta con un valid result with action" in {
      val calculadora: OpeCalculadora = new OpeCalculadora
      val controller = new CalculadoraController(stubControllerComponents(), calculadora)
      val result = controller.rest(FakeRequest())
      contentAsString(result) must equal("0")
    }

    "return la multiplicacion con un valid result with action" in {
      val calculadora: OpeCalculadora = new OpeCalculadora
      val controller = new CalculadoraController(stubControllerComponents(), calculadora)
      val result = controller.mul(FakeRequest())
      contentAsString(result) must equal("1")
    }

    "return la division con un valid result with action" in {
      val calculadora: OpeCalculadora = new OpeCalculadora
      val controller = new CalculadoraController(stubControllerComponents(), calculadora)
      val result = controller.div(FakeRequest())
      contentAsString(result) must equal("1")
    }
  }
}
