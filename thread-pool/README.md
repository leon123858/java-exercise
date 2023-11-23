# HW for java TP

- What’s a thread pool?
- What’s the difference between thread pool and connection
pool?
- Create a thread pool with Singleton pattern

## What’s a thread pool?

A thread pool is a collection of threads that can be used to perform
several tasks in the background without interrupting the main program.

## What’s the difference between thread pool and connection pool?

A connection pool is a cache of database connections maintained so that 
the connections can be reused when future requests to the database are required. 


簡單來說就是: 建立 connection 之後, 
會把 connection 存在 cache 裡面, 等到下次要用的時候, 
就不用再重新建立 connection 了, 而 connection 的本質依照資料庫而異,
可能是一個 TCP/IP 連線, 也可能是一個 Unix domain socket 連線。
內部還常常會存該次連線建立時, db 配給客戶端的 session 資訊。


所以我會說 thread pool 指提早建立好一些 thread, 等到要用的時候, 就不用再重新建立 thread 了

而 connection pool 指提早建立好一些 connection, 等到要用的時候, 就不用再重新建立 connection 了

雙方都有 pool 的概念, 要用取出來, 用完放回去, 但是 pool 的內容物不一樣, 一個是 thread, 一個是 connection

而 connection pool 是 thread pool 嗎? 不一定, 因為其本質就是一個 cache, 不一定要用 TP 實作。

但被 connection pool 連線的 DB 確實常常用 TP 實作, 這樣才易於一次服務多個 client。

