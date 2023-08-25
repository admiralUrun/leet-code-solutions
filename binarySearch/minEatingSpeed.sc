def minEatingSpeed(piles: Array[Int], h: Int): Int = {
  def ceil(n: Int, d: Int) = (n + d - 1) / d

  def check(k: Int) = piles.foldLeft(0d) { case (acc, bananas) => acc + ceil(bananas, k) } <= h

  var left = 1
  var right = piles.max

  while (left <= right) {
    val mid = left + (right - left) / 2

    if (check(mid)) right = mid - 1
    else left = mid + 1
  }


  left
}
