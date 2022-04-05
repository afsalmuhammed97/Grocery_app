package com.practies.groceryapp.network.di

import com.practies.groceryapp.network.ApiService
import com.practies.groceryapp.network.helper.Constants.BASE_URL
import com.practies.groceryapp.repository.GroceryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Singleton
    @Provides
    fun provideRetrofitInstanceL():Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit):ApiService=
        retrofit.create(ApiService::class.java)


   // @Singleton
    @Provides
    fun provideRepository(apiService: ApiService)=GroceryRepository(apiService)

}