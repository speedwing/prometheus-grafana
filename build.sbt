name := """prometheus-grafana"""
organization := "com.github.speedwing"

version := "0.1"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.8"

val prometheusLibVersion = "0.9.0-M5"

libraryDependencies += guice
libraryDependencies ++= Seq(
  "org.lyranthe.prometheus" %% "client" % prometheusLibVersion,
  "org.lyranthe.prometheus" %% "play26" % prometheusLibVersion,
  "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.1" % Test
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.github.speedwing.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.github.speedwing.binders._"
