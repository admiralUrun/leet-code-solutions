def validPath(n: Int, edges: Array[Array[Int]], source: Int, destination: Int): Boolean = {
  val edgeToNeighbor = {
    val m = scala.collection.mutable.Map.empty[Int, scala.collection.mutable.ArrayBuilder[Int]]

    edges.foreach { case Array(node, neighbor) =>
      val nodeGroup = m.getOrElseUpdate(node, scala.collection.mutable.ArrayBuilder.make[Int])
      nodeGroup += neighbor
      val neighborGroup = m.getOrElseUpdate(neighbor, scala.collection.mutable.ArrayBuilder.make[Int])
      neighborGroup += node
    }
    m.mapValues(_.result())
  }
  val seenNodes = scala.collection.mutable.HashSet.empty[Int]
  val query = scala.collection.mutable.Queue.empty[Int]

  if (edgeToNeighbor.contains(source)) query.addOne(source)

  while (query.nonEmpty) {
    val node = query.dequeue()

    if (node == destination) return true
    if (!seenNodes.contains(node)) {
      seenNodes.add(node)
      edgeToNeighbor
        .get(node)
        .foreach { ns =>
          ns.foreach { n =>
            if (!seenNodes.contains(n)) query.addOne(n)
          }
        }
    }
  }

  source == destination
}