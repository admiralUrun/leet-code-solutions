def nextGreatestLetter(letters: Array[Char], target: Char): Char = letters
  .filter(c => c > target)
  .minOption
  .getOrElse(letters.head)
