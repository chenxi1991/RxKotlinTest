package hellowKotlin

/**
 * Created by 39092 on 2017/5/26.
 */
object KotlinMain {
    @JvmStatic fun main(attrs: Array<String>) {
        println(sum1(1, 2))
        printSum(2, 3)
    }

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun sum1(a: Int, b: Int) = a + b

    fun printSum(a: Int, b: Int) {
        print("sum of $a and $b is ${a + b}")
    }
}