package string

import "unicode"

func decodeAtIndex(s string, k int) string {
	var size int64

	for _, ch := range s {
		if unicode.IsDigit(ch) {
			size *= int64(ch - '0')
		} else {
			size++
		}
	}

	for i := len(s) - 1; i >= 0; i-- {
		r := rune(s[i])
		k %= int(size)

		if k == 0 && unicode.IsLetter(r) {
			return string(r)
		}

		if unicode.IsDigit(r) {
			size /= int64(s[i] - '0')
		} else {
			size--
		}

	}

	return ""
}
