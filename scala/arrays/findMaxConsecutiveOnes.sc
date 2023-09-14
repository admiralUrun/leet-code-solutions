def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
  var max = 0
  var count = 0
  for (n <- nums) {
    if (n == 1) count += 1
    else {
      if (max < count) max = count
      count = 0
    }
  }
  if (max > count) max else count
}