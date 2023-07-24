def simplifyPath(path: String): String = {
  val stack = scala.collection.mutable.Stack.empty[String]
  for (d <- path.split("/")) {
    d match {
      case "." | "" =>
      case ".." => if (stack.nonEmpty) stack.pop()
      case _ => stack.push(d)
    }
  }
  "/" + stack.reverse.mkString("/")
}