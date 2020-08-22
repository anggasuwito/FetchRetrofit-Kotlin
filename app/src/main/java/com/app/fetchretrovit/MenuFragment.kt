package com.app.fetchretrovit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.app.fetchretrovit.menu.MenuViewModel
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : Fragment(), View.OnClickListener {
    val menuViewModel by activityViewModels<MenuViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        menuViewModel.menu.observe(viewLifecycleOwner, Observer {
            menuNameText.text = it.nama_menu
        })
        getMenu.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            getMenu -> {
                if (menuIdInputText.text.toString() != "") {
                    menuViewModel.getArtist(menuIdInputText.text.toString())
                }else{
                    Toast.makeText(this.context, "Must be Field", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}