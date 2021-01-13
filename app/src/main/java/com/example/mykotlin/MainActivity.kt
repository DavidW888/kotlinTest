package com.example.mykotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}

class MyView : View { constructor(ctx: Context) : super(ctx) constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs) }