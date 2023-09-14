class StockSpanner() {
  val stack = scala.collection.mutable.Stack.empty[Int]

  def next(price: Int): Int = {
    stack.push(price)
    var days = 0

    while (days < stack.length && stack(days) <= price) {
      days += 1
    }
    days
  }

}
