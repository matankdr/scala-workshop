package com.wixpress.workshop.http

case class Payload(url: String,
                   args: Map[String, String],
                   headers: Map[String, String],
                   origin: String,
                   id: Int)
