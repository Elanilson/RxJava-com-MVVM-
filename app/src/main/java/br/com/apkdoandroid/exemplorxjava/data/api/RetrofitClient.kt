package br.com.apkdoandroid.exemplorxjava.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory

object RetrofitClient{
    fun recuperarImagemJsonPlace() : JsonplaceholderAPI{
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(JsonplaceholderAPI::class.java)
    }
}