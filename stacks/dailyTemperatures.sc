def dailyTemperatures(temperatures: Array[Int]): Array[Int] = {
  val result = Array.fill(temperatures.length)(0)
  val stack = scala.collection.mutable.Stack.empty[Int]

  for (i <- temperatures.indices) {
    if (stack.nonEmpty) {
      while (stack.nonEmpty && temperatures(stack.top) < temperatures(i)) {
        val top = stack.pop()
        result(top) = i - top
      }
    }
    stack.push(i)
  }

  result
}