class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

def preorderTraversal(root: TreeNode): List[Int] = {
  if (root != null) root.value :: preorderTraversal(root.left) ::: preorderTraversal(root.right)
  else Nil
}