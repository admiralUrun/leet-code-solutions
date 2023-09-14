def canMakeArithmeticProgression(arr: Array[Int]): Boolean = {
  val sorted = arr.sorted
  val diff = sorted(1) - sorted.head
  for (i <- 2 until sorted.length) {
    if (sorted(i) - sorted(i - 1) != diff) return false
  }
  true
}