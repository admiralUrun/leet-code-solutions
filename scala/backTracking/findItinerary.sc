def findItinerary(tickets: List[List[String]]): List[String] = {
  val graph = scala.collection.mutable.HashMap.empty[String, scala.collection.mutable.ArrayBuffer[(String, String)]]
  val visited = scala.collection.mutable.HashMap.empty[String, Array[Boolean]]

  for (List(from, to) <- tickets) {
    graph(from) = graph.getOrElse(from, scala.collection.mutable.ArrayBuffer.empty[(String, String)]).addOne((from, to))
  }

  for ((key, value) <- graph) {
    value.sortInPlaceBy(_._2)
    visited(key) = Array.fill(value.length)(false)
  }

  def backtracking(node: String, path: List[String]): List[String] = {
    if (path.length == tickets.length + 1) path.reverse
    else if (graph.contains(node)) {
      val nodeToVisited = visited(node)
      for (i <- graph(node).indices if !nodeToVisited(i)) {
        nodeToVisited(i) = true
        val fightTo = graph(node)(i)._2
        val res = backtracking(fightTo, fightTo :: path)
        if (res.length == tickets.length + 1) return res
        nodeToVisited(i) = false
      }
      Nil
    } else Nil
  }


  backtracking("JFK", List("JFK"))
}