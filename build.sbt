ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.0"

lazy val root = (project in file("."))
  .settings(
    name := "coverage-testing"
  )
/*
coverageEnabled := true
*/
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % "test"
libraryDependencies += "org.scala-lang" % "scala-xml" % "2.11.0-M4"
libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "2.0.1"
ThisBuild / scapegoatVersion := "1.3.9"
scapegoatReports := Seq("none")
scalacOptions in Scapegoat += "-P:scapegoat:overrideLevels:all=Warning"


