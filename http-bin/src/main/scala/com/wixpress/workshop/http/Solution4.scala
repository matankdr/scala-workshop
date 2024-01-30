package com.wixpress.workshop.http

import com.wixpress.workshop.utils.{EitherOps, JsonUtil}
import sttp.client3._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

object Solution4 extends App with EitherOps {

  val backend = HttpClientFutureBackend()

  val request = basicRequest.get(uri"http://localhost:8080/stream/3")

  val futurePayloads = for {
    response <- request.send(backend)
    body     <- response.body.toFuture
    lines    <- Future.sequence(body.split("\n").toList.map(Future.successful))
    payloads  = lines.map(JsonUtil.fromJson[Payload])
  } yield payloads

  val future = futurePayloads.map(_.mkString("\n")).map(println)

  Await.result(future, 10.seconds)
}