
lazy val scala213 = "2.13.5"
lazy val scala212 = "2.12.13"

lazy val supportedScalaVersions = List(scala213, scala212)

ThisBuild / scalaVersion := scala213

lazy val emailaddress = (project in file("."))
  .settings(
    name := "emailaddress",
    crossScalaVersions := supportedScalaVersions,
    scalacOptions ++= Seq(
      "-feature",
      "-language:implicitConversions"
    ),
    libraryDependencies ++= Seq(
      "com.typesafe.play" %% "play-json" % "2.9.2" % Provided,
      "org.scalatest" %% "scalatest" % "3.2.7" % Test,
      "org.pegdown" % "pegdown" % "1.6.0" % Test,
      "org.scalacheck" %% "scalacheck" % "1.14.1" % Test,
      "org.scalatestplus" %% "scalacheck-1-15" % "3.2.7.0" % "test"
    )
  )
