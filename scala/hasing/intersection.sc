def intersection(nums: Array[Array[Int]]): List[Int] = nums
  .flatten
  .groupBy(identity)
  .filter { case (_, v) => v.length == nums.length }
  .keys
  .toSeq
  .sorted
  .toList