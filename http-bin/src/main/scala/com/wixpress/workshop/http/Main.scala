package com.wixpress.workshop.http

import sttp.client3._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

object Main extends App {
  val backend = HttpClientFutureBackend()

  val query = "http language:scala"
  val sort: Option[String] = None

  val request = basicRequest.get(
    uri"https://api.github.com/search/repositories?q=$query&sort=$sort")

  val future = for {
    response      <- request.send(backend)
    contentLength  = response.header("Content-Length")
    body           = response.body
  } yield {
    println(s"contentLength = ${contentLength}")
    println(s"body = ${body}")
  }

  Await.result(future, 10.seconds)
}
