class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

def inorderTraversal(root: TreeNode): List[Int] = {
  if (root != null) (inorderTraversal(root.left) :+ root.value) ::: inorderTraversal(root.right)
  else Nil
}