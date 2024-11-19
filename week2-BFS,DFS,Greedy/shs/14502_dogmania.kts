import java.util.*

var n = 0
var m = 0
val dx = arrayOf<Int>(1, -1, 0, 0)
val dy = arrayOf<Int>(0, 0, 1, -1)

data class Point(val x: Int, val y: Int)

fun bfs(g: MutableList<MutableList<Int>>, walls: MutableList<Point>): Int {
    val graph = g.map{ it.toMutableList() }
    val dq : ArrayDeque<Point> = ArrayDeque()
    var count = 0

    for (wall in walls) {
        graph[wall.y][wall.x] = 1
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 2) dq.addLast(Point(j, i))
        }
    }

    while(dq.isNotEmpty()) {
        val currentNode = dq.removeFirst()
        val currentX = currentNode.x
        val currentY = currentNode.y

        for (i in 0 until 4) {
            val nx = currentX + dx[i]
            val ny = currentY + dy[i]

            if (nx in 0 until m && ny in 0 until n && graph[ny][nx] == 0) {
                graph[ny][nx] = 2
                dq.addLast(Point(nx, ny))
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 0) count += 1
        }
    }

    return count
}

fun main() {
    readln().split(" ").map{ it.toInt() }.let {
        n = it[0]
        m = it[1]
    }

    val graph: MutableList<MutableList<Int>> = mutableListOf()
    val safeArea: MutableList<Point> = mutableListOf()
    var answer = 0

    repeat(n) { i ->
        val row = readln().split(" ").map{ it.toInt() }.toMutableList()
        graph.add(row)

        row.forEachIndexed { j, value ->
            if (value == 0) {
                safeArea.add(Point(j, i))
            }
        }
    }

    val safeAreaCount = safeArea.size
    for (i in 0 until safeAreaCount) {
        for (j in i + 1 until safeAreaCount) {
            for (k in j + 1 until safeAreaCount) {
                val walls = mutableListOf<Point>( safeArea[i], safeArea[j], safeArea[k] )

                val ans = bfs(graph, walls)

                if (ans > answer) answer = ans
            }
        }
    }

    println(answer)
}

main()