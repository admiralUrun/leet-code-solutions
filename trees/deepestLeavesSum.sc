class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

def deepestLeavesSum(root: TreeNode): Int = {
  if (root == null) return 0
  var levelSum = 0
  val q = scala.collection.mutable.Queue(root)

  while (q.nonEmpty) {
    levelSum = 0
    for (_ <- q.indices) {
      val node = q.dequeue()
      levelSum += node.value
      if (node.left != null) q.enqueue(node.left)
      if (node.right != null) q.enqueue(node.right)
    }
  }
  levelSum
}