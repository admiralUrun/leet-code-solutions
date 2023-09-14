class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

def closestValue(root: TreeNode, target: Double): Int = {
  var closest = root.value
  var node = root

  while (node != null) {
    if (math.abs(target - node.value) < math.abs(target - closest)) closest = node.value
    else if (math.abs(target - node.value) == math.abs(target - closest)) closest = math.min(node.value, closest)

    if (node.value <= target) node = node.right
    else node = node.left
  }

  closest
}