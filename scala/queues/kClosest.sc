def kClosest(points: Array[Array[Int]], k: Int): Array[Array[Int]] = {
  val q = scala.collection.mutable.PriorityQueue.empty[(Double, Array[Int])](Ordering.Double.TotalOrdering on[(Double, Array[Int])] (_._1))

  for (p <- points) {
    val Array(x, y) = p
    q.addOne((math.sqrt(x * x + y * y), p))
    if (q.length > k) q.dequeue()
  }

  q.toArray.map(_._2)
}