def minSetSize(arr: Array[Int]): Int = {
  val map = scala.collection.mutable.Map.empty[Int, Int]
  for (n <- arr) {
    map(n) = map.getOrElse(n, 0) + 1
  }

  var set = 0
  var left = arr.length
  for ((_, n) <- map.toArray.sortInPlaceBy(-_._2) if left > arr.length / 2) {
    left -= n
    set += 1
  }

  set
}