package hellowKotlin

import java.lang.Integer.parseInt

/**
 * Created by 39092 on 2017/5/26.
 */
object KotlinMain {
    @JvmStatic
    fun main(attrs: Array<String>) {
        println(sum(1, 2))
        println(sum1(2, 3))
        printSum(3, 4)
        varAndval()
        maxOf(4, 5)
        printProduct("123", "123")
        println(getStrLength("3"))
        funFor()
        funWhile()
        funWhen()
        funRange()
        funLambda()
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
        println("$a  $b  $c")
    }

    fun maxOf(a: Int, b: Int) = if (a > b) a else b

    fun printProduct(arg1: String, arg2: String) {
        val x = parseInt(arg1)
        val y = parseInt(arg2)
        if (x != null && y != null) {
            println(x * y)
        } else {
            println("either '$arg1' or '$arg2' is not a number")
        }
    }

    fun getStrLength(obj: Any): Int? {
        if (obj is String && obj.length > 0)
            return obj.length
        else
            return null
    }

    fun funFor() {
        val items = listOf<String>("1", "2", "3")
        for (a in items)
            print(a + "  ")
        for (index in items.indices)
            print(items[index] + "  ")
        println()
    }

    fun funWhile() {
        val items = listOf<String>("1", "2", "3")
        var index = 0
        while (index < items.size) {
            print(items[index])
            index++
        }
        println()
    }

    fun funWhen() {
        var a: Int = 4
        val list = listOf(1, 2, 3)
        when (a) {
            in list -> println("$a in list")
            !in list -> println("out of range")
        }
    }

    fun funRange() {
        val x = 3
        if (x in 1..10)
            println(x)
        for (y in 1..10 step 2)
            print(y)
        println()
        for (y in 10 downTo 0 step 2)
            print(y)
        println()
    }

    fun funLambda() {
        var vegetables = listOf("orange", "apple", "banana")
        vegetables.filter { it.endsWith("e") }
                .map { it.toUpperCase() }
                .flatMap { listOf(it, it + "a") }
                .sortedBy { it }
                .forEach { print(it + " ") }
        println()
    }
}