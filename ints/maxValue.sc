def maxValue(n: Int, index: Int, maxSum: Int): Int = {
  import scala.math.{max, min}
  var result = 0L
  var lowestValue = 1L
  var peakValue = (maxSum - n) + 1L

  while (lowestValue <= peakValue) {
    val mid = lowestValue + (peakValue - lowestValue) / 2L
    val minLeft = min(index, mid - 1)
    val left = max(0, index - mid + 1) + (mid * minLeft - minLeft * (minLeft + 1) / 2)
    val minRight = min(n - index - 1, mid)
    val right = max(0, n - index - mid) + (mid * minRight - minRight * (minRight + 1) / 2)
    if (left + mid + right <= maxSum) {
      result = mid
      lowestValue = mid + 1
    } else peakValue = mid - 1
  }
  result.toInt
}