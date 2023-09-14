class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

def largestValues(root: TreeNode): List[Int] = {
  if (root == null) return Nil
  val result = scala.collection.mutable.ListBuffer[Int]()
  val q = scala.collection.mutable.Queue(root)

  while (q.nonEmpty) {
    var max = Int.MinValue
    for (_ <- q.indices) {
      val node = q.dequeue()
      max = math.max(max, node.value)
      if (node.left != null) q.enqueue(node.left)
      if (node.right != null) q.enqueue(node.right)
    }
    result += max
  }

  result.toList
}