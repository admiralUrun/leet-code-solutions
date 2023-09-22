package string

func isSubsequence(s string, t string) bool {
	i, j, n, m := 0, 0, len(s), len(t)

	for i < n && j < m {
		if s[i] == t[j] {
			i += 1
		}
		j += 1
	}

	return i == n
}
