ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.15"

ThisBuild / libraryDependencies += "org.scalactic" %% "scalactic" % "3.1.0"
ThisBuild / libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % "test"

lazy val root = (project in file("."))
  .settings(
    name := "Codility"
  )
