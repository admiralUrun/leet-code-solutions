class MedianFinder() {
  val min = scala.collection.mutable.PriorityQueue.empty(Ordering.Int.reverse)
  val max = scala.collection.mutable.PriorityQueue.empty(Ordering.Int)

  def addNum(num: Int): Unit = {
    if (max.isEmpty || num <= max.head) max.enqueue(num)
    else min.enqueue(num)

    if (max.length - min.length > 1) min.enqueue(max.dequeue())
    else if (min.length > max.length) max.enqueue(min.dequeue())
  }

  def findMedian(): Double = {
    if (max.length == min.length) (max.head + min.head) / 2.0
    else max.head
  }

}