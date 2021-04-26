
lazy val scala213 = "2.13.5"
lazy val scala212 = "2.12.13"

// Update this variable to publish your own release
lazy val githubOwner = "CastleOne"

lazy val supportedScalaVersions = List(scala213, scala212)

ThisBuild / scalaVersion := scala213

lazy val emailaddress = (project in file("."))
  .settings(
    /**
     * ~/.sbt/github-maven.credentials should contain the following:
     * realm=
     * host=maven.pkg.github.com
     * user=<GITHUB USERNAME HERE>
     * password=<GITHUB PERSONAL ACCESS TOKEN HERE>
     * You should be able to publish your version using `sbt + publish`
     */
    credentials += Credentials(Path.userHome / ".sbt" / "github-maven.credentials"),
    resolvers += s"${githubOwner.toLowerCase}-github" at s"https://maven.pkg.github.com/$githubOwner",
    publishMavenStyle := true,
    publishArtifact in Test := false,
    skip in publish := false,
    publishTo := Option("github" at s"https://maven.pkg.github.com/$githubOwner/emailaddress"),
    organization := githubOwner.toLowerCase,
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
