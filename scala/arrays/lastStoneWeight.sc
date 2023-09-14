def lastStoneWeight(stones: Array[Int]): Int = {
  val q = scala.collection.mutable.PriorityQueue(stones: _*)
  while (q.length > 1) {
    val y = q.dequeue()
    val x = q.dequeue()
    if (y != x) q.addOne(y - x)
  }

  q.headOption.getOrElse(0)
}