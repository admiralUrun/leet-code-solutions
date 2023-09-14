def minMeetingRooms(intervals: Array[Array[Int]]): Int = {
  var roomsTotal = 0
  var availableMeetingRooms = roomsTotal
  val roomNextFreeAt = scala.collection.mutable.PriorityQueue.empty[Int](Ordering.Int.reverse)
  intervals
    .sortBy(_.head)
    .foreach { case Array(starts, ends) =>
      while (roomNextFreeAt.nonEmpty && roomNextFreeAt.head <= starts) {
        roomNextFreeAt.dequeue()
        availableMeetingRooms += 1
      }

      if (availableMeetingRooms == 0) {
        roomNextFreeAt.enqueue(ends)
        roomsTotal += 1
      } else {
        roomNextFreeAt.enqueue(ends)
        availableMeetingRooms -= 1
      }
    }

  roomsTotal
}