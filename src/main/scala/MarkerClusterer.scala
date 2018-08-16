package scalaspace

import google.maps.{ OverlayView, Map, Marker }

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@JSGlobal("MarkerClusterer")
@js.native
class MarkerClusterer(map: Map, opt_markers: js.Array[Marker], opt_options: js.Object) extends OverlayView