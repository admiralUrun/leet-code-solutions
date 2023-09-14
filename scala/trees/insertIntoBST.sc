class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}


def insertIntoBST(root: TreeNode, `val`: Int): TreeNode = {
  var node = root

  while (root != null) {
    if (node.value >= `val`) {
      if (node.left == null) {
        node.left = new TreeNode(`val`)
        return root
      } else node = node.left
    } else {
      if (node.right == null) {
        node.right = new TreeNode(`val`)
        return root
      } else node = node.right
    }
  }

  new TreeNode(`val`)
}