def maximumDetonation(bombs: Array[Array[Int]]): Int = {
  val graph = scala.collection.mutable.HashMap.empty[Int, List[Int]]

  for (i <- bombs.indices) {
    val Array(x, y, radius) = bombs(i)
    var neighbors: List[Int] = Nil
    for (j <- bombs.indices if i != j) {
      val Array(x1, y1, _) = bombs(j)
      if (math.sqrt(math.pow(x - x1, 2) + math.pow(y - y1, 2)) <= radius) {
        neighbors = j :: neighbors
      }
    }

    graph.addOne(i, neighbors)
  }


  def bfs(bomb: Int): Int = {
    var sum = 0
    val stack = scala.collection.mutable.Queue(bomb)
    val seen = scala.collection.mutable.HashSet(bomb)

    while (stack.nonEmpty) {
      for (n <- graph(stack.dequeue()) if !seen.contains(n)) {
        seen.addOne(n)
        stack.addOne(n)
      }
      sum += 1
    }

    sum
  }

  var max = 0

  for (i <- bombs.indices) {
    max = math.max(max, bfs(i))
  }
  max
}