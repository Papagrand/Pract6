package com.example.myapplication.view.fragment

import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.myapplication.R
import com.example.myapplication.data.domain.PhotoDataBase
import com.example.myapplication.data.repository.ImageRepositoryRetrofitImpl
import com.example.myapplication.model.ImageEntity
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

class PhotoFragment : Fragment() {
    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val getButton: Button = view.findViewById(R.id.urdDownloadButton)
        val editText: EditText = view.findViewById(R.id.urlEditText)

        imageView = view.findViewById(R.id.imageFoodView)

        getButton.setOnClickListener {
            val imageUrl = editText.text.toString()
            editText.text.clear()

            // Загружаем изображение и получаем уникальное имя файла
            lifecycleScope.launch {
                    val fileName = downloadImage(imageUrl)
                    if (fileName.isNotEmpty()) {
                        displaySavedImage(imageView, fileName)
                        Toast.makeText(requireContext(), "Изображение получено и сохранено", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(requireContext(), "Не удалось загрузить изображение", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
/*Ссылки на изображения
* https://www.themealdb.com/images/media/meals/xwutvy1511555540.jpg
* https://www.themealdb.com/images/media/meals/1529445434.jpg
* https://www.themealdb.com/images/media/meals/hyarod1565090529.jpg
* */

    private suspend fun downloadImage(imageUrl: String): String {
        return withContext(Dispatchers.IO) {
            val client = OkHttpClient()
            val request = Request.Builder().url(imageUrl).build()

            client.newCall(request).execute().use { response ->
                if (response.isSuccessful) {
                    val fileName = "image_${System.currentTimeMillis()}.jpg"
                    saveImageToDevice(response.body?.byteStream(), fileName)
                    fileName
                } else {
                    ""
                }
            }
        }
    }



    private suspend fun saveImageToDevice(inputStream: InputStream?, fileName: String) {
        withContext(Dispatchers.IO) {
            val directory = File(requireContext().externalMediaDirs.first(), "photo")
            if (!directory.exists()) {
                directory.mkdirs()
            }

            val file = File(directory, fileName)
            val outputStream = FileOutputStream(file)
            inputStream?.copyTo(outputStream)

            outputStream.flush()
            outputStream.close()
        }
    }


    private fun displaySavedImage(imageView: ImageView, fileName: String) {
        val imagePath = File(requireContext().externalMediaDirs.first(), "photo/$fileName")

        Glide.with(this)
            .load(imagePath)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE) // Отключение кеширования на диске
            .placeholder(R.color.teal_700)
            .into(imageView)
    }


}