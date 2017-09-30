package com.droidsmith.hollywooddb.injection.module;


import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class RealmManagerModule {

    @Provides
    Realm provideRealm(){
        return Realm.getDefaultInstance();
    }

}
