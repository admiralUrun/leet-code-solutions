def findMaxAverage(nums: Array[Int], k: Int): Double = {
  var (answer, sum) = (0d, 0d)
  for (i <- 0 until k) {
    sum += nums(i)
  }
  answer = sum / k

  for (i <- k until nums.length) {
    sum += nums(i) - nums(i - k)
    answer = math.max(answer, sum / k)
  }


  answer
}