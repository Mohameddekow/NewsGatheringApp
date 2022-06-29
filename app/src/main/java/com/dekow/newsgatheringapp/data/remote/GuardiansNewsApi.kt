package com.dekow.newsgatheringapp.data.remote



import android.os.Build
import androidx.annotation.RequiresApi
import com.dekow.newsgatheringapp.commons.usersCurrentDate
import com.dekow.newsgatheringapp.domain.model.data_transfer_obj.details_dto.NewsDetailsResponse
import com.dekow.newsgatheringapp.domain.model.data_transfer_obj.guardian_dto.GuardianMain
import retrofit2.http.GET
import retrofit2.http.Query

interface GuardiansNewsApi {


    //?q=tag=film/film,tone/reviews&from-date=2010-01-01&show-tags=contributor&show-fields=starRating,headline,thumbnail,short-url&order-by=relevance&api-key=05f35298-d1c4-471a-8f7f-cc379945384a

    @GET("/food/2022/jun/21/two-pints-of-lager-and-a-michelin-star-why-gastropubs-are-roaring-back")
    suspend fun newsDetails(
       // @Path("sectionId") sectionId: String
    ): NewsDetailsResponse



    @RequiresApi(Build.VERSION_CODES.O)
    @GET("search")
    suspend fun getNewsOfSpecificSection(
        @Query("section") query: String,
        @Query("page-size") pageSize: String = "20",
        @Query("from-date") fromDate: String = "2014-01-01",
        @Query("to-date") toDate: String? =  usersCurrentDate,//"2022-06-26",
        @Query("order-by") order: String = "newest",
        @Query("use-date") useDate: String = "published",
        @Query("show-tags") tags: String = "contributor",
        @Query("show-fields") fields: String = "all",
        @Query("format") format: String = "json",
    ): GuardianMain



    @RequiresApi(Build.VERSION_CODES.O)
    @GET("search")
    suspend fun getBreakingNews(
        @Query("section") query: String,
        @Query("page-size") pageSize: String = "20",
        @Query("from-date") fromDate: String? = "2022-06-26", // usersCurrentDate,
        @Query("to-date") toDate: String? =  usersCurrentDate,//"2022-06-26",
        @Query("order-by") order: String = "newest",
        @Query("use-date") useDate: String = "published",
        @Query("show-tags") tags: String = "contributor",
        @Query("show-fields") fields: String = "all",
        @Query("format") format: String = "json",
    ): GuardianMain


    @RequiresApi(Build.VERSION_CODES.O)
    @GET("search")
    suspend fun getBreakingNewsList(
        @Query("section") query: String,
        @Query("page-size") pageSize: String = "20",
        @Query("from-date") fromDate: String? =  "2022-01-25",
        @Query("to-date") toDate: String? = usersCurrentDate,
        @Query("order-by") order: String = "relevance",
        @Query("use-date") useDate: String = "published",
        @Query("show-tags") tags: String = "contributor",
        @Query("show-fields") fields: String = "all",
        @Query("format") format: String = "json",
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