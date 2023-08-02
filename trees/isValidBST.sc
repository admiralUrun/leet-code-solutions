class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

def isValidBST(root: TreeNode): Boolean = {
  def isValidBST(node: TreeNode, min: Long, max: Long): Boolean = {
    if (node == null) return true

    node.value < max && node.value > min &&
      isValidBST(node.left, min, node.value) &&
      isValidBST(node.right, node.value, max)
  }

  isValidBST(root, Long.MinValue, Long.MaxValue)
}