package br.com.apkdoandroid.exemplorxjava.data.repository

import br.com.apkdoandroid.exemplorxjava.data.api.JsonplaceholderAPI
import br.com.apkdoandroid.exemplorxjava.data.dto.ImagemDTO
import br.com.apkdoandroid.exemplorxjava.data.dto.toImagem
import br.com.apkdoandroid.exemplorxjava.domain.model.Imagem
import br.com.apkdoandroid.exemplorxjava.domain.repository.IjsonPlaceHolderRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class JsonPlaceHolderRepositoryImpl (private val jsonplaceholderAPI: JsonplaceholderAPI) : IjsonPlaceHolderRepository {

    override fun buscarImagens(): Observable<List<Imagem>> {

       return  jsonplaceholderAPI.recuperarImagens()
           .map {list ->
               list.map { it.toImagem() }
           }
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
    }
}