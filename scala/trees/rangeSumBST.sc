class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

def rangeSumBST(root: TreeNode, low: Int, high: Int): Int = {
  if (root == null) return 0
  var result = 0

  if (low <= root.value && root.value <= high) result += root.value
  if (low <= root.value) result += rangeSumBST(root.left, low, high)
  if (root.value <= high) result += rangeSumBST(root.right, low, high)


  result
}