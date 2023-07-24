def waysToSplitArray(nums: Array[Int]): Int = {
  if (nums.length == 1) 0
  else {
    val prefix = {
      val buffer = scala.collection.mutable.ListBuffer.empty[Long]
      buffer.addOne(nums.head)
      for (i <- 1 until nums.length) {
        buffer.addOne(nums(i) + buffer.last)
      }
      buffer.toArray
    }

    var ans = 0
    for (i <- 0 until prefix.length - 1) {
      if (prefix(i) >= prefix.last - prefix(i)) ans += 1
    }

    ans
  }
}