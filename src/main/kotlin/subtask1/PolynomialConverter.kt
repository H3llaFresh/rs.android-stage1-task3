package subtask1

class PolynomialConverter {



    fun convertToStringFrom(numbers: Array<Int>): String? {
        val size = numbers.size
        var finalString: String = ""


        if (size == 0) return null

        for (i in numbers.indices){
            if (numbers[i] > 0)
                if (numbers[i] == 1) when(i){
                    0 -> finalString += "x^${size - (i + 1)}"
                    numbers.lastIndex - 1 -> finalString += " + x"
                    numbers.lastIndex -> finalString += " + ${numbers[i]}"
                    else -> finalString += " + x^${size - (i + 1)}"
                }
                else
                    when(i){
                        0 -> finalString += "${numbers[i]}x^${size - (i + 1)}"
                        numbers.lastIndex - 1 -> finalString += " + ${numbers[i]}x"
                        numbers.lastIndex -> finalString += " + ${numbers[i]}"
                        else -> finalString += " + ${numbers[i]}x^${size - (i + 1)}"
                    }

            if (numbers[i] < 0)
                if (numbers[i] == -1) when(i){
                    numbers.lastIndex - 1 -> finalString += " - x"
                    numbers.lastIndex -> finalString += " - ${numbers[i] * -1}"
                    else -> finalString += " - x^${size - (i + 1)}"
                } else when(i){
                    numbers.lastIndex - 1 -> finalString += " - ${numbers[i] * -1}x"
                    numbers.lastIndex -> finalString += " - ${numbers[i] * -1}"
                    else -> finalString += " - ${numbers[i] * -1}x^${size - (i + 1)}"
                }
        }


        return finalString
        throw NotImplementedError("Not implemented")
    }
}
