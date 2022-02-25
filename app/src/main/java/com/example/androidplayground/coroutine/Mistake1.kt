package com.example.androidplayground.coroutine

import kotlinx.coroutines.*

// wrong way: it will fire the call and wait until it finishes sequentially that could take 1000L * userIds.size
//suspend fun getUserFirstNames(userIds: List<String>): List<String> {
//    val firstNames = mutableListOf<String>()
//    for (id in userIds) {
//        firstNames.add(getFirstName(id))
//    }
//
//    return firstNames
//}


// it will not wait for the previous calls to be finished first, instead, it will only fire all the calls sequentially
suspend fun getUserFirstNames(userIds: List<String>): List<String> {
    val firstNames = mutableListOf<Deferred<String>>()
    coroutineScope {
        for (id in userIds) {
            val firstName = async {
                getFirstName(id)
            }
            firstNames.add(firstName)
        }
    }

    return firstNames.awaitAll()
}



suspend fun getFirstName(userId: String): String {
    delay(1000L)
    return "First name"
}