package com.example.showmyip

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn=findViewById<Button>(R.id.Button_ScanIP)
        val txtview=findViewById<TextView>(R.id.TextView_IPText)
        btn.setOnClickListener{
            val myApplication=application as MyApplication
            val httpApiService=myApplication.httpApiService
            CoroutineScope(Dispatchers.IO).launch{
                val decodeJsonResult=httpApiService.getMyIp()
                val myactualIp=decodeJsonResult.origin
                withContext(Dispatchers.Main){
                    txtview.text="Your Ip Address =$myactualIp"
                }
            }
        }
    }
}