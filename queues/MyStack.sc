// problem demanded use of 2 Queues
// A single List would work best here
class MyStack() {
  val queue = scala.collection.mutable.Queue.empty[Int]
  val buffer = scala.collection.mutable.Queue.empty[Int]

  def push(x: Int): Unit = {
    buffer.enqueue(x)
    buffer.enqueueAll(queue)
    queue.clear()
    queue.enqueueAll(buffer)
    buffer.clear()
  }

  def pop(): Int = queue.dequeue()

  def top(): Int = queue.head

  def empty(): Boolean = queue.isEmpty

}