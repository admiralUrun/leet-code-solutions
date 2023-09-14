def findNumbers(nums: Array[Int]): Int = {
  nums.count(n => (Math.log10(n) + 1).toInt % 2 == 0)
}