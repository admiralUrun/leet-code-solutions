def maximumGap(nums: Array[Int]): Int = {
  if (nums.length < 2) 0
  else nums
    .sorted
    .sliding(2)
    .map(arr => Math.abs(arr.head - arr.last))
    .max
}