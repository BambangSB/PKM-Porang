@file:Suppress("UNREACHABLE_CODE")

package com.example.pkmporang

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.pkmporang.app.RetrofitClient
import com.example.pkmporang.helper.Constant
import com.example.pkmporang.helper.PreferencesHelper
import com.example.pkmporang.model.profil.ProfilResponse
import com.example.pkmporang.model.profil.ProfilResponseItem
import kotlinx.android.synthetic.main.fragment_info.*
import kotlinx.android.synthetic.main.fragment_profil.*
import kotlinx.android.synthetic.main.fragment_profil.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfilFragment : Fragment() {

    lateinit var sharedpref: PreferencesHelper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getdata()
        sharedpref = PreferencesHelper(requireActivity())
        view.submitBtn.setOnClickListener { view ->
            sharedpref.put(Constant.PREF_IS_LOGIN, false)
            val intent = Intent(activity, LoginActivity::class.java)
            activity?.startActivity(intent)
            activity?.finishAffinity()
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false)
//        inflater!!.inflate(R.layout.fragment_third, container, false)
        val view: View = inflater!!.inflate(R.layout.fragment_profil, container, false)
        val btn: Button = view.findViewById(R.id.submitBtn)

//        btn.setOnClickListener {
//            Log.d("btnSetup", "Selected")
//            activity?.let {
//                val intent = Intent(it, MainActivity::class.java)
//                it.startActivity(intent)
//            }
//        }

    }

    private fun getdata(){
        RetrofitClient.getInstance.profil()
            .enqueue(object : Callback<ProfilResponse>{
                override fun onResponse(
                    call: Call<ProfilResponse>,
                    response: Response<ProfilResponse>
                ) {
                    if (response.isSuccessful){
//                  Respon atau status jika berhasil mendapatkan data dari server
//                  Code status http 200 - 299
                        namaUser.text = response.body()!!.last().name
                        emailUser.text = response.body()!!.last().email
                        teleponUser.text = response.body()!!.last().telepon
                        alamatUser.text = response.body()!!.last().alamat
                    }
                    else if (response.code() == 401) {
//                        Respon error ketika gagal login/unauthorized
                        Toast.makeText(
                            context,
                            "Silahkan Login Kembali",
                            Toast.LENGTH_LONG
                        ).show()

                    } else {
//                        Respon Code ketika code 300,400, & 500
                        Toast.makeText(
                            context,
                            "Gagal mendapatkan data",
                            Toast.LENGTH_LONG
                        ).show()

                    }
                }

                override fun onFailure(call: Call<ProfilResponse>, t: Throwable) {
                    Toast.makeText(
                        context,
                        "Periksa Koneksi Internet",
                        Toast.LENGTH_LONG
                    ).show()
                }

            })


    }


}