def containsDuplicate(nums: Array[Int]): Boolean = {
  val set = scala.collection.mutable.HashSet.empty[Int]
  nums.exists(n => !set.add(n))
}