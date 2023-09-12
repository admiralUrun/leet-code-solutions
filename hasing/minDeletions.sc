def minDeletions(s: String): Int = {
  val charToFrequency = scala.collection.mutable.HashMap.empty[Char, Int]

  for (c <- s) {
    charToFrequency(c) = charToFrequency.getOrElse(c, 0) + 1
  }

  var count = 0
  val set = scala.collection.mutable.HashSet.empty[Int]
  for (f <- charToFrequency.values) {
    var frequency = f
    while (set.contains(frequency)) {
      frequency -= 1
      count += 1
    }
    if (frequency > 0) set.addOne(frequency)
  }

  count
}