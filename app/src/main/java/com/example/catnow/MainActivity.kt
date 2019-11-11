package com.example.catnow

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : Activity(), View.OnClickListener {

    private var images: List<Cat>? = null
    private var currIndex: Int = 0
    override fun onClick(v: View?) {
        if(v!!.id == R.id.button){
            if(currIndex < images!!.size-1)
                currIndex += 1
            else
                currIndex = 0
            Glide
                .with(this)
                .load(images!![currIndex].url)
                .into(imageView)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener(this)
        val gifImageView = findViewById<ImageView>(R.id.imageView)

        val call = RetrofitInitializer().catService().getImage()
        call.enqueue(object: retrofit2.Callback<List<Cat>?> {
            override fun onResponse(call: Call<List<Cat>?>?,
                                    response: Response<List<Cat>?>?) {
                response?.body()?.let{
                    images = it.toList()
                    val cat:Cat = it[currIndex]
                    Glide
                        .with(this@MainActivity)
                        .load(cat.url)
                        .into(gifImageView)
                }
            }

            override fun onFailure(call: Call<List<Cat>?>?,
                                   t: Throwable?) {
            }
        })
    }
}
