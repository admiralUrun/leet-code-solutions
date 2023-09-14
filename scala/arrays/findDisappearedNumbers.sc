def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
  var result: List[Int] = Nil

  for (i <- nums.indices) {
    val index = Math.abs(nums(i)) - 1
    if (nums(index) > 0) nums(index) = -nums(index)
  }

  for (i <- 1 to nums.length) {
    if (nums(i - 1) > 0) result = i :: result
  }

  result
}