package com.example.exercise_room_coroutines.di

import com.example.exercise_room_coroutines.service.MakeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://makeup-api.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideMakeApi(retrofit: Retrofit): MakeApi =
        retrofit.create(MakeApi::class.java)

}