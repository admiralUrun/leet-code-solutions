def removeDuplicates(nums: Array[Int]): Int = {
  val dist = nums.distinct
  for (i <- dist.indices) {
    nums(i) = dist(i)
  }
  dist.length
}