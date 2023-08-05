def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
  val result = scala.collection.mutable.ListBuffer[List[Int]]()

  def searchRec(remain: Int, from: Int, comb: List[Int]): Unit = {
    if (remain == 0) result += comb
    else if (remain > 0) {
      for (i <- from until candidates.length) {
        searchRec(remain - candidates(i), i, candidates(i) :: comb)
      }
    }
  }

  searchRec(target, 0, Nil)

  result
    .map(_.sorted)
    .distinct
    .toList
}