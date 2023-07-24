def sortedSquares(nums: Array[Int]): Array[Int] = {
  import Math.abs
  val result = new Array[Int](nums.length)
  var mainPointer = result.length - 1
  var left = 0
  var right = mainPointer
  while (mainPointer >= 0) {
    if (abs(nums(left)) > abs(nums(right))) {
      result(mainPointer) = nums(left) * nums(left)
      left += 1
    } else {
      result(mainPointer) = nums(right) * nums(right)
      right -= 1
    }
    mainPointer -= 1
  }

  result
}