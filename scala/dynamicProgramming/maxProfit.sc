def maxProfit(prices: Array[Int], fee: Int): Int = {
  var hold = -prices.head
  var free = 0

  for (price <- prices) {
    free = free max hold + price - fee
    hold = hold max free - price
  }
  free
}