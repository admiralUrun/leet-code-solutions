def summaryRanges(nums: Array[Int]): List[String] = {
  val res = scala.collection.mutable.ListBuffer.empty[String]
  var i = 0
  while (i < nums.length) {
    val start = nums(i)
    var end = start

    while (i + 1 < nums.length && nums(i + 1) - nums(i) == 1) {
      i += 1
      end = nums(i)
    }

    if (start == end) res.addOne(start.toString)
    else res.addOne(s"$start->$end")

    i += 1
  }

  res.toList
}