package scalaspace

import scala.scalajs.js

case class Groups(groups: js.Array[Group])

case class Group(name: String, url: String, latitude: Double, longitude: Double, justScala: Boolean)
