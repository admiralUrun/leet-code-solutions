def countBits(n: Int): Array[Int] = {
  val buffer = Array.ofDim[Int](n + 1)

  for (i <- 0 to n) {
    var count = 0
    var x = i
    while (x != 0) {
      x &= x - 1
      count += 1
    }
    buffer(i) = count
  }

  buffer
}