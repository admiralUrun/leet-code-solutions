class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}


def hasCycle(head: ListNode): Boolean = {
  def hasCycle(slow: ListNode, fast: ListNode): Boolean = {
    if (fast == null || fast.next == null) false
    else if (fast.x == slow.x) true
    else hasCycle(fast.next, fast.next.next)
  }

  if (head == null) false
  else hasCycle(head, head)
}