name := "scala-space"

scalaVersion := "2.12.6"

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
  "com.lihaoyi" %%% "upickle" % "0.6.6",
  "io.surfkit" %%% "scalajs-google-maps" % "0.0.3-SNAPSHOT")
