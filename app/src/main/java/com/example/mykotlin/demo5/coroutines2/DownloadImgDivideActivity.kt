package com.example.mykotlin.demo5.coroutines2

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.mykotlin.R
import kotlinx.coroutines.*
import java.io.File
import java.io.FileOutputStream
import java.io.RandomAccessFile
import java.net.HttpURLConnection
import java.net.URL

class DownloadImgDivideActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var imageview: ImageView
    private lateinit var imageview4: ImageView
    private lateinit var imageview9: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download_img_divide)

        button = findViewById(R.id.upload)
        imageview = findViewById(R.id.downloadlimg)
        imageview4 = findViewById(R.id.download4Urlimg)
        imageview9 = findViewById(R.id.download9Urlimg)

        button.setOnClickListener() {
            CoroutineScope(Dispatchers.Main).launch {
                val bitmapList = uploadAndDivideImg("http://pic.51yuansu.com/pic2/cover/00/17/62/579ecc366f3a9_610.jpg")
                for (index in bitmapList.indices) {
                    imageview.setImageBitmap(bitmapList.get(0))
                    imageview4.setImageBitmap(bitmapList.get(1))
                    imageview9.setImageBitmap(bitmapList.get(2))

                }
            }
        }


    }

    suspend fun uploadAndDivideImg(imgUrl: String): List<Bitmap> {
        return withContext(Dispatchers.IO) {
            //首先下载一张图片
            val urlRes = URL(imgUrl)
            val httpURLConnection = urlRes.openConnection() as HttpURLConnection
            httpURLConnection.connect()
            val bitmap = BitmapFactory.decodeStream(httpURLConnection.inputStream)
            //读取图片的长度  并行进行两次切割
            //一次切成大小相同的 4 份，取其中的第一份
            val bitmapWitdh = bitmap.width
            val bitmapHeight = bitmap.height
            val divide4Task = async {
                val divide4Bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmapWitdh / 2, bitmapHeight / 2);
                divide4Bitmap
            }

            //一次切成大小相同的 9 份，取其中的最后一份
            val divide9Task = async {
                for (i in 0..2) {
                    for (j in 0..2) {
                        if (i == 2 && j == 2) {
                            val divide9Bitmap = Bitmap.createBitmap(bitmap, bitmapWitdh * 2 / 3, bitmapHeight * 2 / 3, bitmapWitdh / 3, bitmapHeight / 3);
                            return@async divide9Bitmap
                        }

                    }
                }
            }


            val bitmapList = listOf<Bitmap>(bitmap, divide4Task.await(), divide9Task.await() as Bitmap)

            bitmapList
        }


    }

}