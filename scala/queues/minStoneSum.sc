def minStoneSum(piles: Array[Int], k: Int): Int = {
  val heap = scala.collection.mutable.PriorityQueue.from(piles)(Ordering.Int)

  for (_ <- 0 until k) {
    heap.enqueue(math.round(heap.dequeue() / 2d).toInt)
  }
  heap.sum
}
