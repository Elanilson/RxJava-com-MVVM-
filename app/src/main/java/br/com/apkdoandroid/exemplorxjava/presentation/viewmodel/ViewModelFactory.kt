package br.com.apkdoandroid.exemplorxjava.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.apkdoandroid.exemplorxjava.domain.usecase.JsonPlaceHolderUseCase

class ViewModelFactory(private val imagemUseCase: JsonPlaceHolderUseCase) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ImagemViewModel::class.java)){
            return ImagemViewModel(imagemUseCase) as T
        }
        throw IllegalArgumentException("class ViewModel desconhecida")
    }
}