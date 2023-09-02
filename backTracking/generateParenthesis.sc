def generateParenthesis(n: Int): List[String] = {
  var answer: List[String] = Nil

  def backtracking(left: Int, right: Int, string: List[Char]): Unit = {
    if (string.length == 2 * n) answer = string.reverse.mkString :: answer
    else {
      if (left < n) backtracking(left + 1, right, '(' :: string)
      if (right < left) backtracking(left, right + 1, ')' :: string)
    }
  }


  backtracking(1, 0, List('('))
  answer
}