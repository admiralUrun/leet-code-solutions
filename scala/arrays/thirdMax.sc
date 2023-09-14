def thirdMax(nums: Array[Int]): Int = {
  var firstMax = Long.MinValue
  var secondMax = Long.MinValue
  var thirdMax = Long.MinValue

  for (n <- nums) {
    if (n > firstMax) {
      thirdMax = secondMax
      secondMax = firstMax
      firstMax = n
    } else if (n < firstMax && n > secondMax) {
      thirdMax = secondMax
      secondMax = n
    } else if (n < secondMax && n > thirdMax) {
      thirdMax = n
    }
  }

  if (thirdMax != Long.MinValue) thirdMax.toInt else firstMax.toInt
}