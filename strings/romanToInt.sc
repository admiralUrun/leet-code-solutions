def romanToInt(s: String): Int = {
  var sum = 0

  for (i <- 0 until s.length) {
    val c = s(i)
    val next = if (i + 1 < s.length) s(i + 1) else ' '
    c match {
      case 'I' => if (next == 'V' || next == 'X') sum -= 1 else sum += 1
      case 'V' => sum += 5
      case 'X' => if (next == 'L' || next == 'C') sum -= 10 else sum += 10
      case 'L' => sum += 50
      case 'C' => if (next == 'D' || next == 'M') sum -= 100 else sum += 100
      case 'D' => sum += 500
      case 'M' => sum += 1000
    }
  }

  sum
}