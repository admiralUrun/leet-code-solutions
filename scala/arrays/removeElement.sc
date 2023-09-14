def removeElement(nums: Array[Int], `val`: Int): Int = {
  var count = 0
  for (n <- nums) {
    if (n != `val`) {
      nums(count) = n
      count += 1
    }
  }
  count
}