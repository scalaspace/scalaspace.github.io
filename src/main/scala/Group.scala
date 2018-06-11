package scalaspace

import upickle.default._

import scala.scalajs.js

case class Groups(groups: js.Array[Group])

object Groups{
  implicit def rw: Reader[Groups] = macroR
}

case class Group(name: String, url: String, latitude: Double, longitude: Double, justScala: Boolean)

object Group{
  implicit def rw: Reader[Group] = macroR
}