package com.droidsmith.hollywooddb;

import com.droidsmith.hollywooddb.data.manager.DiskManager;
import com.droidsmith.hollywooddb.data.manager.NetworkManager;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.MovieDetails;
import com.droidsmith.hollywooddb.ui.detail.movie.MovieDetailContract;
import com.droidsmith.hollywooddb.ui.detail.movie.MovieDetailPresenterImpl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.model.Statement;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.TestScheduler;


import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class MovieDetailPresenterTest {

    @Mock
    private MovieDetailContract.MovieDetailView view;

    @Mock
    private NetworkManager networkManager;

    @Mock
    private DiskManager diskManager;

    private TestScheduler testScheduler;

    private MovieDetailContract.MovieDetailPresenter presenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        testScheduler = new TestScheduler();

        when(networkManager.apiMovieDetails(anyInt()))
                .thenReturn(Single.just(new MovieDetails()));

        presenter = new MovieDetailPresenterImpl(
                view, networkManager, diskManager, new TestSchedulerProvider(testScheduler));

    }


    @Test
    public void testIfFetchBasicInfoHandlesCorrectDetails() throws Exception {
        presenter.fetchBasicInfo(anyInt());
        verify(networkManager).apiMovieDetails(anyInt());
        verify(view).setBasicInfo(Mockito.any());
    }







    private static class ImmediateSchedulersRule implements TestRule{

        @Override
        public Statement apply(Statement base, Description description) {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {

                    RxJavaPlugins.setIoSchedulerHandler(scheduler -> Schedulers.trampoline());

                    RxJavaPlugins.setComputationSchedulerHandler(scheduler -> Schedulers.trampoline());

                    RxJavaPlugins.setNewThreadSchedulerHandler(scheduler -> Schedulers.trampoline());

                    try{
                        base.evaluate();
                    } finally {
                        RxJavaPlugins.reset();
                    }
                }
            };
        }
    }



    //TODO: Remove this
    private static final List<String> WORDS = Arrays.asList(
            "the",
            "quick",
            "brown",
            "fox",
            "jumped",
            "over",
            "the",
            "lazy",
            "dog"
    );



//    @Rule //to make sure that the assertions happen after the observable completes
//    public final ImmediateSchedulersRule schedulers = new ImmediateSchedulersRule();


    @Test
    public void practiceRxTest(){

        TestObserver<String> observer = new TestObserver<>();

        Observable<String> observable = Observable.fromIterable(WORDS)
                .zipWith(Observable.range(1, Integer.MAX_VALUE),
                        (string, index) -> String.format("%2d. %s", index, string));


        observable.subscribeOn(Schedulers.trampoline()).subscribe(observer);

        observer.assertComplete();
        observer.assertNoErrors();
        observer.assertValueCount(9);
        assertThat(observer.values(), hasItem(" 4. fox"));





    }


}
