package com.example.perhitungan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recylerAdapter : RecyclerView.Adapter<*>
    private lateinit var layoutManager: LinearLayoutManager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val kosong1 = findViewById<EditText>(R.id.edit_panjang)
        val kosong2 = findViewById<EditText>(R.id.edit_Lebar)
        val hitung = findViewById<Button>(R.id.btn_hitung)

        val data = ArrayList<dataprhtngan>()
        recyclerView = findViewById(R.id.recyclerView)

        hitung.setOnClickListener {
            val panjang = kosong1.text.toString().toInt()
            val lebar = kosong2.text.toString().toInt()

            if (panjang != null){
                val hitungluas = panjang * lebar
                hitungluas.toString()

                val menampilkan = dataprhtngan(hitungluas)
                data.add(menampilkan)
                recylerAdapter.notifyDataSetChanged()

            }else if (lebar != null){
               val  hitungluas = (panjang * 2) + (lebar * 2)
                hitungluas.toString()

                val menampilkan = dataprhtngan(hitungluas)
                data.add(menampilkan)
                recylerAdapter.notifyDataSetChanged()
            }
        }
        recylerAdapter = Adapter(data)
        layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = recylerAdapter
        recyclerView.layoutManager = layoutManager
    }
}