class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
  if (l1 == null) l2
  else if (l2 == null) l1
  else {
    if (l1.x <= l2.x) {
      l1.next = mergeTwoLists(l1.next, l2)
      l1
    } else {
      l2.next = mergeTwoLists(l1, l2.next)
      l2
    }
  }
}