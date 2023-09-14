def largestAltitude(gain: Array[Int]): Int = {
  var max = 0
  var current = 0
  for (i <- gain) {
    current += i
    if (current > max) max = current
  }
  max
}