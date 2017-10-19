package com.droidsmith.hollywooddb;


import com.droidsmith.hollywooddb.utility.rx.SchedulerProvider;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.TestScheduler;

public class TestSchedulerProvider implements SchedulerProvider {

    private final TestScheduler testScheduler;

    public TestSchedulerProvider(TestScheduler testScheduler) {
        this.testScheduler = testScheduler;
    }

    @Override
    public Scheduler ui() {
        return testScheduler;
    }

    @Override
    public Scheduler io() {
        return testScheduler;
    }

    @Override
    public Scheduler computation() {
        return testScheduler;
    }
}
