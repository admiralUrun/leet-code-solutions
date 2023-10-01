def carPooling(trips: Array[Array[Int]], capacity: Int): Boolean = {
  val road = new Array[Int](trips.maxBy(_.last).last + 1)

  trips.foreach { case Array(n, from, to) =>
    road(from) += n
    road(to) -= n
  }

  var curr = 0

  for (n <- road) {
    curr += n
    if (curr > capacity) return false
  }

  true
}