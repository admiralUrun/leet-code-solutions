class Node(var _value: Int) {
  var value: Int = _value
  var next: Node = null
  var random: Node = null
}

def copyRandomList(head: Node): Node = {
  val oldToNew = scala.collection.mutable.HashMap.empty[Node, Node]

  var current = head

  while (current != null) {
    oldToNew(current) = new Node(current.value)
    current = current.next
  }

  current = head
  while (current != null) {
    val newNode = oldToNew(current)
    newNode.next = oldToNew.getOrElse(current.next, null)
    newNode.random = oldToNew.getOrElse(current.random, null)
    current = current.next
  }

  oldToNew.getOrElse(head, null)
}