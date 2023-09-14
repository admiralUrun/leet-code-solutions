class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

def insertionSortList(head: ListNode): ListNode = {
  if (head == null || head.next == null) return head

  val dummy = new ListNode()
  var curr = head

  while (curr != null) {
    val next = curr.next
    var prev = dummy

    while (prev.next != null && prev.next.x < curr.x) {
      prev = prev.next
    }

    curr.next = prev.next
    prev.next = curr
    curr = next
  }

  dummy.next
}