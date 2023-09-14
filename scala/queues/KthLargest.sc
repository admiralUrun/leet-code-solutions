class KthLargest(_k: Int, _nums: Array[Int]) {
  val queue = {
    val q = scala.collection.mutable.PriorityQueue.empty(Ordering.Int.reverse)
    for (n <- _nums) {
      q.addOne(n)
      if (q.length > _k) q.dequeue()
    }
    q
  }

  def add(`val`: Int): Int = {
    queue.addOne(`val`)
    if (queue.length > _k) queue.dequeue()
    queue.head
  }

}
