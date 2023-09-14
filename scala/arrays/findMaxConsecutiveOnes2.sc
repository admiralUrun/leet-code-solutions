def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
  var count = 0
  var zeros = 0
  var left = 0

  for (right <- nums.indices) {
    if (nums(right) == 0) zeros += 1

    while (zeros == 2) {
      if (nums(left) == 0) zeros -= 1
      left += 1
    }

    count = count.max(right - left + 1)
  }

  count
}