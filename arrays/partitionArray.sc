def partitionArray(nums: Array[Int], k: Int): Int = {
  nums.sortInPlace()

  var ans = 1
  var x = nums.head
  for (i <- 1 until nums.length) {
    if (nums(i) - x > k) {
      x = nums(i)
      ans += 1
    }
  }

  ans
}