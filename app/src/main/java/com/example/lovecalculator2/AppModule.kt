package com.example.lovecalculator2

import android.content.Context
import android.content.SharedPreferences
import com.example.lovecalculator2.preferences.Pref
import com.example.lovecalculator2.remote.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.prefs.Preferences


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideApi() : LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }
    @Provides
    fun providePreferences(@ApplicationContext context: Context) : Pref {
        return Pref(context)
    }
}