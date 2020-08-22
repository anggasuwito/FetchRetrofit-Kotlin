package com.app.fetchretrovit.menu

import com.app.fetchretrovit.Wrapper
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MenuAPI {
    @GET("menu/{id}")
    fun getMenuById(@Path("id")id:String): Call<Wrapper>

    @POST("menu")
    fun createMenu(@Body menu: Menu):Call<Menu>
}