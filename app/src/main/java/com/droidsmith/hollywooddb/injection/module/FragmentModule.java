package com.droidsmith.hollywooddb.injection.module;

import android.support.v4.app.Fragment;

        import com.droidsmith.hollywooddb.injection.component.HomeFragmentComponent;
        import com.droidsmith.hollywooddb.ui.home.fragments.home.HomeFragment;

        import dagger.Binds;
        import dagger.Module;
        import dagger.android.AndroidInjector;
        import dagger.android.support.FragmentKey;
        import dagger.multibindings.IntoMap;

//module for AppComponent
@Module
public abstract class FragmentModule {
    @Binds
    @IntoMap
    @FragmentKey(HomeFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> provideHomeFragmentFactory(HomeFragmentComponent.Builder builder);
}
