package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

var acquired = 0

class Resource { init {
    acquired++
}

    // Acquire the resource
    fun close() {
        acquired--
    } // Release the resource
}

fun main() {
    runBlocking {
        repeat(100_000) {
            launch {
                val resource = withTimeout(60) { // Timeout of 60 ms
                    delay(50) // Delay for 50 ms Resource() // Acquire a resource and return it from withTimeout block
                    Resource()
                }

                resource.close() // Release the resource }
            }

        }
        println(acquired)
    }
}