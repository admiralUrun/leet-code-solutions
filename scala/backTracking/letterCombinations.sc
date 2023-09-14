def letterCombinations(digits: String): List[String] = {
  val phoneMapping = Map(
    '2' -> "abc",
    '3' -> "def",
    '4' -> "ghi",
    '5' -> "jkl",
    '6' -> "mno",
    '7' -> "pqrs",
    '8' -> "tuv",
    '9' -> "wxyz"
  )
  var answer = List.empty[String]

  def backtracking(string: List[Char], i: Int): Unit = {
    if (digits.length == string.length) answer = string.reverse.mkString :: answer
    else {
      for (c <- phoneMapping(digits(i))) {
        backtracking(c :: string, i + 1)
      }
    }
  }


  if (digits.isEmpty) Nil
  else {
    backtracking(Nil, 0)
    answer
  }
}