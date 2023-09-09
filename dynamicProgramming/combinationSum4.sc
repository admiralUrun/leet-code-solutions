def combinationSum4(nums: Array[Int], target: Int): Int = {
  val memo = scala.collection.mutable.HashMap.empty[Int, Int]

  def combinationSum4(remain: Int): Int = {
    if (remain == 0) 1
    else if (memo.contains(remain)) memo(remain)
    else {
      var result = 0
      for (n <- nums) {
        if (remain - n >= 0) result += combinationSum4(remain - n)
      }
      memo(remain) = result
      memo(remain)
    }
  }

  combinationSum4(target)
}