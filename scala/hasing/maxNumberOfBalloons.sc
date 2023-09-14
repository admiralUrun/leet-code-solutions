def maxNumberOfBalloons(text: String): Int = {
  val ban = "ban"
  val lo = "lo"
  val hashMap = scala.collection.mutable.HashMap.empty[Char, Int]
  text.foreach(c => hashMap.update(c, hashMap.getOrElse(c, 0) + 1))

  if (ban.forall(hashMap.contains) && lo.forall(c => hashMap.get(c).exists(_ >= 2))) (ban.flatMap(hashMap.get) ++ lo.flatMap(hashMap.get).map(_ / 2)).min
  else 0
}