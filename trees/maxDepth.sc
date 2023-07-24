class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

def maxDepth(root: TreeNode): Int = {
  if (root == null) 0
  else {
    val left = maxDepth(root.left)
    val right = maxDepth(root.right)
    if (left > right) left + 1
    else right + 1
  }
}