def splitArray(nums: Array[Int], k: Int): Int = {
  def check(maxSum: Int): Boolean = {
    var chunks = 0
    var currentSum = 0
    for (n <- nums) {
      if (currentSum + n <= maxSum) currentSum += n
      else {
        currentSum = n
        chunks += 1
      }
    }
    chunks + 1 <= k
  }

  var left = nums.max
  var right = nums.sum
  var minimalSum = 0

  while (left <= right) {
    val mid = left + (right - left) / 2
    if (check(mid)) {
      right = mid - 1
      minimalSum = mid
    }
    else left = mid + 1
  }

  left

}