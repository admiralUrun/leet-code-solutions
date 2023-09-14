def minStartValue(nums: Array[Int]): Int = {
  nums.foldLeft((0, 1)) { case ((right, acc), n) =>
    val sum = right + n
    val add = if (sum + acc <= 0) math.abs(sum + acc) + 1 else 0
    (sum, acc + add)
  }
    ._2
}