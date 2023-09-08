def climbStairs(n: Int): Int = {
  val memo = scala.collection.mutable.HashMap.empty[Int, Int]

  def dp(i: Int): Int = {
    if (i <= 3) i
    else if (memo.contains(i)) memo(i)
    else {
      memo(i) = dp(i - 1) + dp(i - 2)
      memo(i)
    }
  }

  dp(n)
}

def climbStairsTailRec(n: Int): Int = {
  def climbStairs(n: Int, first: Int, second: Int): Int = {
    if (n == 0) second
    else climbStairs(n - 1, second, first + second)
  }

  if (n <= 0) 0
  else climbStairs(n, 0, 1)
}