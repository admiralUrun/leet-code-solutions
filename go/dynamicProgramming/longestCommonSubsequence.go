func longestCommonSubsequence(text1 string, text2 string) int {
	dp := make([][]int, len(text2)+1)
	dp[0] = make([]int, len(text1)+1)
	for i := 1; i <= len(text2); i++ {
		dp[i] = make([]int, len(text1)+1)
		for j := 1; j <= len(text1); j++ {
			if text1[j-1] == text2[i-1] {
				dp[i][j] = dp[i-1][j-1] + 1
			} else {
				dp[i][j] = max(dp[i-1][j], dp[i][j-1])
			}
		}
	}
	return dp[len(text2)][len(text1)]
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}