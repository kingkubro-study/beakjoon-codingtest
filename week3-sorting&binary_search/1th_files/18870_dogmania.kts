import java.util.*

fun main() {
    val n = readln().toInt()
    val num = readln().split(" ").map { it.toInt() }
    val mp = num.toSet().sorted().withIndex().associate { it.value to it.index }
    val result = num.joinToString(" ") { "${mp[it]}" }
    
    println(result)
}

main()