val n = readln().toInt()

val arr = Array(n) { readln().split(" ").map{ it.toInt() } }
val dp = Array(n) { 0 }

for (i in 0 until n) {
    if (i + arr[i][0] <= n) {
        if (i > 0) dp[i] = maxOf(dp[i], dp[i - 1])
        dp[i + arr[i][0]] = maxOf(dp[i + arr[i][0]], dp[i] + arr[i][1])
    }
}

println(dp.maxOrNull()!!)