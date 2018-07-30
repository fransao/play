package controllers

import javax.inject._
import scala.concurrent.Future
import scala.concurrent.duration._

import play.api.mvc._
import play.api.libs.ws._
import play.api.http.HttpEntity

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl._
import akka.util.ByteString

import scala.concurrent.ExecutionContext

class WsClientController @Inject()(ws: WSClient) extends Controller {

  val request: WSRequest = ws.url("localhost:9000")

}

