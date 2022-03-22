package org.instancio.generators;

import org.instancio.internal.random.RandomProvider;

public class IntegerGenerator extends AbstractGenerator<Integer> {

    private int min = Integer.MIN_VALUE;
    private int max = Integer.MAX_VALUE;

    public IntegerGenerator(final RandomProvider random) {
        super(random);
    }

    public IntegerGenerator min(int min) {
        this.min = min;
        return this;
    }

    public IntegerGenerator max(int max) {
        this.max = max;
        return this;
    }

    @Override
    public Integer generate() {
        return random().intBetween(min, max);
    }
}
