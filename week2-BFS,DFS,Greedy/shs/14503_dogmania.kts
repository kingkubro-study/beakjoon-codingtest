var n = 0
var m = 0
var x = 0
var y = 0
var d = 0

val dx = listOf<Int>(0, 1, 0, -1)
val dy = listOf<Int>(-1, 0, 1, 0)

fun bfs(graph: MutableList<MutableList<Int>>): Int {
    var count = 0
    val dq: ArrayDeque<Triple<Int, Int, Int>> = ArrayDeque()
    dq.addLast(Triple(x, y, d))
    
    while(!dq.isEmpty()) {
        val currentNode = dq.first()
        var isExist = false
        dq.removeFirst()
        val currentX = currentNode.first
        val currentY = currentNode.second
        val currentD = currentNode.third

        if (graph[currentY][currentX] == 0) {
            graph[currentY][currentX] = 2
            count += 1
        }

        for (i in 0 until 4) {
            val nx = currentX + dx[i]
            val ny = currentY + dy[i]

            if (nx in 0 until m && ny in 0 until n && graph[ny][nx] == 0) {
                isExist = true
                break
            } 
        }

        if (isExist) {
            val newD = (currentD + 3) % 4
            val nx = currentX + dx[newD]
            val ny = currentY + dy[newD]

            if (nx in 0 until m && ny in 0 until n && graph[ny][nx] == 0) {
                dq.addLast(Triple(nx, ny, newD))
            } else {
                dq.addLast(Triple(currentX, currentY, newD))
            }
        } else {
            val newD = (currentD + 2) % 4
            val nx = currentX + dx[newD]
            val ny = currentY + dy[newD]

            if (nx in 0 until m && ny in 0 until n && graph[ny][nx] == 1) {
                return count
            } else if (nx in 0 until m && ny in 0 until n) {
                dq.addLast(Triple(nx, ny, currentD))
            }
        }
    }

    return count
}

fun main() {
    val graph: MutableList<MutableList<Int>> = mutableListOf()

    readln().split(" ").map{ it.toInt() }.apply {
        n = this[0]
        m = this[1]
    }
    readln().split(" ").map{ it.toInt() }.apply {
        y = this[0]
        x = this[1]
        d = this[2]
    }

    repeat(n) {
        graph.add(readln().split(" ").map{ it.toInt() }.toMutableList())
    }

    val answer = bfs(graph)

    println(answer)
}

main()