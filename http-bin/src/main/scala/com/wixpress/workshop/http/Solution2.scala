package com.wixpress.workshop.http

import com.wixpress.workshop.utils.{HttpClient, OptionOps}

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object Solution2 extends App with OptionOps with HeaderOps {

  val result = for {
    response1 <- HttpClient.get(s"http://localhost:8080/redirect-to?url=http%3A%2F%2Flocalhost%3A8080%2Fuuid&status_code=200")
    if response1.status == 302
    location <- response1.getHeader("location").toFuture
    response2 <- HttpClient.get(location)
    body <- response2.body.toFuture
  } yield println(body)

  Await.result(result, 10.seconds)
}