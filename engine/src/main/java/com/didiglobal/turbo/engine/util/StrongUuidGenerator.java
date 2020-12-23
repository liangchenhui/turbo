package com.didiglobal.turbo.engine.util;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;

public final class StrongUuidGenerator implements IdGenerator {

    // different ProcessEngines on the same classloader share one generator.
    private static volatile TimeBasedGenerator timeBasedGenerator;

    public StrongUuidGenerator() {
        initGenerator();
    }

    private void initGenerator() {
        if (timeBasedGenerator == null) {
            synchronized (StrongUuidGenerator.class) {
                if (timeBasedGenerator == null) {
                    timeBasedGenerator = Generators.timeBasedGenerator(EthernetAddress.fromInterface());
                }
            }
        }
    }

    public String getNextId() {
        return timeBasedGenerator.generate().toString();
    }

}