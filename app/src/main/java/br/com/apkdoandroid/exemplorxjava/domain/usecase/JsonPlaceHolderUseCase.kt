package br.com.apkdoandroid.exemplorxjava.domain.usecase

import android.util.Log
import br.com.apkdoandroid.exemplorxjava.data.dto.ImagemDTO
import br.com.apkdoandroid.exemplorxjava.domain.model.Imagem
import br.com.apkdoandroid.exemplorxjava.domain.repository.IjsonPlaceHolderRepository
import io.reactivex.rxjava3.core.Observable

class JsonPlaceHolderUseCase (private val repository: IjsonPlaceHolderRepository){

    fun buscarImagens() : Observable<List<Imagem>> {
        return  repository.buscarImagens()
            .doOnError { error ->
                // Tratamento de erro, se necessário
                Log.e("GetPhotosUseCase", "Error : ${error.message}")
            }
    }
}