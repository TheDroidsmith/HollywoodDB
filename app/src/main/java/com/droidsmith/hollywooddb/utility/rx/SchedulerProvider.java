package com.droidsmith.hollywooddb.utility.rx;


import io.reactivex.Scheduler;

public interface SchedulerProvider {

    Scheduler ui();

    Scheduler io();

    Scheduler computation();

}
