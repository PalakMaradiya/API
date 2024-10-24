package com.example.api.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.api.R
import com.example.api.adapter.ApiAdapter
import com.example.api.databinding.ActivityMainBinding
import com.example.api.`interface`.Intreface
import com.example.api.`object`.RetrofitClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        initView()
    }

    private fun initView() {
        binding.btn.setOnClickListener {


            val api = RetrofitClient.getInstance().create(Intreface::class.java)
            GlobalScope.launch {

                val result = api.getProduct()

                if (result != null) {
                    Log.e("TAG", "initview data: " + result)

                }

                runOnUiThread {

                    var adapter = ApiAdapter(this@MainActivity, result)
                    var manager =
                        LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
                    binding.rcv.adapter = adapter
                    binding.rcv.layoutManager = manager


                }
            }
        }
    }
}

