def kthSmallest(matrix: Array[Array[Int]], k: Int): Int = {
  val q = scala.collection.mutable.PriorityQueue.empty(Ordering.Int)
  matrix.foreach(_.foreach(n => {
    q.addOne(n)
    if (q.length > k) q.dequeue()
  }))

  q.dequeue()
}