package com.antonid.nomnom_plus.di.modules;

import android.content.Context;

import com.antonid.nomnom_plus.database.Database;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by antonid on 10.7.16.
 */

@Module
public class DatabaseModule {
    private Context context;

    public DatabaseModule(Context context){
        this.context = context;
    }

    @Provides
    @Singleton
    public Database provideDatabase(){
        return new Database(context);
    }
}
