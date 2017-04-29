name := """StreamMonitor"""
organization := "com.toshp"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  filters,
  cache,
  javaJdbc,
  javaWs,
  "mysql" % "mysql-connector-java" % "5.1.27"
)
