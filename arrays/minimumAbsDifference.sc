def minimumAbsDifference(arr: Array[Int]): List[List[Int]] = {
  arr.sorted
    .sliding(2)
    .foldLeft((Int.MaxValue, List.empty[List[Int]])) {
      case ((min, acc), Array(x, y)) =>
        val diff = y - x
        if (diff < min) (diff, List(List(x, y)))
        else if (diff == min) (min, List(x, y) :: acc)
        else (min, acc)
      case _ => (Int.MaxValue, List.empty[List[Int]])
    }
    ._2
    .reverse
}