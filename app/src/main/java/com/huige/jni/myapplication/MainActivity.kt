package com.huige.jni.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_sumbit.setOnClickListener{
            if(et_scale.text.toString().trim().isNotEmpty()){
                val scale: Float = et_scale.text.toString().toFloat()
                custom.setmScale(scale)
            }
        }
    }
}