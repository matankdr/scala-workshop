package com.wixpress.workshop.utils

import sttp.client3.HttpClientFutureBackend
import sttp.client3._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object HttpClient {
  private val backend = HttpClientFutureBackend()

  case class Response(status: Int, headers: Map[String, String], body: Option[String])

  def get(url: String, headers: Map[String, String] = Map.empty): Future[Response] = {
    val request = basicRequest
      .followRedirects(false)
      .get(uri"$url")
      .headers(headers)

    sendRequest(request)
  }

  private def sendRequest(request: Request[Either[String, String], Any]) =
    for {
      response <- request.send(backend)
      headers = response.headers.map(header => header.name -> header.value).toMap
    } yield Response(status = response.code.code, headers = headers, body = response.body.toOption)
}
