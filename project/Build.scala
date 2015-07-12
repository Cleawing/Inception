import org.stormenroute.mecha._
import sbt._
import sbt.Keys._

object Build extends MechaRepoBuild {
  lazy val buildSettings = Defaults.coreDefaultSettings ++
    MechaRepoPlugin.defaultSettings ++ Seq(
    name := "inception",
    scalaVersion := "2.11.7",
    version := "0.1",
    organization := "com.cleawing",
    libraryDependencies ++= superRepoDependencies("inception") ++
      Seq(Dependencies.scalaTest, Dependencies.scalazScalaTest)
  )

  def repoName = "inception"

  lazy val finagleServices: Project = Project(
    "inception",
    file("."),
    settings = buildSettings
  ) dependsOnSuperRepo
}
