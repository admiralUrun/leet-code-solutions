def findCircleNum(isConnected: Array[Array[Int]]): Int = {
  val visitedNodes = scala.collection.mutable.Set.empty[Int]
  var provinces = 0

  def dfs(node: Int): Unit = {
    if (!visitedNodes.contains(node)) {
      visitedNodes.add(node)
      for (j <- isConnected.indices) {
        if (j != node && isConnected(node)(j) == 1) dfs(j)
      }
    }
  }

  for (node <- isConnected.indices) {
    if (!visitedNodes.contains(node)) {
      dfs(node)
      provinces += 1
    }
  }

  provinces
}