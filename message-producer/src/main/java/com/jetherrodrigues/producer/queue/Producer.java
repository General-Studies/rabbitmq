package com.jetherrodrigues.producer.queue;

public interface Producer<T> {
    void send(final T t);
}
