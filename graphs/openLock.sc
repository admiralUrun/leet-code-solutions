def openLock(deadends: Array[String], target: String): Int = {
  def neighbors(code: String): Seq[String] = {
    val buffer = scala.collection.mutable.Buffer.empty[String]
    for (i <- 0 until 4) {
      val num = code(i) - '0'
      for (change <- -1 to 1 by 2) {
        val newNum = (num + change + 10) % 10
        buffer.append(code.substring(0, i) + newNum.toString + code.substring(i + 1))
      }
    }
    buffer.toSeq
  }

  val queue = scala.collection.mutable.Queue(("0000", 0))
  val seen = scala.collection.mutable.HashSet.from(deadends)

  if (seen.contains("0000") || seen.contains(target)) return -1

  while (queue.nonEmpty) {
    val (code, steps) = queue.dequeue()

    if (code == target) return steps
    for (n <- neighbors(code)) {
      if (!seen.contains(n)) {
        if (code == target) return steps + 1
        seen += n
        queue.enqueue((n, steps + 1))
      }
    }
  }

  -1
}