name := "scala-space"

scalaVersion := "2.11.7"

enablePlugins(ScalaJSPlugin)

persistLauncher in Compile := true

persistLauncher in Test := false

crossTarget in fastOptJS := baseDirectory.value / "js"
crossTarget in fullOptJS := baseDirectory.value / "js"

resolvers +=
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.8.0",
  "com.lihaoyi" %%% "upickle" % "0.3.4",
  "io.surfkit" %%% "scalajs-google-maps" % "0.1-SNAPSHOT")
