package br.com.apkdoandroid.exemplorxjava.data.api

import br.com.apkdoandroid.exemplorxjava.data.dto.ImagemDTO
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface JsonplaceholderAPI {
    @GET("photos")
    fun recuperarImagens() : Observable<List<ImagemDTO>>
}