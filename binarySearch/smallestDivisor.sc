def smallestDivisor(nums: Array[Int], threshold: Int): Int = {
  def check(d: Double): Boolean = {
    nums.foldLeft(0d) { case (acc, n) => acc + math.ceil(n / d) } <= threshold
  }

  var left = 1
  var right = nums.max

  while (left <= right) {
    val mid = left + (right - left) / 2

    if (check(mid)) right = mid - 1
    else left = mid + 1
  }

  left
}