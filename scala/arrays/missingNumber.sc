def missingNumber(nums: Array[Int]): Int = nums
  .foldLeft(nums.length * (nums.length + 1) / 2) { case (acc, n) => acc - n }
