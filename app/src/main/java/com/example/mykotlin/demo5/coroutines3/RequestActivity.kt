package com.example.mykotlin.demo5.coroutines3

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mykotlin.R
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL

class RequestActivity : AppCompatActivity() {
    private lateinit var progressRootview: ConstraintLayout
    private lateinit var requestButton: Button
    private lateinit var imageview: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request)
        progressRootview = findViewById(R.id.progress_rootview)
        requestButton = findViewById(R.id.requestbutton)
        imageview = findViewById(R.id.imageview)

        requestButton.setOnClickListener() {
            CoroutineScope(Dispatchers.Main).launch {
                progressRootview.visibility = View.VISIBLE
                uploadAndDivideImg("http://pic.51yuansu.com/pic2/cover/00/17/62/579ecc366f3a9_610.jpg")
            }
        }

        /**
         * 使用协程实现一个网络请求：

        等待时显示 Loading；
        请求成功或者出错让 Loading 消失；
        请求失败需要提示用户请求失败了;
        让你的协程写法上看上去像单线程。
         *
         * */


    }

    suspend fun uploadAndDivideImg(imgUrl: String) {
        withContext(Dispatchers.IO) {
            //首先下载一张图片
            val urlRes = URL(imgUrl)
            val httpURLConnection = urlRes.openConnection() as HttpURLConnection
            httpURLConnection.connect()
            val bitmap = BitmapFactory.decodeStream(httpURLConnection.inputStream)
            launch(Dispatchers.Main) {

                if (httpURLConnection.responseCode == 200) {
                    Toast.makeText(baseContext, "请求成功", Toast.LENGTH_SHORT).show()
                    progressRootview.visibility = View.GONE
                    imageview.setImageBitmap(bitmap)
                } else {
                    progressRootview.visibility = View.GONE
                    Toast.makeText(baseContext, "请求失败", Toast.LENGTH_SHORT).show()
                }
            }


        }


    }
}