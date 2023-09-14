def runningSum(nums: Array[Int]): Array[Int] = {
  val buffer = scala.collection.mutable.ListBuffer.empty[Int]
  buffer.addOne(nums.head)
  for (i <- 1 until nums.length) {
    buffer.addOne(nums(i) + buffer.last)
  }
  buffer.toArray
}