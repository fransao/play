package models

import play.api.libs.json.Json

case class User(name: String, password: String)

object User {
 implicit val cofffeFormat = Json.format[User]
}
