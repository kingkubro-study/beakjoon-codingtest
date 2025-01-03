import java.util.*

fun main() {
    var n = 0
    var m = 0
    var answer: Long = 0L
    val num = PriorityQueue<Long>()

    readln().split(" ").map{ it.toInt() }.let {
        n = it[0]
        m = it[1]
    }

    readln().split(" ").map{ num.offer(it.toLong()) }

    repeat(m) {
        val num1: Long = num.poll()
        val num2: Long = num.poll()
        val sum: Long = num1 + num2

        num.offer(sum)
        num.offer(sum)
    }

    while(!num.isEmpty()) {
        answer += num.poll()
    }

    println(answer)
}

main()