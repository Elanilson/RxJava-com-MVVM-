package br.com.apkdoandroid.exemplorxjava.data.dto

import br.com.apkdoandroid.exemplorxjava.domain.model.Imagem

data class ImagemDTO(
    val  albumId : Long,
    val  id : Long,
    val  title : String,
    val  url : String,
    val  thumbnailUrl : String
)

 fun ImagemDTO.toImagem() : Imagem{
     return Imagem(id = id, url = url, titulo = title)
 }