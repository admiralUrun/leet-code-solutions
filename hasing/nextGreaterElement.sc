def nextGreaterElement(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
  val map = scala.collection.mutable.Map.empty[Int, Int]
  val stack = scala.collection.mutable.Stack.empty[Int]
  for (n <- nums2) {
    while (stack.nonEmpty && stack.top < n) {
      map += (stack.pop() -> n)
    }
    stack.push(n)
  }
  nums1.map(map.getOrElse(_, -1))
}