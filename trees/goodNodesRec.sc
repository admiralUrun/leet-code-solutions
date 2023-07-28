class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

def goodNodes(root: TreeNode): Int = {
  def goodNodes(curr: TreeNode, biggest: Int): Int = {
    if (curr == null) 0
    else {
      val left = goodNodes(curr.left, math.max(curr.value, biggest))
      val right = goodNodes(curr.right, math.max(curr.value, biggest))
      var ans = left + right
      if (curr.value >= biggest) ans += 1
      ans
    }
  }

  goodNodes(root, Int.MinValue)
}