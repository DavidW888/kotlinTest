package com.example.mykotlin.demo5.coroutines1

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.mykotlin.R
import kotlinx.coroutines.*
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class DownloadPicActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download_pic)
        button = findViewById(R.id.upload)
        imageView = findViewById(R.id.downloadUrlimg)
        button.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch{
                val uploadImg =
                    uploadImg("http://pic27.nipic.com/20130329/7226383_172247265181_2.jpg")
                if (uploadImg != null && uploadImg is Bitmap) {
                    imageView.setImageBitmap(uploadImg)

                }
            }
        }


    }

    //2,通过协程下载一张网络图片并显示出来。
    suspend fun uploadImg(url: String): Any? = withContext(Dispatchers.IO) {
        try {
            val imgurl = URL(url)
            val httpsURLConnection: HttpURLConnection = imgurl.openConnection() as HttpURLConnection
            httpsURLConnection.connect()
            val inputStream: InputStream?
            if (httpsURLConnection.getResponseCode() == 200) {
                inputStream = httpsURLConnection.inputStream
                //将输入流转换为bitmap赋值
                val showBitmap = BitmapFactory.decodeStream(inputStream)
                return@withContext showBitmap
            } else {
                return@withContext null
            }
        } catch (e: Exception) {
            e
        }

    }


}





