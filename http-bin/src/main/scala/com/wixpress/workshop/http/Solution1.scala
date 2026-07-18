package com.wixpress.workshop.http

import com.wixpress.workshop.utils.{HttpClient, OptionOps}

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object Solution1 extends App with OptionOps {
  val encoded = "dmVsbyBpcyBhd2Vzb21lISEhISEK"

  val result = for {
    response <- HttpClient.get(s"http://localhost:8080/base64/$encoded")
    body <- response.body.toFuture
  } yield println(body)

  Await.result(result, 10.seconds)
}
