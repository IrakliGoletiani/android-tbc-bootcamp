package homework


/** 1 */

fun task1(numberArray: Array<Int>): Int{
    val newSet = numberArray.toSet()

    return newSet.size
}

/** 2 */

fun task2(list1: List<Int>,list2: List<Int>): Set<Int> {
    return list1.intersect(list2)
}

/** 3 */

fun task3(list1: List<Int>,list2: List<Int>): Set<Int> {
    return list1.union(list2)
}

/** 4 */

fun task4(list: List<Int>): List<Int>{
    val average = list.average()

    val newList = arrayListOf<Int>()

    list.forEach { number ->
        if(number < average){
            newList.add(number)
        }
    }

    return newList
}

/** 5 */

fun task5(list: List<Int>) {
    val uniqueList = list.toSortedSet().toList()

    println("მეორე მინიმალური: ${uniqueList[1]}")

    println("მეორე მაქსიმალური: ${uniqueList[uniqueList.size - 2]}")
}