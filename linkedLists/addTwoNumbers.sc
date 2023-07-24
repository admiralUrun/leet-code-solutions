// * Definition for singly-linked list.
class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
  val result = new ListNode(0)
  var p = l1
  var q = l2
  var curr = result
  var carry = 0
  while (p != null || q != null) {
    val x = if (p != null) p.x else 0
    val y = if (q != null) q.x else 0
    val sum = carry + x + y
    carry = sum / 10
    curr.next = new ListNode(sum % 10)
    curr = curr.next
    if (p != null) p = p.next
    if (q != null) q = q.next
  }

  if (carry > 0) curr.next = new ListNode(carry)

  result.next
}