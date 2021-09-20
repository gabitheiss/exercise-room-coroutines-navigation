package com.example.exercise_room_coroutines

class Runner {

    fun main(){

        runOperation(5,5, ::sum)

        runOperation(5,5, ::multiply)
    }


    fun runOperation(num1: Int, num2: Int, operation: (Int,Int)-> Int): Int{
        return operation(num1, num2)
    }

    fun sum(num1: Int, num2: Int): Int{
        return num1 + num2
    }

    fun multiply(num1: Int, num2: Int): Int{
        return num1 * num2
    }

}