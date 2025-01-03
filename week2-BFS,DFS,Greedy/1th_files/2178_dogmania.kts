import java.util.*

var n = 0
var m = 0
val dx = listOf(1, -1, 0, 0)
val dy = listOf(0, 0, 1, -1)

data class Point(val x: Int, val y: Int, val count: Int)

fun bfs(graph: MutableList<MutableList<Int>>): Int {
    val dq = ArrayDeque<Point>()
    val visited: MutableList<MutableList<Boolean>> = MutableList(n) { MutableList(m) { false } }

    dq.addLast(Point(0, 0, 1))
    visited[0][0] = true

    while(dq.isNotEmpty()) {
        val currentNode = dq.removeFirst()

        if (currentNode.x == m - 1 && currentNode.y == n - 1) return currentNode.count
        
        for (i in 0 until 4) {
            val nx = currentNode.x + dx[i]
            val ny = currentNode.y + dy[i]

            if (nx in 0 until m && ny in 0 until n && !visited[ny][nx] && graph[ny][nx] == 1) {
                dq.addLast(currentNode.copy(x = nx, y = ny, count = currentNode.count + 1))
                visited[ny][nx] = true
            }
        }
    }

    return 0
}

fun main() {
    readln().split(" ").map{ it.toInt() }.let {
        n = it[0]
        m = it[1]
    }
    val graph: MutableList<MutableList<Int>> = MutableList(n) { MutableList(m) { 0 } }

    repeat(n) { i ->
        val input = readln()
        
        repeat(m) { j ->
            graph[i][j] = input[j].digitToInt()
        }
    }

    val answer = bfs(graph)
    println(answer)
}

main()