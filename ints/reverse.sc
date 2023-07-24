def reverse(x: Int): Int = {
  var acc = 0L
  var current = x

  while (current != 0) {
    acc = acc * 10L + current % 10
    if (Int.MaxValue - 1 <= acc || acc <= Int.MinValue) return 0
    current = current / 10
  }
  acc.toInt
}