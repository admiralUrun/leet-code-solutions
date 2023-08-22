def answerQueries(nums: Array[Int], queries: Array[Int]): Array[Int] = {
  nums.sortInPlace()
  val sum = nums.sum
  queries.mapInPlace { q =>
    var i = nums.length - 1
    var sumLocal = sum
    var length = nums.length
    while (i >= 0) {
      if (sumLocal > q) {
        sumLocal -= nums(i)
        length -= 1
      } else i = -1
      i -= 1
    }
    length
  }
}