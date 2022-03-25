package smu.app.bookreviewapp.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import smu.app.bookreviewapp.model.BestSellerDto
import smu.app.bookreviewapp.model.SearchBookDto

interface BookService {
    // BookAPI
    @GET("/api/search.api?output=json")
    fun getBooksByName(
        @Query("key") apiKey:String,
        @Query("query") keyword:String
    ): Call<SearchBookDto>

    @GET("/api/bestSeller.api?categoryId=100&output=json")
    fun getBestSellerBooks(
        @Query("key") apiKey:String
    ): Call<BestSellerDto>
}