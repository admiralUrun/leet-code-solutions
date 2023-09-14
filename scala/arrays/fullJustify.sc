def fullJustify(words: Array[String], maxWidth: Int): List[String] = {
  val queue = scala.collection.mutable.Queue.from(words)
  val result = scala.collection.mutable.ListBuffer.empty[String]

  while (queue.nonEmpty) {
    val buffer = scala.collection.mutable.Buffer.empty[String]
    var lengthLeft = maxWidth

    while (queue.nonEmpty && lengthLeft >= queue.head.length) {
      lengthLeft -= queue.head.length + 1
      buffer.append(queue.dequeue())
    }

    var spacesToAdd = maxWidth - buffer.foldLeft(0) { case (acc, w) => acc + w.length }
    val builder = new StringBuilder()
    if (queue.isEmpty) {
      for (i <- 0 to buffer.length - 2) {
        builder.addAll(buffer(i))
        builder.addOne(' ')
        spacesToAdd -= 1
      }
      builder.addAll(buffer.last)
      for (_ <- 0 until spacesToAdd) {
        builder.addOne(' ')
      }
    } else if (buffer.length == 1) {
      builder.addAll(buffer.head)
      for (_ <- 0 until spacesToAdd) {
        builder.addOne(' ')
      }
    } else {
      val avgSpaces = spacesToAdd / (buffer.length - 1)
      val remainder = spacesToAdd % (buffer.length - 1)

      for (i <- 0 to buffer.length - 2) {
        val extraSpace = if (i < remainder) 1 else 0
        builder.addAll(buffer(i) + " " * (avgSpaces + extraSpace))
      }

      builder.addAll(buffer.last)
    }
    result.append(builder.result())
  }


  result.toList
}