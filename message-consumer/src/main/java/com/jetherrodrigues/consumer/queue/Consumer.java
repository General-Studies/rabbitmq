package com.jetherrodrigues.consumer.queue;

public interface Consumer<T> {

    void consume(final T t);

}
