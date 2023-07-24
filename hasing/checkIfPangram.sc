def checkIfPangram(sentence: String): Boolean = {
  val allCharts = sentence
    .toArray
    .groupBy(identity)

  sentence.nonEmpty && ('a' to 'z').forall(c => allCharts.contains(c))
}