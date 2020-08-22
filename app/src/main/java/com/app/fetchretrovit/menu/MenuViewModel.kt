package com.app.fetchretrovit.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.app.fetchretrovit.config.RetrofitBuilder

class MenuViewModel : ViewModel() {
    val menuRepository: MenuRepository

    init {
        val menuAPI = RetrofitBuilder.createRetrofit().create(MenuAPI::class.java)
        menuRepository = MenuRepository(menuAPI)
    }

    val menu: LiveData<Menu> = menuRepository.menu

    fun getArtist(id: String) {
        menuRepository.getMenu(id)
    }

    fun saveMenu(menu: Menu){
        menuRepository.saveMenu(menu)
    }
}