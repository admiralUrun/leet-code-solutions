def reverseString(s: Array[Char]): Unit = {
  def reverseStringIgnoringMid(i: Int, j: Int): Unit = {
    if (i == j) ()
    else {
      val c = s(i)
      s(i) = s(j)
      s(j) = c
      reverseStringIgnoringMid(i + 1, j - 1)
    }
  }

  def reverseString(i: Int, j: Int): Unit = {
    if (i == s.length / 2) ()
    else {
      val c = s(i)
      s(i) = s(j)
      s(j) = c
      reverseString(i + 1, j - 1)
    }
  }

  if (s.isEmpty) ()
  else if (s.length % 2 == 0) reverseString(0, s.length - 1)
  else reverseStringIgnoringMid(0, s.length - 1)
}