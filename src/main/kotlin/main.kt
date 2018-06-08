import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 *
 *   Created by Dilip Maharjan on 07-06-2018
 */
fun main(args: Array<String>) {
    print("Enter  a number")
    val input = readLine()
    fakeIntput(input!!.toInt()).subscribe {
        if (it == 10) print(it) else print("Dam")
    }
    anthoerFakeInput().blockingSubscribe {
        println(it)
    }
}

fun fakeIntput(userInput: Int): Observable<Int> {
    return Observable.just(userInput).map { data -> data * 2 }
}

fun anthoerFakeInput(): Observable<Long> {
    return Observable.intervalRange(0, 20, 5, 2, TimeUnit.SECONDS).map { it ->
        it
    }
}