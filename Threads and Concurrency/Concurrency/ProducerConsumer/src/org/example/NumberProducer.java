package org.example;

import org.example.model.Buffer;
import org.example.model.Producer;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;


import java.util.ArrayList;
import java.util.Collection;


public class NumberProducer implements Producer<Integer> {
    private static final Logger logger = LoggerFactory.getLogger(NumberProducer.class);
    private final int end;
    private final Buffer<Integer> buffer;

    public NumberProducer(int end, Buffer<Integer> buffer) {
        this.end = end;
        this.buffer = buffer;
    }

    @Override
    public Collection<Integer> produce() {
        final var produced = new ArrayList<Integer>();

        for (var i = 0; i < end; ++i) {
            final var success = buffer.put(i, 1000);
            if (success) {
                produced.add(i);
            } else {
                logger.error(()->"Buffer is still full after specified timeout");
                break;
            }
        }

        return produced;
    }
}
