class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

def maxLevelSum(root: TreeNode): Int = {
  import scala.collection.mutable.Queue

  if (root == null) return 0

  var maxSum = root.value
  var maxLevel = 1

  val queue = Queue.empty[TreeNode]
  queue.enqueue(root)

  var level = 1

  while (queue.nonEmpty) {
    var levelSum = 0

    for (_ <- queue.indices) {
      val node = queue.dequeue()
      levelSum += node.value

      if (node.left != null) queue.enqueue(node.left)

      if (node.right != null) queue.enqueue(node.right)
    }


    if (levelSum > maxSum) {
      maxSum = levelSum
      maxLevel = level
    }

    level += 1
  }

  maxLevel
}