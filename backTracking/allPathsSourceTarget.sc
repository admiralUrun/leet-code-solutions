def allPathsSourceTarget(graph: Array[Array[Int]]): List[List[Int]] = {
  val answer = scala.collection.mutable.ListBuffer.empty[List[Int]]

  def backtracking(curr: List[Int]): Unit = {
    if (curr.contains(graph.length - 1)) answer.addOne(curr.reverse)
    else {
      for (n <- graph(curr.head)) {
        if (!curr.contains(n)) {
          backtracking(n :: curr)
        }
      }
    }
  }

  backtracking(List(0))
  answer.toList
}