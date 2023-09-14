var size = 0
func backtracking(row int, diagonals map[int]bool, antiDiagonals map[int]bool, cols map[int]bool) int {
	if row == size {
		return 1
	} else {
		solutions := 0
		for col := 0; col < size; col++ {
			diagonal := row - col
			antiDiagonal := row + col
			if !diagonals[diagonal] && !antiDiagonals[antiDiagonal] && !cols[col] {
				diagonals[diagonal] = true
				antiDiagonals[antiDiagonal] = true
				cols[col] = true
				solutions += backtracking(row+1, diagonals, antiDiagonals, cols)
				diagonals[diagonal] = false
				antiDiagonals[antiDiagonal] = false
				cols[col] = false
			}
		}
		return solutions
	}

}

func totalNQueens(n int) int {
	size = n
	return backtracking(0, make(map[int]bool), make(map[int]bool), make(map[int]bool))
}