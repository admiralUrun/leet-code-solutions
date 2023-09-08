def rob(nums: Array[Int]): Int = {
  if (nums.length == 1) return nums.head

  val memo = scala.collection.mutable.HashMap.empty[Int, Int]

  def dp(i: Int): Int = {
    if (i == 0) nums.head
    else if (i == 1) math.max(nums.head, nums(1))
    else if (memo.contains(i)) memo(i)
    else {
      dp(i) = math.max(dp(i - 1), dp(i - 2) + nums(i))
      dp(i)
    }
  }

  dp(nums.length - 1)
}

def robTailRec(nums: Array[Int]): Int = {
  def robTailRec(i: Int = 0, a: Int = 0, b: Int = 0): Int = {
    if (i + 1 == nums.length) a max b + nums(i)
    else robTailRec(i + 1, a max b + nums(i), a)
  }

  robTailRec()
}

