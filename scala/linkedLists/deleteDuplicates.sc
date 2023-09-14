class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

def deleteDuplicates(head: ListNode): ListNode = {
  if (head == null) null
  else {
    var prev = head
    var current = prev.next
    while (current != null) {
      if (current.x == prev.x) {
        prev.next = current.next
      } else {
        prev = current
      }
      current = current.next
    }

    head
  }
}