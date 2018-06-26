package scalaspace

import scala.scalajs.js

@js.native
trait Icon extends js.Object {
  val url: String = js.native
}

object Icon {
  def apply(url: String): Icon = js.Dynamic.literal(url = url).asInstanceOf[Icon]
}