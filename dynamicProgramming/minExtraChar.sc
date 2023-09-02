def minExtraChar(s: String, dictionary: Array[String]): Int = {
  val dp = Array.fill(s.length + 1)(Int.MaxValue)
  dp(0) = 0

  for (i <- 1 to s.length) {
    for (j <- 0 until i) {
      if (dp(j) != Int.MaxValue) {
        val subStr = s.substring(j, i)
        if (dictionary.contains(subStr)) dp(i) = math.min(dp(i), dp(j))
        else dp(i) = math.min(dp(i), dp(j) + i - j)
      }
    }
  }
  dp(s.length)
}