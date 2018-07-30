package persistence

import javax.inject.{Inject, Singleton}

import models.User
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class UserRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  private val Users = TableQuery[UsersTable]

  def all() : Future[Seq[User]] = db.run(Users.result)

  def findById(name:String): Future[User] = db.run(Users.filter(_.name == name).result.head)

  def insert(user: User): Future[Unit] = db.run(Users += user).map { _ => () }

  def lower(limit: Int): Future[Seq[User]] = db.run(Users.filter(_.name < limit.toString).result)


  private class UsersTable(tag: Tag) extends Table[User](tag, "USER") {

    def name = column[String]("NAME", O.PrimaryKey)
    def password = column[String]("PASSWORD")

    def * = (name, password) <> ( (User.apply _).tupled, User.unapply)

    def add(user: User)(implicit session: Session) = {
      insert(user)
    }

  }

}
