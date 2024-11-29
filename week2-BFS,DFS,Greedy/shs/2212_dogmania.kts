fun main() {
    val n = readln().toInt()
    val k = readln().toInt()
    var flag = 0
    var answer = 0
    var sensor = readln().split(" ").map{ it.toInt() }.toMutableList()
    var distance = mutableListOf<Int>()

    sensor = sensor.sorted().toMutableList()

    for (i in 0 until n - 1) {
        val d = sensor[i + 1] - sensor[i]
        distance.add(d)
    }

    distance = distance.sortedDescending().toMutableList()

    for (d in distance) {
        flag += 1
        if (flag <= k - 1) continue

        answer += d
    }

    println(answer)
}

main()