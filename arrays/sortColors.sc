def sortColors(nums: Array[Int]): Unit = {
  var zeros = 0
  var ones = 0
  var twos = 0
  for (n <- nums) {
    if (n == 0) zeros += 1
    if (n == 1) ones += 1
    if (n == 2) twos += 1
  }

  for (i <- nums.indices) {
    if (zeros > 0) {
      nums(i) = 0
      zeros -= 1
    } else if (ones > 0) {
      nums(i) = 1
      ones -= 1
    } else if (twos > 0) {
      nums(i) = 2
      twos -= 1
    }
  }

}