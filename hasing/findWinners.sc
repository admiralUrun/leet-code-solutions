def findWinners(matches: Array[Array[Int]]): List[List[Int]] = {
  val players = matches.flatten.distinct
  val losers = matches.map(_(1)).groupBy(identity)

  List(
    players.filter(p => !losers.contains(p)).sorted.toList,
    players.filter(p => losers.get(p).exists(_.length == 1)).sorted.toList
  )
}