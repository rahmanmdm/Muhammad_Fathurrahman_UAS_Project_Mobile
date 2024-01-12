package com.stmik.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), RecyclerViewClickListener {

    private lateinit var rvBooks: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvBooks = findViewById(R.id.rv_books)
        rvBooks.setHasFixedSize(true)

        rvBooks.layoutManager = LinearLayoutManager(this)

        val bookApi = RetrofitHelper.getInstance().create(BookApi::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = bookApi.getBooks()

                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        val listBookAdapter = ListBookAdapter(response.body()!!)
                        rvBooks.adapter = listBookAdapter
                        listBookAdapter.listener = this@MainActivity
                    } else {
                        Toast.makeText(this@MainActivity, "Error ${response.code()}", Toast.LENGTH_LONG).show()
                    }
                }
            } catch (e: HttpException) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@MainActivity, "Error ${e.message()}", Toast.LENGTH_LONG).show()
                }
            } catch (t: Throwable) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@MainActivity, "Terjadi kesalahan jaringan", Toast.LENGTH_LONG).show()
                }
            }
        }



    }


