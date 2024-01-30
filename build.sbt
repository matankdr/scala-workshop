ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.16"

lazy val root = (project in file("."))
  .settings(
    name := "scala-workshop"
  )

lazy val httpBin = (project in file("http-bin"))
  .settings(
    libraryDependencies ++= Seq(
//      "com.softwaremill.sttp.client3" %% "core" % "3.3.15",
//      "com.softwaremill.sttp" %% "async-http-client-backend-future" % "3.3.15",
      "com.softwaremill.sttp.client3" %% "core" % "3.9.2",
      "com.softwaremill.sttp.client3" %% "async-http-client-backend-future" % "3.9.2",
      "com.fasterxml.jackson.core" % "jackson-core" % "2.16.1",
      "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.16.1",
      "com.fasterxml.jackson.core" % "jackson-databind" % "2.16.1",
    )
  )
