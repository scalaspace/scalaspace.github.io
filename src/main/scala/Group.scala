package scalaspace

import io.circe.{ Decoder, Encoder }
import io.circe.generic.semiauto._

case class Group(name: String, url: String, latitude: Double, longitude: Double, justScala: Boolean)
object Group {
  implicit val groupDecoder: Decoder[Group] = deriveDecoder
  implicit val groupEncoder: Encoder[Group] = deriveEncoder
}