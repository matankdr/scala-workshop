package com.wixpress.workshop.http

import com.wixpress.workshop.utils.HttpClient

trait HeaderOps {
  implicit class HeaderOps(response: HttpClient.Response) {
    def getHeader(name: String): Option[String] = {
      response.headers.collectFirst { case (key, value) if key.toLowerCase == name.toLowerCase => value}
    }
  }
}