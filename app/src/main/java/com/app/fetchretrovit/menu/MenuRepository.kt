package com.app.fetchretrovit.menu

import androidx.lifecycle.MutableLiveData
import com.app.fetchretrovit.Wrapper
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuRepository(val menuAPI: MenuAPI) {
    var menu: MutableLiveData<Menu> = MutableLiveData<Menu>()
    fun getMenu(id: String) {
        menuAPI.getMenuById(id).enqueue(object : Callback<Wrapper> {
            override fun onFailure(call: Call<Wrapper>, t: Throwable) {
                println(t.localizedMessage)
            }

            override fun onResponse(call: Call<Wrapper>, response: Response<Wrapper>) {
                val response = response.body()
                val gson = Gson()
                val stringResponse = gson.toJson(response?.result)
                val menuObject = gson.fromJson<Menu>(stringResponse,Menu::class.java)
                menu.value = menuObject
            }
        })
    }

    fun saveMenu(menu: Menu){
        menuAPI.createMenu(menu).enqueue(object : Callback<Menu>{
            override fun onFailure(call: Call<Menu>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<Menu>, response: Response<Menu>) {
                if(response.code() == 200){
                    println("SUCCESS")
                }
            }
        })
    }
}