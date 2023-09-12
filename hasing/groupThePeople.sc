def groupThePeople(groupSizes: Array[Int]): List[List[Int]] = {

  val grouped = scala.collection.mutable.HashMap.empty[Int, List[Int]]

  for (i <- groupSizes.indices) {
    grouped(groupSizes(i)) = i :: grouped.getOrElse(groupSizes(i), Nil)
  }

  var result: List[List[Int]] = Nil

  for ((key, v) <- grouped) {
    var traverse = v
    var list: List[Int] = Nil

    while (traverse.nonEmpty) {
      list = traverse.head :: list
      if (list.length == key) {
        result = list :: result
        list = Nil
      }
      traverse = traverse.tail
    }
    if (list.nonEmpty) result = list :: result
  }

  result
}