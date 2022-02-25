package com.example.androidplayground.coroutine

import kotlinx.coroutines.*
import kotlin.random.Random

//suspend fun doSomething() {
//    val job = CoroutineScope(Dispatchers.Default).launch {
//        var random = Random.nextInt(100_000)
//        while (random != 5000) {
//            random = Random.nextInt(100_000)
//        }
//    }
//
//    delay(500L)
//    job.cancel()
//}

suspend fun doSomething() {
    val job = CoroutineScope(Dispatchers.Default).launch {
        var random = Random.nextInt(100_000)
        while (random != 5000 && isActive) {
            random = Random.nextInt(100_000)
            ensureActive() // same as isActive
        }
    }

    delay(500L)
    job.cancel()
}