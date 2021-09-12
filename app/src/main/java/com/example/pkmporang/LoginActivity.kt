package com.example.pkmporang

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.doOnLayout
import androidx.core.view.doOnNextLayout
import com.example.pkmporang.app.RetrofitClient
import com.example.pkmporang.helper.Constant
import com.example.pkmporang.helper.PreferencesHelper
import com.example.pkmporang.model.LoginResponse
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_profil.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {

    lateinit var sharedpref: PreferencesHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        


        btnLogin.setOnClickListener {
            getData()

        }

        sharedpref = PreferencesHelper(this)

    }

    private fun getData() {
        RetrofitClient.getInstance.login(
            editEmail.text.toString(),
            editPassword.text.toString()


        ).enqueue(object : Callback<LoginResponse> {

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

                Log.i("gagal", "gagal")
                Toast.makeText(this@LoginActivity, "Gagal Masuk", Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                if (response.isSuccessful) {
                    sharedpref.put(Constant.PREF_IS_LOGIN, true)
                    Toast.makeText(this@LoginActivity, "Berhasil Masuk", Toast.LENGTH_SHORT).show()
                    moveIntent()
                    finish()

                } else if (response.code() == 401) {
                    Toast.makeText(
                        this@LoginActivity,
                        "Periksa Kembali Email & Password",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        "Gagal Mengakses Server",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }


        })
    }

    override fun onStart() {
        super.onStart()
        if (sharedpref.getBoolean(Constant.PREF_IS_LOGIN)) {
            moveIntent()
        }
    }

    private fun moveIntent() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}