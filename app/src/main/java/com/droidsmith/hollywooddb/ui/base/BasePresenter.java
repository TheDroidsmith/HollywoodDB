package com.droidsmith.hollywooddb.ui.base;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<V> {

    protected final V view;

    private CompositeDisposable disposables = new CompositeDisposable();

    protected BasePresenter(V view) {
        this.view = view;
    }


    public void start() {
    }


    public void stop() {
        disposables.dispose();
    }

    protected void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }

}
