def coinChange(coins: Array[Int], amount: Int) = {
  val memo = scala.collection.mutable.HashMap.empty[Int, Int]

  def dp(remain: Int): Int = {
    if (remain < 0) -1
    else if (remain == 0) 0
    else if (memo.contains(remain - 1) && memo(remain - 1) != 0) memo(remain - 1)
    else {
      var ans = Int.MaxValue

      for (coin <- coins) {
        val result = dp(remain - coin)
        if (result != -1) ans = ans min result + 1
      }

      memo(remain - 1) = if (ans == Int.MaxValue) -1 else ans
      memo(remain - 1)
    }
  }

  dp(amount)
}