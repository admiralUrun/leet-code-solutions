def minFlips(a: Int, b: Int, c: Int): Int = {
  var countToFlip = 0
  var (aCopy, bCopy, cCopy) = (a, b, c)
  while (aCopy != 0 | bCopy != 0 | cCopy != 0) {
    if ((cCopy & 1) == 1) {
      if ((aCopy & 1) == 0 && (bCopy & 1) == 0) countToFlip += 1
    }
    else countToFlip += (aCopy & 1) + (bCopy & 1)
    aCopy >>= 1
    bCopy >>= 1
    cCopy >>= 1
  }
  countToFlip
}