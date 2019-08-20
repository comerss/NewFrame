package com.comers.shenwu.sdk

class LamdaTest {
    fun main(args: Array<String>) {
        event(1, { a, b ->
            (a + b).toInt()
        })
        setOnKotlin({ a, b ->
            a+b
        })
    }

    fun event(ass: Int, b: (num1: Int, num2: Long) -> Int): Int {
        return ass + b.invoke(3, 4)
    }

    fun setOnKotlin(listener: (num1: Int, num2: Int) -> Unit) {
        listener.invoke(2,3)
    }

}
