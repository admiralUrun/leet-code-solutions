def winnerOfGame(colors: String): Boolean = {
  var a = 0
  var b = 0
  for (i <- 1 until colors.length) {
    if (colors(i - 1) == colors(i) && colors(i) == colors(i + 1)) {
      if (colors(i) == 'A') a += 1
      else b += 1
    }
  }

  a - b >= 1
}