def numJewelsInStones(jewels: String, stones: String): Int = {
  val jewelsSet = jewels.toSet

  stones.count(jewelsSet.contains)
}