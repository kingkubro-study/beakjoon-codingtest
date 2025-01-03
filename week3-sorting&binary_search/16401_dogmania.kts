import java.util.*

var n = 0
var m = 0

fun binarySearch(arr: List<Int>) : Int {
    var first = 1
    var last = arr[arr.size - 1]
    var max = 0

    while(first <= last) {
        var mid = (first + last) / 2
        var count = 0

        for (num in arr) {
            if (num < mid) continue

            count += num / mid
            
            if (count >= m) break
        }

        if (count >= m) {
            max = mid
            first = mid + 1
        } else {
            last = mid - 1
        }
    }

    return max
}

fun main() {
    readln().split(" ").map{ it.toInt() }.let {
        m = it[0]
        n = it[1]
    }
    val arr = readln().split(" ").map { it.toInt() }.sorted()
    val answer = binarySearch(arr)
    
    println(answer)
}

main()