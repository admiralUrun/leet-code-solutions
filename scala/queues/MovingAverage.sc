class MovingAverage(_size: Int) {
  val q = scala.collection.mutable.Queue.empty[Int]

  def next(`val`: Int): Double = {
    if (q.size == _size) q.dequeue()
    q.enqueue(`val`)
    q.sum / q.length.toDouble
  }

}