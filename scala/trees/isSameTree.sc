class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
  if (p != null && q != null) {
    if (p.value == q.value) {
      val left = isSameTree(p.left, q.left)
      if (!left) false
      else isSameTree(p.right, q.right)
    } else false
  } else if (p == null) q == null
  else if (q == null) p == null
  else true
}