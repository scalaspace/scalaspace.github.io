package scalaspace

import google.maps._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@JSGlobal("MarkerClusterer")
@js.native
class MarkerClusterer protected() extends OverlayView {

  def this(map: Map, opt_markers: js.Array[Marker] = ???, opt_options: js.Object = ???) = this()

  /**
   * Adds a marker to the clusterer and redraws if needed.
   * @param marker
   * @param opt_nodraw
   */
  def addMarker(marker: Marker, opt_nodraw: Boolean = false): Unit = js.native

  /**
   * Add an array of markers to the clusterer.
   * @param markers
   * @param opt_nodraw
   */
  def addMarkers(markers: js.Array[Marker], opt_nodraw: Boolean = false): Unit = js.native

  /**
   * Clears all clusters and markers from the clusterer.
   */
  def clearMarkers(): Unit = js.native

  /**
   * Get the calculator function.
   * FIXME what's the actual return type?
   * @return
   */
  def getCalculator(): js.Function2[js.Array[Marker], Double, js.Object] = js.native

  /**
   * Extends a bounds object by the grid size.
   * @param latLngBounds
   * @return
   */
  def getExtendedBounds(latLngBounds: LatLngBounds): LatLngBounds = js.native

  /**
   * Returns the size of the grid.
   * @return
   */
  def getGridSize(): Double = js.native

  /**
   * Returns the google map that the clusterer is associated with.
   * FIXME does this need to be overridden?
   * @return
   */
  override def getMap(): Map = js.native

  /**
   * Returns the array of markers in the clusterer.
   * @return
   */
  def getMarkers(): js.Array[Marker] = js.native

  /**
   * Gets the max zoom for the clusterer.
   * @return
   */
  def getMaxZoom(): Double = js.native

  /**
   *
   * @return
   */
  def getStyles(): js.Object = js.native

  /**
   * Returns the number of clusters in the clusterer.
   * @return
   */
  def getTotalClusters(): Double = js.native

  /**
   * Returns the array of markers in the clusterer.
   * @return
   */
  def getTotalMarkers(): js.Array[Marker] = js.native

  /**
   * Whether zoom on click is set.
   * @return
   */
  def isZoomOnClick(): Boolean = js.native

  /**
   * Redraws the clusters.
   */
  def redraw(): Unit = js.native

  /**
   * Remove a marker from the cluster.
   * @param marker
   */
  def removeMarker(marker: Marker): Unit = js.native

  /**
   * Clears all existing clusters and recreates them.
   */
  def resetViewPort(): Unit = js.native

  /**
   * Set the calculator function.
   * @param calculator
   */
  def setCalculator(calculator: js.Function2[js.Array[Marker], Double, js.Object]): Unit = js.native

  /**
   * Returns the size of the grid.
   * @param size
   */
  def setGridSize(size: Double): Unit = js.native

  /**
   * Sets the google map that the clusterer is associated with.
   * FIXME does this need to be overridden?
   * @param map
   */
  override def setMap(map: Map): Unit = js.native

  /**
   * Sets the max zoom for the clusterer.
   * @param maxZoom
   */
  def setMaxZoom(maxZoom: Double): Unit = js.native

  /**
   * Sets the styles.
   * @param styles
   */
  def setStyles(styles: js.Object): Unit = js.native

}
