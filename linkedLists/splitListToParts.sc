class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

def splitListToParts(head: ListNode, k: Int): Array[ListNode] = {
  val array = new Array[ListNode](k)
  if (head == null) return array

  val buffer = scala.collection.mutable.ArrayBuffer(head)

  var curr = head.next
  while (curr != null) {
    buffer.addOne(curr)
    curr = curr.next
  }

  var extra = buffer.length % k
  val countOfItems = buffer.length / k

  if (buffer.length <= k) {
    for (i <- buffer.indices) {
      buffer(i).next = null
      array(i) = buffer(i)
    }
    return array
  }

  var indexInBuffer = 0
  for (i <- 0 until k) {
    val node = buffer(indexInBuffer)

    array(i) = node

    indexInBuffer += countOfItems

    if (extra > 0) {
      indexInBuffer += 1
      extra -= 1
    }

    if (indexInBuffer > 0) buffer(indexInBuffer - 1).next = null
  }

  array
}