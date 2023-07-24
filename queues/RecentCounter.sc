class RecentCounter() {
  val q = scala.collection.mutable.Queue.empty[Int]

  def ping(t: Int): Int = {
    while (q.nonEmpty && q.head < t - 3000) {
      q.dequeue()
    }
    q.enqueue(t)
    q.length
  }

}
