class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}


def diameterOfBinaryTree(root: TreeNode): Int = {
  def maxDepth(root: TreeNode): Int = {
    if (root == null) 0
    else math.max(maxDepth(root.left), maxDepth(root.right)) + 1
  }

  def diameter(node: TreeNode): Int = {
    if (node == null) 0
    else math.max(
      maxDepth(node.left) + maxDepth(node.right),
      math.max(diameter(node.left), diameter(node.right))
    )
  }

  diameter(root)
}