package com.example.pkmporang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pkmporang.helper.PreferencesHelper

class ubahProfil : AppCompatActivity() {
    lateinit var sharedpref: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubah_profil)

    }
}