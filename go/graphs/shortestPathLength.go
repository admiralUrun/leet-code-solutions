package graphs

func shortestPathLength(graph [][]int) int {
	queue := []Pair{}
	seen := make(map[Pair]bool)
	endingMask := (1 << len(graph)) - 1

	for i := range graph {
		pair := Pair{node: i, mask: 1 << i}
		queue = append(queue, pair)
		seen[pair] = true
	}

	steps := 0
	for len(queue) != 0 {
		nextQueue := []Pair{}

		for i := 0; i < len(queue); i++ {
			pair := queue[i]
			for _, neighbor := range graph[pair.node] {
				nextMask := pair.mask | (1 << neighbor)
				if nextMask == endingMask {
					return steps + 1
				}

				newPair := Pair{node: neighbor, mask: nextMask}
				if !seen[newPair] {
					seen[newPair] = true
					nextQueue = append(nextQueue, newPair)
				}
			}
		}
		steps++
		queue = nextQueue
	}

	return 0
}

type Pair struct {
	node int
	mask int
}
