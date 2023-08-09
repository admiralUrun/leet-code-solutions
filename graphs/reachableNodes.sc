import scala.collection.mutable.{HashMap, HashSet}
def reachableNodes(n: Int, edges: Array[Array[Int]], restricted: Array[Int]): Int = {
  val edgeToNeighbor = new HashMap[Int, List[Int]]()
  val restrictedSet = HashSet(restricted: _*)

  edges.foreach { edge =>
    val node = edge(0)
    val neighbor = edge(1)
    if (!restrictedSet.contains(node) && !restrictedSet.contains(neighbor)) {
      edgeToNeighbor.update(node, neighbor :: edgeToNeighbor.getOrElse(node, Nil))
      edgeToNeighbor.update(neighbor, node :: edgeToNeighbor.getOrElse(neighbor, Nil))
    }
  }

  def dfs(node: Int, seen: HashSet[Int]): Int =
    edgeToNeighbor(node).collect {
      case neighbor if !seen.contains(neighbor) && edgeToNeighbor.contains(neighbor) =>
        1 + dfs(neighbor, seen + node)
    }.sum

  if (edgeToNeighbor.contains(0)) 1 + dfs(0, HashSet(0)) else 1
}