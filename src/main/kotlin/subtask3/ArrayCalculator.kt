package subtask3

import java.lang.Math.abs


class ArrayCalculator {

    // TODO: Complete the following function
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        var array: Array<Int> = arrayOf()
        var numberOfItems =numberOfItems
        var lastNegativeValue = 0
        var numberOfNegativeElements = 0
        var product = 1
        itemsFromArray.filterIsInstance<Int>().forEach {array+=it}
        var sortedArray = array.sorted().toIntArray()

        if (sortedArray.isEmpty()) return 0

        if(numberOfItems > sortedArray.size) {
            sortedArray.forEach { product *= it }
            return product
        }


        while(numberOfItems > 0){
            if (sortedArray.first() < 0 && (abs(sortedArray.first()) > sortedArray.last())){
                product *= sortedArray.first()
                lastNegativeValue = sortedArray.first()
                numberOfNegativeElements++
                sortedArray = sortedArray.drop(1).toIntArray()

            }else {
                product *= sortedArray.last()
                sortedArray = sortedArray.dropLast(1).toIntArray()

            }
            numberOfItems--
        }

        if (numberOfNegativeElements % 2 == 0) return product
        else{
            product /= lastNegativeValue
            if (sortedArray.isNotEmpty()) product *= sortedArray.last()
            return product
        }

    }
}
