class Trie() {
  case class Tree(
                   children: scala.collection.mutable.HashMap[Char, Tree] = scala.collection.mutable.HashMap.empty,
                   var words: List[String] = Nil
                 )

  val tree = Tree()

  def insert(word: String): Unit = {
    var curr = tree
    for (c <- word) {
      if (!curr.children.contains(c)) curr.children(c) = Tree()

      curr = curr.children(c)
    }
    curr.words = word :: curr.words
  }

  def search(word: String): Boolean = {
    var curr = tree
    for (c <- word) {
      if (!curr.children.contains(c)) return false
      else curr = curr.children(c)
    }
    curr.words.contains(word)
  }

  def startsWith(prefix: String): Boolean = {
    var curr = tree
    for (c <- prefix) {
      if (!curr.children.contains(c)) return false
      else curr = curr.children(c)
    }
    true
  }

