def makeGood(s: String): String = {
  def isGood(check: String): Boolean = check.isEmpty || check.length == 1 || check.sliding(2).forall(s => s.lastOption.exists(c => s.head == c || s.head.toUpper != c && c.toUpper != s.head))

  val stack = scala.collection.mutable.Stack.empty[Char]

  var result = s

  while (!isGood(result)) {
    for (c <- result) {
      if (stack.headOption.exists(h => h != c && (h.toUpper == c || c.toUpper == h))) stack.pop()
      else stack.push(c)
    }
    result = stack.mkString.reverse
    stack.clear()
  }

  result
}