class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}


def distanceK(root: TreeNode, target: TreeNode, k: Int): List[Int] = {
  val childrenToParent = scala.collection.mutable.HashMap.empty[Int, TreeNode]


  def dfs(root: TreeNode, parent: TreeNode): Unit = {
    if (root != null) {
      if (parent != null) childrenToParent.addOne((root.value, parent))

      dfs(root.left, root)
      dfs(root.right, root)
    }
  }

  dfs(root, null)

  val queue = scala.collection.mutable.Queue(target)
  val seen = scala.collection.mutable.HashSet(target)
  var distance = 0

  while (queue.nonEmpty && distance < k) {
    for (_ <- queue.indices) {
      val node = queue.dequeue()
      Seq(childrenToParent.get(node.value), Option(node.left), Option(node.right))
        .flatten
        .foreach { treeNode =>
          if (!seen.contains(treeNode)) {
            seen.addOne(treeNode)
            queue.addOne(treeNode)
          }
        }
    }
    distance += 1
  }

  queue.toList.map(_.value)
}