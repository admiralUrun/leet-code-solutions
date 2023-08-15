def calcEquation(equations: List[List[String]], values: Array[Double], queries: List[List[String]]): Array[Double] = {
  val neighbors = scala.collection.mutable.HashMap.empty[String, List[(String, Double)]]

  for (i <- equations.indices) {
    val List(n, d) = equations(i)
    val v = values(i)
    neighbors(n) = (d, v) :: neighbors.getOrElse(n, Nil)
    neighbors(d) = (n, 1 / v) :: neighbors.getOrElse(d, Nil)
  }

  def getQuery(numerator: String, denominator: String): Double = {
    if (neighbors.contains(numerator)) {
      val seen = scala.collection.mutable.HashSet(numerator)
      val stack = scala.collection.mutable.Stack((numerator, 1d))
      while (stack.nonEmpty) {
        val (node, ratio) = stack.pop()

        if (node == denominator) return ratio

        for ((n, r) <- neighbors(node)) {
          if (!seen.contains(n)) {
            seen.addOne(n)
            stack.push((n, ratio * r))
          }
        }
      }
      -1
    } else -1
  }


  queries.toArray.map(list => getQuery(list.head, list.tail.head))
}