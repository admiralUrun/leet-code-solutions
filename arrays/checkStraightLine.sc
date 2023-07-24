def checkStraightLine(coordinates: Array[Array[Int]]): Boolean = {
  if (coordinates.length == 2) return true

  @inline
  def getSlope(x1: Int, x2: Int, y1: Int, y2: Int) = (y2 - y1).toDouble / (x2 - x1)

  val mainSlope = getSlope(coordinates(0)(0), coordinates(1)(0), coordinates(0)(1), coordinates(1)(1))

  for (i <- 2 until coordinates.length) {
    val current = coordinates(i)
    val previous = coordinates(i - 1)
    val slope = getSlope(current.head, previous.head, current.last, previous.last)
    if (mainSlope != slope && !(mainSlope.isInfinite && slope.isInfinite)) return false
  }
  true
}