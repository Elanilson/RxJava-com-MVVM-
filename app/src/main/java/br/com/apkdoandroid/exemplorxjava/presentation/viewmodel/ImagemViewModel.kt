package br.com.apkdoandroid.exemplorxjava.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import br.com.apkdoandroid.exemplorxjava.data.dto.ImagemDTO
import br.com.apkdoandroid.exemplorxjava.domain.model.Imagem
import br.com.apkdoandroid.exemplorxjava.domain.usecase.JsonPlaceHolderUseCase
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subjects.BehaviorSubject

class ImagemViewModel(private val jsonPlaceHolderUseCase: JsonPlaceHolderUseCase) : ViewModel(){

    private val _imagens : BehaviorSubject<List<Imagem>> = BehaviorSubject.create()
    val imagens : Observable<List<Imagem>> get() =  _imagens

    private val _mensagem : BehaviorSubject<String> = BehaviorSubject.create()
    val mensagem : Observable<String> get() =  _mensagem

    private val disposables = CompositeDisposable()



    fun buscarImagens(){

        val response = jsonPlaceHolderUseCase.buscarImagens()
            .subscribe(
                {fotos ->  _imagens.onNext(fotos)},
                {error ->
                    _mensagem.onNext(error.message)
                    Log.e("PhotoViewModel", "imagens Error: ${error.message}")
                }
            )
        disposables.add(response)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}