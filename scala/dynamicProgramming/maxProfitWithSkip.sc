def maxProfit(prices: Array[Int]): Int = {
  var sold = Int.MinValue
  var held = Int.MinValue
  var reset = 0

  for (p <- prices) {
    val preSold = sold
    sold = held + p
    held = held max reset - p
    reset = reset max preSold
  }

  sold max reset
}