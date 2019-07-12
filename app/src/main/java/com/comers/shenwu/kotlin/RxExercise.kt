package com.comers.shenwu.kotlin

import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import java.util.*
import kotlin.collections.ArrayList
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Consumer
import io.reactivex.rxkotlin.subscribeBy
import java.util.concurrent.TimeUnit

class RxExercise{


    /**
     * 给Android开发者的RxJava详解
     * https://gank.io/post/560e15be2dca930e00da1083
     *
     * RxKotlin
     * https://github.com/ReactiveX/RxKotlin/blob/2.x/README.md
     *
     * RxJava系列
     * https://www.jianshu.com/p/823252f110b0
     *
     * RxJava2看这一篇文章就够了
     * https://juejin.im/post/5b17560e6fb9a01e2862246f
     *
     *
     * 基础类：
     * Flowable: 多个流，响应式流和背压
     * Observable: 多个流，无背压   (被观察者)
     * Single: 只有一个元素或者错误的流
     * Completable: 没有任何元素，只有一个完成和错误信号的流
     * Maybe: 没有任何元素或者只有一个元素或者只有一个错误的流
     *
     *
     * 调度器种类：
     * Schedulers.computation()
     * 用于计算任务，如事件循环或和回调处理，不要用于IO操作(IO操作请使用Schedulers.io())；默认线程数等于处理器的数量
     *
     * Schedulers.from(executor)            使用指定的Executor作为调度器
     *
     * Schedulers.single()                  该调度器的线程池只能同时执行一个线程
     *
     * Schedulers.io()
     * 用于IO密集型任务，如异步阻塞IO操作，这个调度器的线程池会根据需要增长；
     * 对于普通的计算任务，请使用Schedulers.computation()；
     * 默认是一个CachedThreadScheduler，很像一个有线程缓存的新线程调度器
     *
     * Schedulers.newThread()              为每个任务创建一个新线程
     *
     * Schedulers.trampoline()              当其它排队的任务完成后，在当前线程排队开始执行。
     *
     * AndroidSchedulers.mainThread()          主线程，UI线程，可以用于更新界面
     *
     *
     * 注意：本例部分结果未打印 因为在这里有延时但线程已挂掉 正常在Android中使用是没事的
     *
     * Created by KYLE on 2019/4/28 - 19:57
     */
    fun main() {
        // ---------------- `Observable` 创建事件序列的方法 ----------------
        println("---------------- `Observable`创建事件序列的方法 ----------------")
        create()
        interval()
        defer()
        emptyNeverError()
        repeat()
        timer()
        from()
        just()
        range()
        println()


        // ---------------- `Observable` 变换操作 ----------------
        println("---------------- `Observable`变换操作 ----------------")
        mapCast()
        flatMap2contactMap()
        flatMapExample()
        flatMapIterable()
        buffer()
        groupBy()
        scan()
        window()
        println()


        // ---------------- `Observable` 过滤操作/条件操作符 ----------------
        println("---------------- `Observable` 过滤操作/条件操作符 ----------------")
        filter()
        element()
        distinct()
        skip()
        take()
        ignoreElements()
        debounce()
        ofType()
        all()
        contains()
        isEmpty()
        defaultIfEmpty()
        amb()
        println()


        // ---------------- `Observable` 组合操作 ----------------
        println("---------------- `Observable` 组合操作 ----------------")
        concat()
        merge()
        startWith()
        zip()
        combineLast()
        reduce()
        collect()
        count()
        println()


        // ------------------- 功能操作符/辅助操作 -------------------
        println("------------------- 功能操作符/辅助操作 -------------------")
        delay()
        doSeries()
        retry()
        subscribeOn()
        observeOn()
        println()


        // ---------------- RxKotlin扩展库 ----------------
        println("---------------- RxKotlin扩展库 ----------------")
        rkExExample()
        println()


        // ------------------- 额外 其他 -------------------
        println("------------------- 额外 其他 -------------------")
        compose()
        println()
    }

    /**
     * 使用基本`create()`方法创建事件序列
     */
    fun create() {
        print("[create]: ")
        Observable.create<String> { emitter ->
            with(emitter) {
                onNext("Hello")
                onNext("Handsome")
                onNext("Kotlin")
                onComplete()
            }
        }.subscribe(object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                print("onSubscribe ")
            }

            override fun onError(e: Throwable) {}

            override fun onComplete() {
                print(" onComplete ")
            }

            override fun onNext(t: String) {
                print("$t  ")
            }
        })
        println()
    }

    /**
     * 使用`interval()`方法创建事件序列
     * 间隔发射
     */
    fun interval() {
        print("[interval]: ")

        // 每隔1秒发送一个整数 从0开始 (默认执行无数次 使用`take(int)`方法限制执行次数)
        val disposable = Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(5)
                .subscribe { print("$it  ") }
        if (!disposable.isDisposed) disposable.dispose()

        println()

        /*
            其他重载方法：
            public static Observable<Long> interval(long initialDelay, long period, TimeUnit unit, Scheduler scheduler)
            public static Observable<Long> interval(long period, TimeUnit unit, Scheduler scheduler)
            public static Observable<Long> intervalRange(long start, long count, long initialDelay, long period, TimeUnit unit, Scheduler scheduler)

            `initialDelay`参数用来指示开始发射第一个整数的之前要停顿的时间，时间的单位与period一样，都是通过unit参数来指定的；
            `period`参数用来表示每个发射之间停顿多少时间；
            `unit`表示时间的单位，是TimeUnit类型的；
            `scheduler`参数指定数据发射和等待时所在的线程。
         */
    }

    /**
     * 使用`defer()`方法创建事件序列
     *
     * `defer`直到有观察者订阅时才创建Observable，并且为每个观察者创建一个新的Observable
     * `defer`操作符会一直等待直到有观察者订阅它，然后它使用Observable工厂方法生成一个Observable
     */
    fun defer() {
        print("[defer]: ")

        val observable =
                Observable.defer { Observable.just(System.currentTimeMillis()) }
        observable.subscribe { print("$it ") }   // 454  订阅时才产生了Observable
        print("   ")
        observable.subscribe { print("$it ") }   // 459  订阅时才产生了Observable

        println()
    }

    /**
     * 使用`empty()` `never()` `error()`方法创建事件序列
     *
     * public static <T> Observable<T> `empty()`：创建一个不发射任何数据但是正常终止的Observable
     * public static <T> Observable<T> `never()`：创建一个不发射数据也不终止的Observable
     * public static <T> Observable<T> `error(Throwable exception)`：创建一个不发射数据以一个错误终止的Observable
     */
    fun emptyNeverError() {
        print("[empty]: ")

        Observable.empty<String>().subscribeBy(
                onNext = { print(" next ") },
                onComplete = { print(" complete ") },
                onError = { print(" error ") }
        )
        // `empty()`只会调用onComplete方法

        println()

        print("[never]: ")

        Observable.never<String>().subscribeBy(
                onNext = { print(" next ") },
                onComplete = { print(" complete ") },
                onError = { print(" error ") }
        )
        // 什么也不会做

        println()

        print("[error]: ")

        Observable.error<Exception>(Exception()).subscribeBy(
                onNext = { print(" next ") },
                onComplete = { print(" complete ") },
                onError = { print(" error ") }
        )
        // `error()`只会调用onError方法

        println()
    }

    /**
     * 使用`repeat()`方法创建事件序列
     *
     * 表示指定的序列要发射多少次
     */
    fun repeat() {
        // 重载方法
        // public final Observable<T> repeat(long times)
        // public final Observable<T> repeatUntil(BooleanSupplier stop)
        // public final Observable<T> repeatWhen(Function<? super Observable<Object>, ? extends ObservableSource<?>> handler)

        print("[repeat]: ")

        // 不指定次数即无限次发送(内部调用有次数的重载方法并传入Long.MAX_VALUE)  别执行啊 ~ 卡的不行 ~
        // Observable.range(5, 10).repeat().subscribe { print("$it  ") }

        Observable.range(5, 10).repeat(1).subscribe { print("$it  ") }

        println()

        print("[repeatUntil]: ")

        // repeatUntil在满足指定要求的时候停止重复发送，否则会一直发送
        // 这里当随机产生的数字`<10`时停止发送 否则继续  (这里始终为true(即停止重复) 省的疯了似的执行)
        val numbers = arrayOf(0, 1, 2, 3, 4)
        numbers.toObservable().repeatUntil {
            Random(10).nextInt() < 10
        }.subscribe { print("$it  ") }

        println()
    }

    /**
     * 使用`timer()`方法创建事件序列
     *
     * 执行延时任务
     *
     * 创建一个在给定的时间段之后返回一个特殊值的Observable，它在延迟一段给定的时间后发射一个简单的数字0
     */
    fun timer() {
        print("[timer]: ")

        // 在500毫秒之后输出一个数字0
        val disposable = Observable.timer(500, TimeUnit.MILLISECONDS).subscribe { print("$it  ") }
        if (!disposable.isDisposed) disposable.dispose()

        println()
    }

    /**
     * 使用`from()`方法快捷创建事件队列
     *
     * `fromArray`
     * `fromCallable`
     * `fromIterable`  (和上面的fromArray类似 只不过这里是集合罢了)
     *
     * 将传入的数组依次发送出来
     */
    fun from() {
        print("[fromArray]: ")

        val names = arrayOf("ha", "hello", "yummy", "kt", "world", "green", "delicious")
        // 注意：使用`*`展开数组
        val disposable = Observable.fromArray(*names).subscribe { print("$it  ") }
        if (!disposable.isDisposed) disposable.dispose()

        println()

        print("[fromCallable]: ")

        // 可以在Callable内执行一段代码 并返回一个值给观察者
        Observable.fromCallable { 1 }.subscribe { print("$it  ") }

        println()
    }

    /**
     * 使用`just()`方法快捷创建事件队列
     *
     * 将传入的参数依次发送出来(最少1个 最多10个)
     */
    fun just() {
        print("[just]: ")

        val disposable = Observable.just("Just1", "Just2", "Just3")
                // 将会依次调用：
                // onNext("Just1");
                // onNext("Just2");
                // onNext("Just3");
                // onCompleted();
                .subscribe { print("$it  ") }
        if (!disposable.isDisposed) disposable.dispose()

        println()
    }

    /**
     * 使用`range()`方法快捷创建事件队列
     *
     * 创建一个序列
     */
    fun range() {
        print("[range]: ")

        // 用Observable.range()方法产生一个序列
        // 用map方法将该整数序列映射成一个字符序列
        // 最后将得到的序列输出来 forEach内部也是调用的 subscribe(Consumer<? super T> onNext)
        val disposable = Observable.range(0, 10)
                .map { item -> "range$item" }
//        .forEach { print("$it  ") }
                .subscribeBy(
                        onNext = { print("$it  ") },
                        onComplete = { print("range complete !!! ") }
                )
        if (!disposable.isDisposed) disposable.dispose()

        println()
    }

    /**
     * 使用`map()` `cast()` 做变换操作
     *
     * `map`操作符对原始Observable发射的每一项数据应用一个你选择的函数，然后返回一个发射这些结果的Observable。默认不在任何特定的调度器上执行
     *
     * `cast`操作符将原始Observable发射的每一项数据都强制转换为一个指定的类型`（多态）`，然后再发射数据，它是map的一个特殊版本
     */
    fun mapCast() {
        print("[map]: ")

        Observable.range(1, 5).map { item -> "to String $item" }.subscribe { print("$it  ") }

        println()

        print("[cast]: ")

        // 将`Date`转换为`Any` (如果前面的Class无法转换成第二个Class就会出现ClassCastException)
        Observable.just(Date()).cast(Any::class.java).subscribe { print("$it  ") }

        println()
    }

/*
    `map`与`flatMap`的区别(出自朱凯):
    `map`是在一个 item 被发射之后，到达 map 处经过转换变成另一个 item ，然后继续往下走；
    `flapMap`是 item 被发射之后，到达 flatMap 处经过转换变成一个 Observable
    而这个 Observable 并不会直接被发射出去，而是会立即被激活，然后把它发射出的每个 item 都传入流中，再继续走下去。
 */

    /**
     * 使用`flatMap()` `contactMap()` 做变换操作
     *
     * `flatMap`将一个发送事件的上游Observable变换为多个发送事件的Observables，然后将它们发射的事件合并后放进一个单独的Observable里
     * `flatMap`不保证顺序  `contactMap()`保证顺序
     */
    fun flatMap2contactMap() {
        print("[flatMap]: ")

        /*
            `flatMap()` 的原理是这样的：
            1. 使用传入的事件对象创建一个 Observable 对象；
            2. 并不发送这个 Observable, 而是将它激活，于是它开始发送事件；
            3. 每一个创建出来的 Observable 发送的事件，都被汇入同一个 Observable ，
            而这个 Observable 负责将这些事件统一交给 Subscriber 的回调方法。
            这三个步骤，把事件拆成了两级，通过一组新创建的 Observable 将初始的对象『铺平』之后通过统一路径分发了下去。
            而这个『铺平』就是 flatMap() 所谓的 flat。
         */

        Observable.range(1, 5).flatMap {
            Observable.just("$it to flat")
        }.subscribe { print("$it  ") }

        println()

        print("[contactMap]: ")

        Observable.range(1, 5).concatMap {
            Observable.just("$it to concat")
        }.subscribe { print("$it  ") }

        println()

    }

    /**
     * `flatMap`挺重要的，再举一个例子
     *
     * 依次打印Person集合中每个元素中Plan的action
     */
    fun flatMapExample() {
        print("[flatMapExample]: ")

        arrayListOf(
                Person("KYLE", arrayListOf(Plan(arrayListOf("Study RxJava", "May 1 to go home")))),
                Person("WEN QI", arrayListOf(Plan(arrayListOf("Study Java", "See a Movie")))),
                Person("LU", arrayListOf(Plan(arrayListOf("Study Kotlin", "Play Game")))),
                Person("SUNNY", arrayListOf(Plan(arrayListOf("Study PHP", "Listen to music"))))
        ).toObservable().flatMap {
            Observable.fromIterable(it.planList)
        }.flatMap {
            Observable.fromIterable(it.actionList)
        }.subscribeBy(
                onNext = { print("$it  ") }
        )

        println()
    }

    /**
     * 使用`flatMapIterable()`做变换操作
     *
     * 将上流的任意一个元素转换成一个Iterable对象
     */
    fun flatMapIterable() {
        print("[flatMapIterable]: ")

        Observable.range(1, 5)
                .flatMapIterable { integer ->
                    Collections.singletonList("$integer")
                }
                .subscribe { print("$it  ") }

        // [flatMapIterable]: 1  2  3  4  5

        println()
    }

    /**
     * 使用`buffer()`做变换操作
     *
     * 用于将整个流进行分组
     */
    fun buffer() {
        print("[buffer]: ")

        // 生成一个7个整数构成的流，然后使用`buffer`之后，这些整数会被3个作为一组进行输出

        // count 是一个buffer的最大值
        // skip 是指针后移的距离(不定义时就为count)
        // 例如 1 2 3 4 5 buffer(3) 的结果为：[1,2,3] [4,5]      (buffer(3)也就是buffer(3,3))
        // 例如 1 2 3 4 5 buffer(3,2) 的结果为：[1,2,3] [3,4,5] [5]
        Observable.range(1, 5).buffer(3)
                .subscribe {
                    print("${Arrays.toString(it.toIntArray())}  ")
                }

        println()
    }

    /**
     * 使用`groupBy()`做变换操作
     *
     * 用于分组元素(根据groupBy()方法返回的值进行分组)
     * 将发送的数据进行分组，每个分组都会返回一个被观察者。
     */
    fun groupBy() {
        print("[groupBy]: ")

        // 使用concat方法先将两个Observable拼接成一个Observable，然后对其元素进行分组。
        // 这里我们的分组依据是整数的值，这样我们将得到一个Observable<GroupedObservable<Integer, Integer>>类型的Observable。
        // 然后，我们再将得到的序列拼接成一个，并进行订阅输出

        Observable.concat(Observable.concat(
                Observable.range(1, 3), Observable.range(1, 4)
        ).groupBy { it }
        ).subscribe { print("groupBy: $it  ") }

        // [groupBy]: groupBy: 1  groupBy: 1  groupBy: 2  groupBy: 2  groupBy: 3  groupBy: 3  groupBy: 4

        println()
    }

    /**
     * 使用`scan()`做变换操作
     *
     * 将数据以一定的逻辑聚合起来
     *
     * scan操作符对原始Observable发射的第一项数据应用一个函数，然后将那个函数的结果作为自己的第一项数据发射。
     * 它将函数的结果同第二项数据一起填充给这个函数来产生它自己的第二项数据。
     * 它持续进行这个过程来产生剩余的数据序列。这个操作符在某些情况下被叫做`accumulator`
     */
    fun scan() {
        print("[scan]: ")

        val disposable = Observable.just(1, 2, 3, 4, 5)
                .scan { t1: Int, t2: Int -> t1 + t2 }
                .subscribe { print("$it  ") }
        if (!disposable.isDisposed) disposable.dispose()

        // [scan]: 1  3  6  10  15

        println()
    }

    /**
     * 使用`window()`做变换操作
     *
     * 将事件分组 参数`count`就是分的组数
     *
     * `window`和`buffer`类似，但不是发射来自原始Observable的数据包，它发射的是Observable，
     * 这些Observables中的每一个都发射原始Observable数据的一个子集，最后发射一个onCompleted通知。
     */
    fun window() {
        print("[window]: ")

        Observable.range(1, 10).window(3)
                .subscribeBy(
                        onNext = { it.subscribe { int -> print("{${it.hashCode()} : $int} ") } },
                        onComplete = { print("onComplete ") }
                )

        println()
    }

    /**
     * 使用`filter()`做过滤操作
     *
     * 对源做过滤
     */
    fun filter() {
        print("[filter]: ")

        // 过滤掉 <=5 的数据源 只有 >5 的数据源会发送出去
        Observable.range(1, 10).filter { it > 5 }.subscribe { print("$it  ") }

        println()
    }

    /**
     * 使用`element()`获取源中指定位置的数据
     *
     * `elementAt`  指定位置
     * `firstElement`  第一个
     * `lastElement`   最后一个
     */
    fun element() {
        print("[elementAt]: ")

        // `elementAt` 在输入的 index 超出事件序列的总数就不会出现任何结果
        // `elementAtOrError` 则会报异常
        // `first...` 和 `last...` 都类似

        // 只有index=0的数据源会被发射
        Observable.range(1, 10).elementAt(0).subscribe { print("$it  ") }

        println()

        print("[firstElement]: ")

        Observable.range(1, 19).firstElement().subscribe { print("$it  ") }

        println()

        print("[lastElement]: ")

        Observable.range(34, 2).lastElement().subscribe { print("$it  ") }

        println()
    }

    /**
     * 使用`distinct()`对源中相同的数据进行过滤
     */
    fun distinct() {
        print("[distinct]: ")

        Observable.just(1, 1, 1, 2, 3, 4, 1, 5, 5, 6)
                .distinct()
                .subscribe { print("$it  ") }

        // [distinct]: 1  2  3  4  5  6

        println()

        print("[distinctUntilChanged]: ")

        Observable.just(1, 1, 1, 2, 3, 4, 1, 5, 5, 6)
                .distinctUntilChanged()
                .subscribe { print("$it  ") }

        // [distinctUntilChanged]: 1  2  3  4  1  5  6

        println()
    }

    /**
     * 使用`skip()` 过滤掉数据的前n项
     *
     * `skip`         过滤掉数据的前n项 参数count代表跳过事件的数量
     * `skipLast`     与`skip` 功能相反 过滤掉数据的后n项
     * `skipUntil`    当 skipUntil() 中的 Observable 发送事件了，原来的 Observable 才会发送事件给观察者。
     * `skipWhile`    可以设置条件，当某个数据满足条件时不发送该数据，反之则发送。
     */
    fun skip() {
        print("[skip]: ")

        Observable.just(1, 2, 3, 4, 5, 6)
                .skip(2)
                .subscribe { print("$it  ") }

        // [skip]: 3  4  5  6

        println()

        print("[skipUntil]: ")

        Observable.just(6)
                .skipUntil<Int> { Observable.just(2).delay(2, TimeUnit.SECONDS).subscribe { print("$it  ") } }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe { print("$it  ") }

        println()

        print("[skipWhile]: ")

        Observable.just(1, 2, 3, 4)
                .skipWhile {
                    it < 3
                }.subscribe { print("$it  ") }

        // [skipWhile]: 3  4

        println()
    }

    /**
     * 使用`take()` 取数据的前n项
     *
     * `take`          取数据的前n项 参数count代表取的事件的数量
     * `takeLast`      与`take`功能相反 取数据的后n项
     * `takeUntil`
     * `takeWhile`
     *
     * 与`skip...`对应
     */
    fun take() {
        print("[take]: ")

        Observable.range(1, 5).take(2).subscribe { print("$it  ") }

        // [take]: 1  2

        println()
    }

    /**
     * 使用`ignoreElements()` 过滤所有源Observable产生的结果
     *
     * 只会把Observable的`onComplete`和`onError`事件通知给订阅者
     */
    fun ignoreElements() {
        print("[ignoreElements]: ")

        Observable.just(1, 1, 2, 3, 4)
                .ignoreElements()
                .subscribeBy(
                        onComplete = { print(" onComplete ") },
                        onError = { print(" onError ") }
                        // 没有`onNext`
                )

        println()
    }

    /**
     * 使用`debounce()` 限制发射频率过快
     *
     * 如果两件事件发送的时间间隔小于设定的时间间隔则`前一件`事件就不会发送给观察者
     */
    fun debounce() {

        print("[debounce]: ")

        Observable.create<Int> { emitter ->
            emitter.onNext(1)
            Thread.sleep(900)
            emitter.onNext(2)
        }.debounce(1, TimeUnit.SECONDS)
                .subscribe { print("$it  ") }

        // 2

        println()
    }

    /**
     * 使用`ofType()` 过滤不符合该类型事件
     */
    fun ofType() {
        print("[ofType]: ")

        Observable.just(1, 2, 3, "k", "Y")
                .ofType(String::class.java)
                .subscribe { print("$it  ") }

        // [ofType]: k  Y

        println()
    }

    /**
     * `all`
     *
     * 判断事件序列是否全部满足某个事件，如果都满足则返回 true，反之则返回 false
     */
    fun all() {
        print("[all]: ")

        Observable.just(1, 2, 3, 4)
                .all { it < 5 }
                .subscribe(Consumer {
                    print("$it  ")
                })

        // [all]: true

        println()
    }

    /**
     * `contains`
     *
     * 判断事件序列中是否含有某个元素，如果有则返回 true，如果没有则返回 false。
     */
    fun contains() {
        print("[contains]: ")

        Observable.just(1, 2, 3, 4)
                .contains(3)
                .subscribe(Consumer {
                    print("$it  ")
                })

        // [contains]: true

        println()
    }

    /**
     * `isEmpty`
     *
     * 判断事件序列是否为空  是返回true  否返回false
     */
    fun isEmpty() {
        print("[isEmpty]: ")

        Observable.create<String> { emitter ->
            emitter.onComplete()
        }.isEmpty
                .subscribe(Consumer {
                    print("$it  ")
                })

        // [isEmpty]: true

        println()
    }

    /**
     * `defaultIfEmpty`
     *
     * 如果观察者只发送一个 onComplete() 事件，则可以利用这个方法发送一个值。
     */
    fun defaultIfEmpty() {
        print("[defaultIfEmpty]: ")

        Observable.create<Int> { emitter ->
            emitter.onComplete()
        }.defaultIfEmpty(666)
                .subscribe { print("$it  ") }

        // [defaultIfEmpty]: 666

        println()

    }

    /**
     * `amb`
     *
     * amb() 要传入一个 Observable 集合，但是只会发送最先发送事件的 Observable 中的事件，其余 Observable 将会被丢弃。
     */
    fun amb() {
        print("[amb]: ")

        val list = ArrayList<Observable<Long>>()
        list.add(Observable.intervalRange(1, 5, 2, 1, TimeUnit.SECONDS))
        list.add(Observable.intervalRange(6, 5, 0, 1, TimeUnit.SECONDS))

        Observable.amb(list)
                .subscribe { print("$it  ") }

        // [amb]:  6  7  8  9  10

        println()
    }

    /**
     * 使用`concat()`做组合操作
     *
     * 将多个Observable拼接起来，但是它会严格按照传入的Observable的顺序进行发射，一个Observable没有发射完毕之前不会发射另一个Observable里面的数据
     *
     * `concat()`方法内部还是调用的`concatArray(source1, source2)`方法，只是在调用前对传入的参数做了`null`判断
     *
     * 与 `merge()` 作用基本一样，只是 `merge()` 是并行发送事件，而 concat() 串行发送事件
     */
    fun concat() {
        print("[concat]: ")

        val disposable = Observable.concat(Observable.range(1, 5), Observable.range(6, 5))
                .subscribe { print("$it  ") }
        if (!disposable.isDisposed) disposable.dispose()

        // [concat]: 1  2  3  4  5  6  7  8  9  10

        println()
    }

    /**
     * 使用`merge` 做组合操作
     *
     * 让多个数据源的数据合并起来进行发射(merge后的数据可能会交错发射)
     * 与 `concat()` 作用基本一样，只是 `concat()` 是串行发送事件，而 merge() 并行发送事件
     *
     * 内部实际操作为调用了`fromArray()+flatMap`方法 只是在调用前对数据源参数做了`null`判断
     *
     * 与`mergeError`的比较
     * `mergeError`方法与`merge`方法的表现一致，
     * 只是在处理由`onError`触发的错误的时候有所不同。
     * `mergeError`方法会等待所有的数据发射完毕之后才把错误发射出来，即使多个错误被触发，该方法也只会发射出一个错误信息。
     * 而如果使用`merger`方法，那么当有错误被触发的时候，该错误会直接被抛出来，并结束发射操作
     */
    fun merge() {
        print("[merge]: ")

        Observable.merge(Observable.range(1, 5), Observable.range(6, 5))
                .subscribe { print("$it  ") }

        // [merge]: 1  2  3  4  5  6  7  8  9  10

        println()
    }

    /**
     * 使用`startWith` 做组合操作 在发送事件之前追加事件
     *
     * `startWith`         追加一个事件
     * `startWithArray`    追加多个事件
     *
     * `追加的事件会先发出`
     *
     * `startWith`方法可以用来在指定的数据源的之前插入几个数据
     */
    fun startWith() {
        print("[startWith]: ")

        Observable.range(5, 3)
                .startWithArray(1, 2, 3, 4)
                .startWith(0).subscribe { print("$it  ") }

        // [startWith]: 0  1  2  3  4  5  6  7


        println()
    }

    /**
     * 使用`zip` 做组合操作
     *
     * 用来将多个数据项进行合并 根据各个被观察者发送事件的顺序一个个结合起来，最终发送的事件数量会与源 Observable 中最少事件的数量一样
     * 为什么呢？因为数据源少的那个 Observable 发送完成后发送了 onComplete 方法，所以数据源多的那个就不会再发送事件了
     */
    fun zip() {
        print("[zip]: ")

        Observable.zip(Observable.range(1, 6), Observable.range(6, 5),
                BiFunction<Int, Int, Int> { t1, t2 -> t1 * t2 })
                .subscribe { print("$it  ") }

        // 1 2 3 4  5 6
        // 6 7 8 9 10
        // 看上面两行再看结果很明显了吧

        // [zip]: 6  14  24  36  50

        println()
    }

    /**
     * 使用`combineLast` 做组合操作
     *
     * 用第一个数据源的最后一项和第二个数据源的每一项做合并
     */
    fun combineLast() {
        print("[combineLast]: ")

        Observable.combineLatest(Observable.range(1, 6), Observable.range(6, 5),
                BiFunction<Int, Int, Int> { t1, t2 -> t1 * t2 })
                .subscribe { print("$it  ") }

        // 1 2 3 4  5 6
        // 6 7 8 9 10
        // 看上面两行再看结果很明显了吧

        // [combineLast]: 36  42  48  54  60

        println()
    }

    /**
     * 使用`reduce` 做组合操作
     *
     * 与 scan() 操作符的作用一样也是将发送数据以一定逻辑聚合起来，
     * 这两个的区别在于 scan() 每处理一次数据就会将事件发送给观察者，而 reduce() 会将所有数据聚合在一起才会发送事件给观察者
     */
    fun reduce() {
        print("[reduce]: ")

        Observable.just(0, 1, 2, 3)
                .reduce { t1, t2 -> t1 + t2 }
                .subscribe { print("$it  ") }

        // [reduce]: 6

        println()
    }

    /**
     * 使用`collect` 做组合操作
     *
     * 将数据收集到数据结构当中
     */
    fun collect() {
        print("[collect]: ")

        // `collect`接收两个参数 第一个是要收集到的数据解构 第二个是数据到数据结构中的操作
        Observable.just(1, 2, 3, 4)
                .collect({ ArrayList<Int>() }, { t1, t2 -> t1.add(t2) })
                .subscribe(Consumer<ArrayList<Int>> {
                    print("$it  ")
                })

        // [collect]: [1, 2, 3, 4]

        println()
    }

    /**
     * 使用`count` 做组合操作
     *
     * 返回被观察者发送事件的数量
     */
    fun count() {
        print("[count]: ")

        Observable.just(1, 2, 3)
                .count()
                .subscribe(Consumer {
                    print("$it  ")
                })

        // [count]: 3

        println()
    }

    /**
     * 用于在发射数据之前停顿指定的时间
     */
    fun delay() {
        print("[delay]: ")

        Observable.range(1, 5).delay(1, TimeUnit.SECONDS).subscribe { print("$it  ") }

        println()
    }

    /**
     * do 系列
     */
    fun doSeries() {
        print("[doSeries]: ")
        // `doOnEach`  当每个`onNext`调用[前]触发 并可取出`onNext`发送的值  但是方法参数是一个`Notification<T>`的包装 可以通过`.value`取出`onNext`的值
        // `doOnNext`  在每个`onNext`调用[前]触发 并可取出`onNext`发送的值  方法参数就是`onNext`的值
        // `doAfterNext`   在每个`onNext`调用[后]触发 并可取出`onNext`发送的值  方法参数就是`onNext`的值
        // `doOnComplete`  在`onComplete`调用[前]触发
        // `doOnError`  在`onError`调用[前]触发
        // `doOnSubscribe`  在`onSubscribe`调用[前]触发
        // `doOnDispose`  在调用 Disposable 的 dispose() 之[后]回调该方法
        // `doOnTerminate `  在 onError 或者 onComplete 发送之[前]回调
        // `doAfterTerminate `   在onError 或者 onComplete 发送之[后]回调  取消订阅后就不会回调
        // `doFinally`   在所有事件发送完毕之后回调该方法   即使取消订阅也会回调
        // `onErrorReturn`   当接受到一个 onError() 事件之后回调，返回的值会回调 onNext() 方法，并正常结束该事件序列
        // `onErrorResumeNext`   当接收到 onError() 事件时，返回一个新的 Observable，并正常结束事件序列
        // `onExceptionResumeNext`   与 onErrorResumeNext() 作用基本一致，但是这个方法只能捕捉 Exception

        // Test Code:
        Observable.create<String> { emitter ->
            emitter.onNext("K")
            emitter.onNext("Y")
            emitter.onNext("L")
            emitter.onNext("E")
            emitter.onComplete()
        }.doOnTerminate {
            print("doOnNext: $  ")
        }.subscribeBy(
                onNext = { print("accept: $it  ") },
                onComplete = { print("  onComplete  ") },
                onError = { print("  onError  ") }
        )

        println()
    }

    /**
     * `retry`
     *
     * 另：`retryUntil` 出现错误事件之后，可以通过此方法判断是否继续发送事件 true不重试 false重试
     *
     * 如果出现错误事件，则会重新发送所有事件序列。times 是代表重新发的次数。
     */
    fun retry() {
        print("[retry]: ")

        Observable.create<String> { emitter ->
            emitter.onNext("K")
            emitter.onError(Exception("404"))
        }
                .retry(2)
                .subscribeBy(
                        onNext = { print("accept: $it  ") },
                        onComplete = { print("  onComplete  ") },
                        onError = { print("  onError  ") }
                )

        // [retry]: accept: K  accept: K  accept: K    onError
        // 重试了2次

        println()
    }

    /**
     * `subscribeOn`
     *
     * 指定被观察者的线程，要注意的时，如果多次调用此方法，只有第一次有效。
     */
    fun subscribeOn() {
        print("[subscribeOn]: ")

//    Observable.create<String> { emitter ->
//        emitter.onNext("K")
//        print("current thread: ${Thread.currentThread().name}")
//    }.subscribeOn(Schedulers.computation()).subscribe()

        // current thread: RxComputationThreadPool-2

        println()
    }

    /**
     * `observeOn`
     *
     * 指定观察者的线程，每指定一次就会生效一次。
     */
    fun observeOn() {
        print("[observeOn]: ")

//    Observable.create<String> { emitter ->
//        emitter.onNext("K")
//    }.observeOn(Schedulers.io())
//        .subscribe { print("current thread: ${Thread.currentThread().name}") }

        // current thread : RxCachedThreadScheduler -1

        println()
    }

    /**
     * RxKotlin扩展库的一个简单使用
     * 也是RxKotlin官方给出的一个例子
     *
     * 更多查看：https://github.com/ReactiveX/RxKotlin/blob/2.x/README.md
     */
    fun rkExExample() {
        print("[rkExExample]: ")

        val list = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

        // 相当于是Observable.fromIterable(this) 和上面的fromArray()类似 一个数组 一个集合
        list.toObservable()  // extension function for Iterables
                .filter { it.length > 5 }
                .subscribeBy(   // 对应上面`create`创建方式的最后调用的subscribe
                        onNext = { print("$it  ") },
                        onError = { it.printStackTrace() },
                        onComplete = { print(" Done! ") }
                )

        // Result:
        // [rkExExample]: Epsilon   Done!
        println()
    }


    /**
     * `compose`
     * 与`Transformer`连用
     *
     * `compose`操作符和Transformer结合使用，一方面让代码看起来更加简洁化，另一方面能够提高代码的复用性。
     * RxJava提倡链式调用，`compose`能够防止链式被打破。
     *
     * compose操作于整个数据流中，能够从数据流中得到原始的Observable<T>/Flowable<T>...
     * 当创建Observable/Flowable...时，compose操作符会立即执行，而不像其他的操作符需要在onNext()调用后才执行
     */
    fun compose() {
        println("[compose]: ")

        Observable.just(1, 2)
                .compose(transformerInt2String())
                .compose(applySchedulers())
                .subscribe {
                    print("$it  ")
                    if (it == "1") print(" ${Thread.currentThread().name} ")
                }

        println()
    }


    // 用于`flatMap`举例子
    data class Person(private val name: String, val planList: List<Plan>)

    data class Plan(val actionList: List<String>)

    // 用于`compose`举例子
// 将发射的Int转换为String
    fun transformerInt2String() = ObservableTransformer<Int, String> { upstream -> upstream.map { int -> "$int" } }

    // 切换线程
    fun <T> applySchedulers() =
            ObservableTransformer<T, T> { upstream -> upstream.observeOn(Schedulers.io()).subscribeOn(Schedulers.io()) }

}
