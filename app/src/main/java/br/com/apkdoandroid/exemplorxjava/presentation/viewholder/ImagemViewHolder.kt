package br.com.apkdoandroid.exemplorxjava.presentation.viewholder

import androidx.recyclerview.widget.RecyclerView
import br.com.apkdoandroid.exemplorxjava.databinding.ItemBinding
import br.com.apkdoandroid.exemplorxjava.domain.model.Imagem
import com.bumptech.glide.Glide

class ImagemViewHolder(private val view : ItemBinding) : RecyclerView.ViewHolder(view.root) {


    fun bind(imagem : Imagem){
        Glide.with(view.root.rootView).load(imagem.url).into(view.imageView);
    }
}