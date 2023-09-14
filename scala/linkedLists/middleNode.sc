class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

def middleNode(head: ListNode): ListNode = {
  var fast, slow = head
  while (fast != null && fast.next != null) {
    slow = slow.next
    fast = fast.next.next
  }
  slow
}