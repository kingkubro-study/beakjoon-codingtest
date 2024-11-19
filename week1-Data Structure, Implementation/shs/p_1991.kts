import java.util.*

fun main() {
    val n = readln().toInt()
    val mp = mutableMapOf<String, Array<String>>()
    val visited = mutableMapOf<String, Boolean>()
    val answer = Array<String>(3) { "" }

    repeat(n) {
        val input = readln().split(" ")
    
        mp[input[0]] = arrayOf<String>(input[1], input[2])
        visited[input[0]] = false
    }

    println(preorder(m = mp, v = visited, root = "A"))
    println(inorder(m = mp, v = visited, root = "A"))
    println(postorder(m = mp, v = visited, root = "A"))
}

fun preorder(m: MutableMap<String, Array<String>>, v: MutableMap<String, Boolean>, root: String): String {
    val stack = Stack<String>()
    val map = m.toMutableMap()
    val visited = v.toMutableMap()
    var answer = ""

    stack.push(root)
    answer += root

    while(stack.isNotEmpty()) {
        val top = stack.peek()
        visited[top] = true
    
        val leftChild = map[top]!![0]
        val rightChild = map[top]!![1]
    
        if (leftChild != null && leftChild != "." && visited[leftChild] == false) {
            stack.push(leftChild)
            answer += leftChild 
            continue
        }
    
        if (rightChild != null && rightChild != "." && visited[rightChild] == false) {
            stack.push(rightChild)
            answer += rightChild
            continue
        }
    
        stack.pop()
    }

    return answer
}

fun inorder(m: MutableMap<String, Array<String>>, v: MutableMap<String, Boolean>, root: String): String {
    val stack = Stack<String>()
    val map = m.toMutableMap()
    val visited = v.toMutableMap()
    var current: String? = root
    var answer = ""


    while (current != null || stack.isNotEmpty()) {
        while (current != null && current != ".") {
            stack.push(current)
            current = map[current]?.get(0)
        }

        if (stack.isNotEmpty()) {
            current = stack.pop()
            answer += current

            current = map[current]?.get(1)
            if (current == ".") {
                current = null 
            }
        }
    }

    return answer
}

fun postorder(m: MutableMap<String, Array<String>>, v: MutableMap<String, Boolean>, root: String): String {
    val stack = Stack<String>()
    val map = m.toMutableMap()
    val visited = v.toMutableMap()
    var current: String? = root
    var answer = ""

    while (stack.isNotEmpty() || current != null) {
        while (current != null && current != ".") {
            stack.push(current)
            current = map[current]?.get(0)
        }

        current = stack.peek()
        val rightChild = map[current]?.get(1)

        if (rightChild != null && rightChild != "." && visited[rightChild] == false) {
            current = rightChild
        } else {
            answer += current
            visited[current!!] = true
            stack.pop()
            current = null
        }
    }

    return answer
}

main()