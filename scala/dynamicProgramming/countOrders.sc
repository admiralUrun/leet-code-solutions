def countOrders(n: Int): Int = {
  val memo = scala.collection.mutable.HashMap.empty[(Int, Int), Long]
  val MOD: Long = 1_000_000_007

  def dp(unpicked: Int, undelivered: Int): Long = {
    if (unpicked == 0 && undelivered == 0) 1
    else if (unpicked < 0 || undelivered < 0 || undelivered < unpicked) 0
    else if (memo.contains(unpicked, undelivered)) memo((unpicked, undelivered))
    else {
      var ans = 0L
      ans += unpicked * dp(unpicked - 1, undelivered)
      ans %= MOD
      ans += (undelivered - unpicked) * dp(unpicked, undelivered - 1)
      ans %= MOD
      memo((unpicked, undelivered)) = ans
      memo((unpicked, undelivered))
    }
  }

  dp(n, n).toInt
}