package smu.app.bookreviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import smu.app.bookreviewapp.api.BookService
import smu.app.bookreviewapp.model.BestSellerDto

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://book.interpark.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val bookService = retrofit.create(BookService::class.java)

        bookService.getBestSellerBooks("3BE722C7A0D443F586E855A5F514D3C0E439937BF7064D2E77B77D0E3FAB104A")
            .enqueue(object: Callback<BestSellerDto>{
                override fun onResponse(
                    call: Call<BestSellerDto>,
                    response: Response<BestSellerDto>
                ) {
                    if(response.isSuccessful.not()){
                        //예외처리
                        Log.d(TAG,"NOT SUCCESS")
                        return
                    }

                    response.body()?.let{
                        Log.d(TAG,it.toString())

                        it.books.forEach { book-> //위에도 it이 있으니 헷갈리니까 변수 명명
                           Log.d(TAG,book.toString())
                        }
                    }
                }

                override fun onFailure(call: Call<BestSellerDto>, t: Throwable) {
                    Log.e(TAG,t.toString())
                }

            })
    }

    companion object{
        private const val TAG = "MainActivity"
    }
}