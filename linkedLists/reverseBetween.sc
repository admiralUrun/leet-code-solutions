class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

def reverseBetween(head: ListNode, left: Int, right: Int): ListNode = {
  if (head == null || head.next == null || left == right) return head

  val dummy = new ListNode(0)
  dummy.next = head
  var prev = dummy

  for (_ <- 1 until left) {
    prev = prev.next
  }

  val current = prev.next

  for (_ <- left until right) {
    val next = current.next
    current.next = next.next
    next.next = prev.next
    prev.next = next
  }

  dummy.next
}