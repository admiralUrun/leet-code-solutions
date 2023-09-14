def longestOnes(nums: Array[Int], k: Int): Int = {
  var max, nOfK, left = 0
  for (right <- nums.indices) {
    if (nums(right) == 0) nOfK += 1

    while (nOfK > k) {
      if (nums(left) == 0) nOfK -= 1
      left += 1
    }
    max = math.max(max, right - left + 1)
  }

  max
}