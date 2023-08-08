package com.hiringandtracking.config;

import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;



//@Slf4j
public class ExceptionSkipPolicy implements SkipPolicy {
    @Override
    public boolean shouldSkip(Throwable throwable, long l) throws SkipLimitExceededException {
        return (throwable instanceof NumberFormatException);
    }
}