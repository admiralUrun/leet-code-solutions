def moveZeroes(nums: Array[Int]): Unit = {
  var writePointer = 0
  var zeroCount = 0
  for (n <- nums) {
    if (n == 0) {
      zeroCount += 1
    } else {
      nums(writePointer) = n
      writePointer += 1
    }
  }
  for (i <- nums.length - zeroCount until nums.length) {
    nums(i) = 0
  }
}