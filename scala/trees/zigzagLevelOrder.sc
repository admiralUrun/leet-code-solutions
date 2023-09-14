class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
  if (root == null) return Nil
  val result = scala.collection.mutable.ListBuffer[List[Int]]()
  val q = scala.collection.mutable.Queue(root)
  var toTheRight = false

  while (q.nonEmpty) {
    var buffer: List[Int] = Nil
    for (_ <- q.indices) {
      val node = q.dequeue()
      buffer = if (toTheRight) buffer :+ node.value else node.value :: buffer
      if (node.left != null) q.enqueue(node.left)
      if (node.right != null) q.enqueue(node.right)
    }
    toTheRight = !toTheRight
    result += buffer
  }

  result.toList
}