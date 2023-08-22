def convertToTitle(columnNumber: Int): String = {
  val result = new StringBuilder
  var left = columnNumber

  while (left > 0) {
    left -= 1
    val i = left % 26
    result.addOne((i + 'A').toChar)
    left = left / 26
  }

  result.reverse.mkString
}