def countElements(arr: Array[Int]): Int = {
  val hashMap = arr.groupBy(identity)
  arr.count(n => hashMap.contains(n + 1))
}