def getAverages(nums: Array[Int], k: Int): Array[Int] = {
  if (k == 0) nums
  else {
    val prefix = {
      val buffer = scala.collection.mutable.ArrayBuffer(nums.head.toLong)
      for (i <- 1 until nums.length) {
        buffer.addOne(nums(i).toLong + buffer.last)
      }
      buffer.toArray
    }

    val buffer = scala.collection.mutable.ArrayBuffer.empty[Int]

    val n = k * 2 + 1
    for (i <- nums.indices) {
      if (i < k || nums.length - (i + 1) < k) buffer.addOne(-1)
      else if (i == k) buffer.addOne((prefix(i + k) / n).toInt)
      else buffer.addOne(((prefix(i + k) - prefix(i - k - 1)) / n).toInt)
    }

    buffer.toArray
  }
}