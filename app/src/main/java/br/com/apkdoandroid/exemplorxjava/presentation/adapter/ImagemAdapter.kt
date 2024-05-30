package br.com.apkdoandroid.exemplorxjava.presentation.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.apkdoandroid.exemplorxjava.databinding.ItemBinding
import br.com.apkdoandroid.exemplorxjava.domain.model.Imagem
import br.com.apkdoandroid.exemplorxjava.presentation.viewholder.ImagemViewHolder
import br.com.apkdoandroid.exemplorxjava.presentation.viewmodel.ImagemViewModel

class ImagemAdapter : RecyclerView.Adapter<ImagemViewHolder>() {
    private var imagens : List<Imagem> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ImagemViewHolder(ItemBinding.inflate(inflater,parent,false))
    }

    override fun getItemCount(): Int {
        return imagens.size
    }

    override fun onBindViewHolder(holder: ImagemViewHolder, position: Int) {
       holder.bind(imagens[position])
    }

    fun attackImagens(imagens : List<Imagem> ){
        this.imagens = imagens
        notifyDataSetChanged()
    }
}