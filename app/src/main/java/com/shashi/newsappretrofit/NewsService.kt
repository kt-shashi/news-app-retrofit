package com.shashi.newsappretrofit

import com.shashi.newsappretrofit.model.NewsModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://gnews.io/api/v4/top-headlines?lang=en&country=in&topic=breaking-news&token=ef098601144aaa99d14f8cd6d85eb7d8

const val BASE_URL = "https://gnews.io/api/v4/"
const val API_KEY = "ef098601144aaa99d14f8cd6d85eb7d8"

interface NewsInterface {

    @GET("top-headlines?token=$API_KEY")
    fun getBreakingNews(
        @Query("lang") lang: String,
        @Query("country") country: String,
        @Query("topic") topic: String,
        @Query("page") page: Int
    ): Call<NewsModel>

}

//Retrofit object
object NewsService {
    val newsInterface: NewsInterface

    init {
        val retrofit = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        newsInterface = retrofit.create(NewsInterface::class.java)
    }
}