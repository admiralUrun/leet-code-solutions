def find132pattern(nums: Array[Int]): Boolean = {
  val minimals = new Array[Int](nums.length)
  minimals(0) = nums.head
  for (i <- 1 until nums.length) {
    minimals(i) = nums(i) min minimals(i - 1)
  }

  val stack = scala.collection.mutable.Stack.empty[Int]

  for (i <- nums.length - 1 to 0 by -1) {
    while (stack.nonEmpty && stack.head < nums(i)) {
      if (stack.head > minimals(i)) return true
      stack.pop()
    }
    stack.push(nums(i))
  }

  false
}