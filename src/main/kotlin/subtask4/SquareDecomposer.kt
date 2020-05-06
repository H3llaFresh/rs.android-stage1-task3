package subtask4

import kotlin.math.pow

class SquareDecomposer {
    fun decomposeNumber(number: Int): Array<Int>? {
        val decomposeStartElement = number - 1
        var differenceBetweenSecondPowers: Double
        var decomposeArrayStart: IntArray = intArrayOf()
        var finalArray: Array<Int> = arrayOf()

        if(number < 3) return null

        decomposeArrayStart += number
        decomposeArrayStart += decomposeStartElement

        fun decomposer(decomposeArrayParam: IntArray) : IntArray{
            var decomposeArray = decomposeArrayParam
            var decomposeElement = decomposeArray.last()
            val decomposeArrayStartState = decomposeArray

            differenceBetweenSecondPowers = (decomposeArray[0].toDouble().pow(2)
                                            - decomposeArray[1].toDouble().pow(2))
            decomposeArray = decomposeArray.drop(2).toIntArray()

            while(!decomposeArray.isEmpty()){
                differenceBetweenSecondPowers -= decomposeArray[0].toDouble().pow(2)
                decomposeArray = decomposeArray.drop(1).toIntArray()
            }

            decomposeArray = decomposeArrayStartState

            while(differenceBetweenSecondPowers != 0.0 ){
                while(decomposeElement.toDouble().pow(2) > differenceBetweenSecondPowers) decomposeElement--
                differenceBetweenSecondPowers -= decomposeElement.toDouble().pow(2)
                if (decomposeElement < decomposeArray.last()) decomposeArray += decomposeElement
                else {
                    decomposeArray = decomposeArray.dropLast(1).toIntArray()
                    decomposeArray[decomposeArray.size - 1]--
                    decomposeArray = decomposer(decomposeArray)
                }
            }
            return decomposeArray
        }


        return (decomposer(decomposeArrayStart).drop(1)).reversed().toTypedArray()

    }
}
