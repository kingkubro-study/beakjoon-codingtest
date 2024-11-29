val input = readln().split(" ").map { it.toInt() }
val n = input[0]
val m = input[1]
val arr = (1..n).toMutableList()
val num = readln().split(" ").map { it.toInt() }.toMutableList()
var answer = 0

while (num.isNotEmpty()) {
    val target = num.removeFirst()
    val targetIndex = arr.indexOf(target)

    if (targetIndex <= arr.size / 2) {
        repeat(targetIndex) {
            arr.add(arr.removeFirst()) 
            answer++
        }
    } else {
        repeat(arr.size - targetIndex) {
            arr.add(0, arr.removeLast())
            answer++
        }
    }

    arr.removeAt(0)
}

println(answer)