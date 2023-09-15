func maxProfit(k int, prices []int) int {
	dp := make([][][2]int, len(prices)+1)

	for i := 0; i < len(prices); i++ {
		dp[i] = make([][2]int, k+1)
		for j := 0; j <= k; j++ {
			dp[i][j][0], dp[i][j][1] = math.MinInt32, math.MinInt32
		}
	}

	dp[0][0][0] = 0
	dp[0][1][1] = -prices[0]
	for i := 1; i < len(prices); i++ {
		for j := 0; j <= k; j++ {
			dp[i][j][0] = max(+prices[i]+dp[i-1][j][1], dp[i-1][j][0])
			if j > 0 {
				dp[i][j][1] = max(-prices[i]+dp[i-1][j-1][0], dp[i-1][j][1])
			}

		}
	}

	res := 0
	for i := 0; i <= k; i++ {
		res = max(res, dp[len(prices)-1][i][0])
	}
	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}