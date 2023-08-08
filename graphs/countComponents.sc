def countComponents(n: Int, edges: Array[Array[Int]]): Int = {
  val visited = Array.ofDim[Boolean](n)
  val nodeToNeighbor = scala.collection.mutable.Map.empty[Int, List[Int]]

  edges.foreach { case Array(node, neighbor) =>
    nodeToNeighbor.update(node, neighbor :: nodeToNeighbor.getOrElse(node, Nil))
    nodeToNeighbor.update(neighbor, node :: nodeToNeighbor.getOrElse(neighbor, Nil))
  }

  def dfs(node: Int): Unit = {
    visited(node) = true

    for (next <- nodeToNeighbor.getOrElse(node, Nil) if !visited(next))
      dfs(next)
  }

  var components = 0

  for (node <- 0 until n if !visited(node)) {
    dfs(node)
    components += 1
  }
  components
}