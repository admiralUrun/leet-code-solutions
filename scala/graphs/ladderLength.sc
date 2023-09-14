def ladderLength(beginWord: String, endWord: String, wordList: List[String]): Int = {
  if (!wordList.contains(endWord)) return 0

  val graph = scala.collection.mutable.HashMap.empty[String, Seq[String]]

  (beginWord :: wordList).foreach { word =>
    val buffer = scala.collection.mutable.Buffer.empty[String]
    for (w <- wordList) {
      var diff = 0
      var i = 0
      while (i < word.length && diff <= 1) {
        if (w(i) != word(i)) diff += 1
        i += 1
      }
      if (diff == 1) buffer.addOne(w)
    }
    graph(word) = buffer.toSeq
  }

  val queue = scala.collection.mutable.Queue((beginWord, 1))
  val seen = scala.collection.mutable.HashSet(beginWord)

  while (queue.nonEmpty) {
    val (word, steps) = queue.dequeue()
    for (n <- graph.getOrElse(word, Nil)) {
      if (!seen.contains(n)) {
        if (n == endWord) return steps + 1
        queue.addOne(n, steps + 1)
        seen.addOne(n)
      }
    }
  }

  0
}