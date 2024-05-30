package br.com.apkdoandroid.exemplorxjava.domain.repository

import br.com.apkdoandroid.exemplorxjava.data.dto.ImagemDTO
import br.com.apkdoandroid.exemplorxjava.domain.model.Imagem
import io.reactivex.rxjava3.core.Observable

interface IjsonPlaceHolderRepository {
    fun buscarImagens() : Observable<List<Imagem>>
}