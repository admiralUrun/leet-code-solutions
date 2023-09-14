class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

def swapPairs(current: ListNode): ListNode = {
  if (current == null || current.next == null) current
  else {
    val swap = current.next
    current.next = swapPairs(current.next.next)
    swap.next = current
    swap
  }
}