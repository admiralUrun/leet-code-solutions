def connectSticks(sticks: Array[Int]): Int = {
  var cost = 0
  val queue = scala.collection.mutable.PriorityQueue(sticks: _*)(Ordering.Int.reverse)
  while (queue.size > 1) {
    val newStick = queue.dequeue() + queue.dequeue()
    queue.enqueue(newStick)
    cost += newStick
  }
  cost
}