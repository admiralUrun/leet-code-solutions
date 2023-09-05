def isMatch(s: String, p: String): Boolean = {
  def isMatch(text: List[Char], pattern: List[Char]): Boolean = {
    if (pattern.isEmpty) text.isEmpty
    else {
      val currentMatch = text.nonEmpty && (text.head == pattern.head || pattern.head == '.')
      if (pattern.length >= 2 && pattern.tail.head == '*')
        isMatch(text, pattern.tail.tail) ||
          (currentMatch && isMatch(text.tail, pattern))
      else currentMatch && isMatch(text.tail, pattern.tail)
    }
  }

  isMatch(s.toList, p.toList)
}