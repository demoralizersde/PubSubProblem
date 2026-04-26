# 📦 Producer-Consumer (Pub-Sub) System using Spring Boot

## 🚀 Overview
This project demonstrates the **Producer-Consumer (Pub-Sub)** problem using **Java, Spring Boot, and Multithreading**.

- A REST API accepts a list of items.
- A **Producer thread** adds items to a shared queue.
- A **Consumer thread** continuously consumes items from the queue.
- Synchronization is handled using `wait()` and `notifyAll()`.

---

## 🧠 Concept
The Producer-Consumer problem is a classic concurrency problem where:
- Producers generate data and add it to a shared buffer.
- Consumers remove data from the buffer.
- The buffer has limited capacity, so:
  - Producer waits if buffer is full.
  - Consumer waits if buffer is empty.

---


### Components

#### 1. Controller (`PubSubController`)
- Endpoint: `POST /v1/produce`
- Accepts a list of strings (max size = 10)
- Calls service to start producer

#### 2. Service (`PCService`)
- Starts **Consumer thread** at application startup
- Creates **Producer thread** per API request

#### 3. Shared Resource (`SharedResource`)
- Uses `Queue<String>` with capacity = 5
- Provides synchronized methods:
  - `produceItem()`
  - `consumeItem()`

#### 4. Producer Thread
- Iterates over input list
- Adds items to queue
- Waits if queue is full

#### 5. Consumer Thread
- Runs continuously (`while(true)`)
- Consumes items from queue
- Waits if queue is empty

---

## 🔄 Flow
1. Client calls API with list of items
2. Producer thread starts
3. Items are pushed into queue
4. Consumer thread consumes items and prints them

---

## 🔐 Synchronization Logic

### Producer
```java
while (queue.size() == capacity) {
    wait();
}
queue.add(item);
notifyAll();
```
### Producer
```java
while (queue.isEmpty()) {
    wait();
}
queue.poll();
notifyAll();
```

## ❗ Important Points

* `while` is used instead of `if` to handle **spurious wakeups**
* `notifyAll()` wakes up all waiting threads
* `Thread.sleep(200)` simulates processing delay
* Consumer runs infinitely to mimic real-time systems

---

## 📡 API Usage

### Endpoint

```
POST /v1/produce
```

### Sample Request

```json
[1,2,3,4,5,6,7,8,9]
```

### Response

```
Done Successfully
```

---

## 🧪 Sample Output (Console) (This may differ)

------AS THE APPLICATION STARTS--------
```
Consumer Thread Started Successfully
Consumer Thread is Waiting
```
------AFTER CALLING THE PRODUCE API-------
```
Producer Thread Started Successfully
1
2
Producer Thread is Waiting because queue size is full
3
```

---

## ⚠️ Limitations

* Uses in-memory queue (no persistence)
* Creates new thread per request
* No thread pool or scaling mechanism
* Basic error handling

---

## 🚀 Future Improvements

* Use `BlockingQueue` (ArrayBlockingQueue)
* Replace Threads with `ExecutorService`
* Add logging and monitoring
* Integrate Kafka or RabbitMQ
* Graceful shutdown handling

---

## 🛠 Tech Stack

* Java 21
* Spring Boot
* Multithreading (Thread, Runnable)
* REST API

---

## 💡 Learning Outcomes

* Thread synchronization using `synchronized`
* Inter-thread communication using `wait()` & `notifyAll()`
* Handling race conditions
* Designing producer-consumer systems

```
```
