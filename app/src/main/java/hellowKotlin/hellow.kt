package hellowKotlin

/**
 * Created by 39092 on 2017/5/26.
 */
object KotlinMain {
    @JvmStatic fun main(attrs: Array<String>) {
        println(sum(1, 2))
        println(sum1(2, 3))
        printSum(3, 4)
        varAndval()
        maxOf(4, 5)
    }

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun sum1(a: Int, b: Int) = a + b

    fun printSum(a: Int, b: Int): Unit {
        println("sum of $a and $b is ${a + b}")
    }

    fun varAndval() {
        val a: Int = 1
        val b = 2
//        b+=1 语法错误b是常量
        var c = 3
        c += 1
        print("$a  $b  $c")
    }

    fun maxOf(a: Int, b: Int) = if (a > b) a else b
}