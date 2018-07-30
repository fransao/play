package controllers


import javax.inject._
import modelo.ParqueoVehiculo
import modelo.User
import persistence.UserRepository
import play.api.mvc._
import play.cache.AsyncCacheApi
import play.api.libs.json.Json

import scala.concurrent.Future

class CacheController @Inject() (cache: AsyncCacheApi, userRepository: UserRepository, cc:ControllerComponents) extends AbstractController(cc) {

  Ok("Hello World!").withSession("usuario.conectado" -> "francisco")
/*
  val connectedUser = new User("francisco","12345")
  //val result: Future[Done] = cache.set("item.key", connectedUser)

  // retrieve
  /*Future[Option[User]] = cache.get[User]("item.key"){
    ParqueoVehiculo.findById("XTS456")
  }*/

  //To remove an item from the cache use the remove method:
  //val removeResult: Future[Done] = cache.remove("item.key")

  //To remove all items from the cache use the removeAll method:
  //val removeAllResult: Future[Done] = cache.removeAll()

    // ------------
  /*def indexuser(name: String) = DBAction { implicit rs =>
    val users  = Query(Users).filter(name === name)
    Ok(views.html.index(users.list))
  }*/


  // -------------
  populateDate()


  def index() = Action.async { implicit request: Request[AnyContent] =>

    val fCoffees: Future[Seq[User]] = userRepository.all()

    fCoffees.map(s => Ok( Json.toJson(s) ))
  }

  def lower(limit: Int) = Action.async { implicit request: Request[AnyContent] =>

    val fUsers: Future[Seq[User]] = userRepository.lower(limit)

    fUsers.map(s => Ok( Json.toJson(s) ))
  }

  def add() = Action.async(parse.json[User]) { request =>
    insertUser(request.body)
  }

  private def insertUser(user: User): Future[Result] = {
    userRepository.insert(user)
      .map(_ => Ok(""))
      .recoverWith {
        case _: Exception => Future.successful( InternalServerError("No pudo guardarse el registro") )
      }
  }

  private def populateDate() {
    insertUser(new User("francisco", "12345"))
    insertUser(new User("javier", "13245"))
  }
*/
}
