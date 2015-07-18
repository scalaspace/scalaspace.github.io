package scalaspace

case class Groups(groups: Seq[Group])

case class Group(name: String, url: String, latitude: Double, longitude: Double, justScala: Boolean)
