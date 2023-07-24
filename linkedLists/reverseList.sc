class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

def reverseList(head: ListNode): ListNode = {
  def reverse(list: ListNode, acc: ListNode): ListNode = {
    if (list.next == null) new ListNode(list.x, acc)
    else reverse(list.next, new ListNode(list.x, acc))
  }

  if (head == null) null
  else reverse(head, null)
}