package stack

func removeDuplicateLetters(s string) string {
	var stack []byte
	count := make(map[byte]int)

	for i := range s {
		count[s[i]]++
	}

	visited := make(map[byte]bool)

	for i := range s {
		count[s[i]]--

		if visited[s[i]] {
			continue
		}

		for len(stack) > 0 && s[i] < stack[len(stack)-1] && count[stack[len(stack)-1]] > 0 {
			visited[stack[len(stack)-1]] = false
			stack = stack[:len(stack)-1]
		}

		stack = append(stack, s[i])
		visited[s[i]] = true
	}

	return string(stack)
}
