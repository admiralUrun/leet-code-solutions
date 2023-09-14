def findKthLargest(nums: Array[Int], k: Int): Int = {
  val q = scala.collection.mutable.PriorityQueue[Int]()(Ordering.Int.reverse)

  for (n <- nums) {
    q.addOne(n)
    if (q.length > k) q.dequeue()
  }

  q.head
}