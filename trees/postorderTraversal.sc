class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

def postorderTraversal(root: TreeNode): List[Int] = {
  if (root != null) postorderTraversal(root.left) ::: postorderTraversal(root.right) ::: List(root.value)
  else Nil
}