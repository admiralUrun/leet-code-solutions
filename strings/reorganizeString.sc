def reorganizeString(s: String): String = {
  val queue = {
    val queue = scala.collection.mutable.PriorityQueue[(Char, Int)]()(math.Ordering.by(_._2))
    val hash = scala.collection.mutable.HashMap.empty[Char, Int]
    for (c <- s) {
      hash(c) = hash.getOrElse(c, 0) + 1
    }
    for (t <- hash) {
      queue.enqueue(t)
    }
    queue
  }
  val buffer = scala.collection.mutable.Buffer.empty[Char]

  while (queue.nonEmpty) {
    val (next, count) = queue.dequeue()
    if (buffer.nonEmpty && buffer.last == next) {
      if (queue.isEmpty) return ""
      else {
        val (next1, count1) = queue.dequeue()
        buffer.append(next1)
        buffer.append(next)
        if (count1 > 1) queue.enqueue((next1, count1 - 1))
      }
    } else buffer.append(next)

    if (count > 1) queue.enqueue((next, count - 1))
  }

  buffer.mkString
}