package com.dekow.newsgatheringapp.data.remote



import com.dekow.newsgatheringapp.domain.model.data_transfer_obj.test.GuardianMain
import retrofit2.http.GET
import retrofit2.http.Query


interface GuardiansNewsApi {


    //?q=tag=film/film,tone/reviews&from-date=2010-01-01&show-tags=contributor&show-fields=starRating,headline,thumbnail,short-url&order-by=relevance&api-key=05f35298-d1c4-471a-8f7f-cc379945384a

    @GET("search")
    suspend fun searchNews(
        @Query("section") query: String? = "food",
        @Query("page-size") pageSize: String = "30",
        @Query("from-date") fromDate: String = "2014-01-01",
        @Query("to-date") toDate: String = "2022-01-06",
        @Query("order-by") order: String = "newest",
        @Query("use-date") useDate: String = "published",
        @Query("show-tags") tags: String = "contributor",
        @Query("show-fields") fields: String = "all",
        @Query("format") format: String = "json",
       // @Query("api-key") apiKey: String = "05f35298-d1c4-471a-8f7f-cc379945384a"

    ): GuardianMain


    @GET("search")
    suspend fun searchNewsT(
        @Query("section") query: String? = "food",
        @Query("from-date") fromDate: String = "2014-01-01",
        @Query("to-date") toDate: String = "2022-01-01",
        @Query("order-by") order: String = "newest",
        @Query("use-date") useDate: String = "published",
        @Query("show-tags") tags: String = "contributor",
        @Query("show-fields") fields: String = "all",
        @Query("format") format: String = "json",
        @Query("api-key") apiKey: String = "05f35298-d1c4-471a-8f7f-cc379945384a"
//        @Query("section") category: String? =  "food",
//        @Query("page-size") pageSize: String = "20",
//        @Query("show-fields") fields: String = "all",
//        @Query("format") format: String = "json",
//        @Query("api-key") apiKey: String = "05f35298-d1c4-471a-8f7f-cc379945384a"
    ): GuardianMain
}