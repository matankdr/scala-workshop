package com.wixpress.workshop.http

import com.wixpress.workshop.utils.HttpClient

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object Main extends App {

  val query = "http language:scala"
  val sort: Option[String] = None

  val future = for {
    response      <- HttpClient.get(s"https://api.github.com/search/repositories?q=$query&sort=$sort")
    contentLength  = response.headers
      .collectFirst { case (key, value) if key.toLowerCase == "content-length" => value }
    body           = response.body
  } yield {
    println(s"content-length = ${contentLength.getOrElse("none")}")
    println(s"body = ${body}")
  }

  Await.result(future, 10.seconds)
}
