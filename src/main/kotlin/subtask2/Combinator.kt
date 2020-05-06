package subtask2

class Combinator {


    fun checkChooseFromArray(array: Array<Int>): Int? {
        val m = array[0] //number of posters
        val n = array[1] //available colors
        var x = 0
        var combinationsNumber = 1

        fun factorial(number: Int): Long{
            var numberFactorial = 1L
            for (i in 1..number) numberFactorial*=i
            return numberFactorial
        }

        while (combinationsNumber < m && combinationsNumber != 0){
            x++
            combinationsNumber = (factorial(n) / (factorial(n - x) * factorial(x))).toInt()
            println("cn "+ combinationsNumber)
        }

        if (combinationsNumber == m) return x
        else return null
    }
}
