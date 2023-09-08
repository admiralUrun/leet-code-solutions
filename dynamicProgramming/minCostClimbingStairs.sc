def minCostClimbingStairsIterative(cost: Array[Int]): Int = {
  var oneStep = cost(0)
  var twoSteps = cost(1)

  for (i <- 2 until cost.length) {
    val curr = math.min(oneStep, twoSteps) + cost(i)
    oneStep = twoSteps
    twoSteps = curr
  }

  math.min(oneStep, twoSteps)
}

def minCostClimbingStairs(cost: Array[Int]): Int = {
  val dp = scala.collection.mutable.HashMap.empty[Int, Int]

  def minCostClimbingStairs(i: Int): Int = {
    if (i <= 1) 0
    else if (dp.contains(i)) dp(i)
    else {
      dp(i) = math.min(minCostClimbingStairs(i - 1) + cost(i - 1), minCostClimbingStairs(i - 2) + cost(i - 2))
      dp(i)
    }
  }

  minCostClimbingStairs(cost.length)
}