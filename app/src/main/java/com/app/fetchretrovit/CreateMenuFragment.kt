package com.app.fetchretrovit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.app.fetchretrovit.menu.Menu
import com.app.fetchretrovit.menu.MenuViewModel
import kotlinx.android.synthetic.main.fragment_create_menu.*

class CreateMenuFragment : Fragment(), View.OnClickListener {
    val menuViewModel by activityViewModels<MenuViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submitNewMenu.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            submitNewMenu -> {
                val menu = Menu(
                    jenis_menu = jenisMenu.text.toString(),
                    nama_menu = namaMenu.text.toString(),
                    harga_menu = hargaMenu.text.toString(),
                    stok_menu = stokMenu.text.toString()
                )
                if (jenisMenu.text.toString() == "" ||
                    namaMenu.text.toString() == "" ||
                    hargaMenu.text.toString() == "" ||
                    stokMenu.text.toString() == ""
                ) {
                    Toast.makeText(this.context, "Must be Field", Toast.LENGTH_SHORT).show()
                } else {
                    menuViewModel.saveMenu(menu)
                }
            }
        }
    }
}