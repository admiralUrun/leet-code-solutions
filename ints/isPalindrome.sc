def isPalindrome(x: Int): Boolean = {
  var copy = x
  var reverse = 0

  while (copy > 0) {
    reverse = reverse * 10 + copy % 10
    copy = copy / 10
  }

  reverse == x
}