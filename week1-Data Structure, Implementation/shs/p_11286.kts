import kotlin.math.abs
import java.util.PriorityQueue

val n = readln().toInt()
val queue = PriorityQueue<Int> { a, b ->
    if (abs(a) == abs(b)) a - b else abs(a) - abs(b)
}

repeat(n) {
    val num = readln().toInt()

    if (num == 0) {
        if (queue.isEmpty()) {
            println(0)
        } else {
            println(queue.poll())
        }
    } else {
        queue.add(num)
    }
}

