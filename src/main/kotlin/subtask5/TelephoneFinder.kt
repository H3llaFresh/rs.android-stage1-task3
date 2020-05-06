package subtask5

import kotlin.reflect.KClass

class TelephoneFinder {


    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        var resultArray : Array<String> = arrayOf()
        val keypad = Array(4, { Array(4, {""}) })
        keypad[0] = arrayOf("1", "2", "3")
        keypad[1] = arrayOf("4", "5", "6")
        keypad[2] = arrayOf("7", "8", "9")
        keypad[3] = arrayOf("", "0", "")

        if (number.contains("-")) return null

        for (i in number.indices)
            for(x in 0..3){
                for(y in 0..2){
                    if (keypad[x][y] == (number[i]).toString()){
                        when(x){
                            0 -> resultArray += number.replace(number[i].toString(), keypad[x + 1][y])

                            1 -> {
                                resultArray += number.replace(number[i].toString(), keypad[x - 1][y])
                                resultArray += number.replace(number[i].toString(), keypad[x + 1][y])
                            }

                            2 -> {
                                if(y == 1) resultArray += number.replace(number[i].toString(), keypad[x + 1][y])
                                resultArray += number.replace(number[i].toString(), keypad[x - 1][y])
                            }

                            3 -> resultArray += number.replace(number[i].toString(), keypad[x - 1][y])
                        }

                        when(y){
                            0 -> resultArray += number.replace(number[i].toString(), keypad[x][y + 1])

                            1 -> {
                                if (x != 3){
                                    resultArray += number.replace(number[i].toString(), keypad[x][y - 1])
                                    resultArray += number.replace(number[i].toString(), keypad[x][y + 1])
                                }
                            }

                            2 -> resultArray += number.replace(number[i].toString(), keypad[x][y - 1])
                        }
                        break
                    }
                }
            }
        return resultArray
    }
}
