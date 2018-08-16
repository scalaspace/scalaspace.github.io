name := "scala-space"

scalaVersion := "2.12.6"

javacOptions ++= Seq("-Xmx6g")

scalacOptions ++= Seq(
  "-deprecation",                      // Emit warning and location for usages of deprecated APIs.
  "-encoding", "utf-8",                // Specify character encoding used by source files.
)

enablePlugins(ScalaJSPlugin)

scalaJSUseMainModuleInitializer in Compile := true

scalaJSUseMainModuleInitializer in Test := false

crossTarget in fastOptJS := baseDirectory.value / "js"
crossTarget in fullOptJS := baseDirectory.value / "js"

resolvers +=
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.2",
  "io.surfkit" %%% "scalajs-google-maps" % "0.0.3-SNAPSHOT",
  "io.circe" %%% "circe-core" % "0.9.3",
  "io.circe" %%% "circe-parser" % "0.9.3",
  "io.circe" %%% "circe-generic" % "0.9.3",
)
