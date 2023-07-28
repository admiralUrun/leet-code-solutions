class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
  if (q == null && p == null) true
  else if (q == null || p == null) false
  else if (q.value != p.value) false
  else isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
}