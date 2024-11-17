fun main() {
    val n = readln().toInt()
    var answer = 0
    val score = mutableListOf<Int>()

    repeat(n) {
        score.add(readln().toInt())
    }

    for (i in n - 1 downTo 1) {
        while(score[i] <= score[i - 1]) {
            score[i - 1] -= 1
            answer += 1
        }
    }

    println(answer)
}

main()