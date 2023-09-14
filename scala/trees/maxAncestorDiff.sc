class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

def maxAncestorDiff(root: TreeNode): Int = {
  def maxAncestorDiff(node: TreeNode, max: Int, min: Int): Int = {
    if (node == null) max - min
    else {
      val newMin = math.min(min, node.value)
      val newMax = math.max(max, node.value)
      math.max(
        maxAncestorDiff(node.left, newMax, newMin),
        maxAncestorDiff(node.right, newMax, newMin),
      )
    }
  }

  maxAncestorDiff(root, root.value, root.value)
}