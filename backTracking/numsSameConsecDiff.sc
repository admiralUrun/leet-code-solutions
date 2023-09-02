def numsSameConsecDiff(n: Int, k: Int): Array[Int] = {
  val buffer = scala.collection.mutable.Buffer.empty[Int]

  def listToInt(list: List[Int]): Int = {
    var resultingInt: Int = 0

    for (i <- list) {
      resultingInt = resultingInt * 10 + i
    }

    resultingInt
  }

  def backTrack(acc: List[Int]): Unit = {
    if (acc.length == n) buffer.addOne(listToInt(acc.reverse))
    else {
      for (i <- 0 to 9) {
        if (acc.isEmpty) {
          if (i > 0) backTrack(i :: acc)
        } else {
          if (math.abs(acc.head - i) == k) backTrack(i :: acc)
        }
      }
    }
  }


  backTrack(Nil)
  buffer.toArray
}