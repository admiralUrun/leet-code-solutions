def sortArrayByParity(nums: Array[Int]): Array[Int] = {
  var left = 0
  var right = nums.length - 1
  while (left < right && nums.length > 0) {
    val toSwap = nums(right)
    val isLeftOdd = nums(left) % 2 == 0
    val isRightOdd = nums(right) % 2 == 0
    if (!isLeftOdd && isRightOdd) {
      nums(right) = nums(left)
      nums(left) = toSwap
      right -= 1
      left += 1
    } else if (!isLeftOdd && !isRightOdd) right -= 1
    else if (isLeftOdd && isRightOdd) left += 1
    else {
      right -= 1
      left += 1
    }
  }
  nums
}