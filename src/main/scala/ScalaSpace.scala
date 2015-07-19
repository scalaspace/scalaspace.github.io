package scalaspace

import google.maps._
import org.scalajs.dom._
import upickle.default._

import scala.scalajs.js
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport

object ScalaSpace extends JSApp {

  val infoWindow = new InfoWindow()

  def onClick(map: Map, marker: Marker, group: Group) = () => js.Function {
    val link = if (group.url.startsWith("http")) group.url else s"http://www.meetup.com/${group.url}/"
    val content = document.createElement("a")
    content.setAttribute("href", link)
    content.innerHTML = group.name
    infoWindow.setContent(content)
    infoWindow.open(map, marker)
    ""
  }

  def logo(group: Group): Icon =
    if (group.justScala) Icon("img/markers/scala.png") else Icon("img/markers/lambda.png")

  def initialize() = js.Function {

    val opts = MapOptions(
      center = new LatLng(51.5072, 0.1275),
      zoom = 6,
      mapTypeId = MapTypeId.ROADMAP,
      mapTypeControl = false,
      streetViewControl = false)

    val map = new Map(document.getElementById("map"), opts)

    val req = new XMLHttpRequest()
    req.open("GET", "data/groups.json")
    req.onreadystatechange = (event: Event) => {
      if (req.readyState == 4 && req.status == 200) {
        val markers = read[Groups](req.responseText).groups.map { group =>
          val marker = new Marker(MarkerOptions(
            position = new LatLng(group.latitude, group.longitude),
            icon = logo(group),
            map = map
          ))
          google.maps.event.addListener(marker, "click", onClick(map, marker, group))
          marker
        }
        // FIXME Restore the calculator function
        new MarkerClusterer(map, markers, js.Dynamic.literal(
          gridSize = 50,
          minimumClusterSize = 2
        ))
      }
    }
    req.send()

    ""

  }

  @JSExport
  override def main(): Unit = {
    google.maps.event.addDomListener(window, "load", initialize)
    val contribute = document.getElementById("contribute")
    document.getElementById("expand-contribute").addEventListener("click", { (event: Event) =>
      contribute.setAttribute("style", "display:block")
    })
    document.getElementById("collapse-contribute").addEventListener("click", { (event: Event) =>
      contribute.setAttribute("style", "display:none")
    })
  }

}
