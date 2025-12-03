package org.example;

import org.example.model.Buffer;
import org.example.model.Consumer;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;



public class NumberConsumer implements Consumer<Integer> {
    private static final Logger logger = LoggerFactory.getLogger(NumberConsumer.class);
    private final int end;
    private final Buffer<Integer> buffer;

    public NumberConsumer(int end, Buffer<Integer> buffer) {
        this.end = end;
        this.buffer = buffer;
    }

    @Override
    public Collection<Integer> consume() {
        final var consumed = new ArrayList<Integer>();

        for (var i = 0; i < end; ++i) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            final var element = buffer.get(1000);
            if (Objects.isNull(element)) {
                logger. error(()->"Buffer is still empty after specified timeout");
                break;
            }
            consumed.add(element);
        }

        return consumed;
    }
}
