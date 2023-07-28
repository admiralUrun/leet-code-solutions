class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

def minDepth(root: TreeNode, depth: Int = 1): Int = {
  if (root == null) return 0;
  (root.left, root.right) match {
    case (null, null) => depth;
    case (null, right) => minDepth(right, depth + 1);
    case (left, null) => minDepth(left, depth + 1);
    case (left, right) => Math.min(minDepth(left, depth + 1), minDepth(right, depth + 1));
  }
}