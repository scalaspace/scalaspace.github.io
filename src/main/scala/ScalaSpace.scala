package scalaspace

import google.maps._
import org.scalajs.dom._
import upickle.default._

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import scala.util.{Failure, Success}

object ScalaSpace {

  val infoWindow = new InfoWindow()

  def onClick(map: Map, marker: Marker, group: Group): Unit = {
    val link = if (group.url.startsWith("http")) group.url else s"http://www.meetup.com/${group.url}/"
    val content = document.createElement("a")
    content.setAttribute("href", link)
    content.innerHTML = group.name
    infoWindow.setContent(content)
    infoWindow.open(map, marker)
  }

  def logo(group: Group): Icon =
    if (group.justScala) Icon("img/markers/scala.png") else Icon("img/markers/lambda.png")

  def initialize(): Unit = {

    val opts = MapOptions(
      center = new LatLng(51.5072, 0.1275),
      zoom = 6,
      mapTypeId = MapTypeId.ROADMAP,
      mapTypeControl = false,
      streetViewControl = false)

    val map = new Map(document.getElementById("map"), opts)

    ext.Ajax.get("data/groups.json").onComplete {
      case Success(request: XMLHttpRequest) =>
        val markers = read[Groups](request.responseText).groups.map { group =>
          val marker = new Marker(MarkerOptions(
            position = new LatLng(group.latitude, group.longitude),
            icon = logo(group),
            map = map
          ))
          google.maps.event.addListener(marker, "click", () => onClick(map, marker, group))
          marker
        }
        // FIXME Restore the calculator function
        new MarkerClusterer(map, markers, js.Dynamic.literal(
          gridSize = 50,
          minimumClusterSize = 2
        ))
        if (document.defaultView.navigator.geolocation != null) {
          document.defaultView.navigator.geolocation.getCurrentPosition { (position: Position) =>
            map.setCenter(new LatLng(position.coords.latitude, position.coords.longitude))
          }
        }
      case Failure(_) =>
        console.log("Failed to load data. Please try again later.")
    }

  }

  def main(args: Array[String]): Unit = {
    google.maps.event.addDomListener(window, "load", () => initialize)
    val contribute = document.getElementById("contribute")
    document.getElementById("expand-contribute").addEventListener("click", { (event: Event) =>
      contribute.setAttribute("style", "display:block")
    })
    document.getElementById("collapse-contribute").addEventListener("click", { (event: Event) =>
      contribute.setAttribute("style", "display:none")
    })
  }

}
