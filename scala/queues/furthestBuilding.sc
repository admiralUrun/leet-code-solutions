def furthestBuilding(heights: Array[Int], bricks: Int, ladders: Int): Int = {
  val q = scala.collection.mutable.PriorityQueue.empty[Int](Ordering.Int.reverse)
  var bricksLeft = bricks

  for (i <- 0 until heights.length - 1) {
    val diff = heights(i + 1) - heights(i)
    if (diff > 0) {
      q.enqueue(diff)
      if (q.length > ladders) {
        bricksLeft -= q.dequeue()
        if (bricksLeft < 0) return i
      }
    }
  }

  heights.length - 1
}