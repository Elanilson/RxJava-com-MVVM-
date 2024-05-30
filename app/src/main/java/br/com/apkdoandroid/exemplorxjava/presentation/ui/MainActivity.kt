package br.com.apkdoandroid.exemplorxjava.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.apkdoandroid.exemplorxjava.R
import br.com.apkdoandroid.exemplorxjava.data.api.RetrofitClient
import br.com.apkdoandroid.exemplorxjava.data.repository.JsonPlaceHolderRepositoryImpl
import br.com.apkdoandroid.exemplorxjava.databinding.ActivityMainBinding
import br.com.apkdoandroid.exemplorxjava.domain.usecase.JsonPlaceHolderUseCase
import br.com.apkdoandroid.exemplorxjava.presentation.adapter.ImagemAdapter
import br.com.apkdoandroid.exemplorxjava.presentation.viewmodel.ImagemViewModel
import br.com.apkdoandroid.exemplorxjava.presentation.viewmodel.ViewModelFactory
import io.reactivex.rxjava3.disposables.Disposable

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val jsonplaceholderAPI = RetrofitClient.recuperarImagemJsonPlace()
    private val imagensRepository = JsonPlaceHolderRepositoryImpl(jsonplaceholderAPI)
    private val imagemUseCase = JsonPlaceHolderUseCase(imagensRepository)
    private val viewModelFactory = ViewModelFactory(imagemUseCase)

    private lateinit var viewmodel : ImagemViewModel
    private lateinit var imagensDescartaveis : Disposable
    private val adapter = ImagemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewmodel = ViewModelProvider(this,viewModelFactory).get(ImagemViewModel::class.java)
        recycleviewConfig()
        observers()
    }

    private fun observers() {
        imagensDescartaveis = viewmodel.imagens.subscribe{imagens ->
            Log.e("MainRX", "Total de imagens : ${imagens.size}")
            adapter.attackImagens(imagens)
        }
     /*   viewmodel.mensagem.subscribe{mensagem ->
           Toast.makeText(this,mensagem,Toast.LENGTH_SHORT).show()
        }*/
    }

    fun recycleviewConfig(){
        val gridLayout = GridLayoutManager(this,3,RecyclerView.VERTICAL,false)
        binding.recyclerView.layoutManager = gridLayout
        binding.recyclerView.adapter = adapter
        binding.recyclerView.setHasFixedSize(true)
    }

    override fun onStart() {
        super.onStart()
        viewmodel.buscarImagens()
    }

    override fun onDestroy() {
        super.onDestroy()
        imagensDescartaveis.dispose()
    }
}