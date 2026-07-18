package com.wixpress.workshop.http

import com.wixpress.workshop.utils.HttpClient.Response
import com.wixpress.workshop.utils.{HttpClient, OptionOps}

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object Solution3 extends App with OptionOps with HeaderOps {

  def sendRequest(url: String) = {
    println(s"sending request to $url")

    for {
      response <- HttpClient.get(url)
      body <- handleRedirect(response)
    } yield body
  }

  def handleRedirect(response: HttpClient.Response): Future[String] = {
    (response.status, response.getHeader("location")) match {
      case (302, Some(location)) =>
        sendRequest(location)
      case (200, _) =>
        response.body.toFuture
    }
  }

  val result = sendRequest("http://localhost:8080/absolute-redirect/10").map(println)

  Await.result(result, 10.seconds)
}
