package com.wixpress.workshop.http

import com.wixpress.workshop.utils.HttpClient.Response
import com.wixpress.workshop.utils.{HttpClient, JsonUtil, OptionOps}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

object Solution4 extends App with OptionOps with HeaderOps {

  val result = for {
    Response(_, _, Some(body)) <- HttpClient.get("http://localhost:8080/stream/3")
    lines                       = body.split("\n").toList
    payloads                    = lines.map(JsonUtil.fromJson[Payload])
  } yield payloads

  val future = result.map(_.mkString("\n")).map(println)

  Await.result(future, 10.seconds)
}