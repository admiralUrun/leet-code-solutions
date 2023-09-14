class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

@annotation.tailrec
def searchBST(root: TreeNode, `val`: Int): TreeNode = {
  if (root == null) null
  else root.value.compareTo(`val`) match {
    case 1 => searchBST(root.left, `val`)
    case 0 => root
    case -1 => searchBST(root.right, `val`)
  }
}