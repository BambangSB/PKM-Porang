package com.example.pkmporang

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.pkmporang.app.RetrofitClient
import com.example.pkmporang.model.sensor.DataSensor
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun getData() {
        RetrofitClient.getInstance.sensor()
            .enqueue(object : Callback<DataSensor> {
                override fun onResponse(call: Call<DataSensor>, response: Response<DataSensor>) {
                    if (response.isSuccessful) {
//                  Respon atau status jika berhasil mendapatkan data dari server
//                  Code status http 200 - 299

                        Log.d("dataaaaaaa", response.body()!!.toString())

                        berat1.text = response.body()!!.last().berat1.toString()
                        berat2.text = response.body()!!.last().berat2.toString()
                        berat3.text = response.body()!!.last().berat3.toString()
                        berat4.text = response.body()!!.last().berat4.toString()
                        totalBerat.text = response.body()!!.last().totalberat.toString()

                    } else if (response.code() == 401) {
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

                override fun onFailure(call: Call<DataSensor>, t: Throwable) {
                    Toast.makeText(
                        context,
                        "Periksa Koneksi Internet",
                        Toast.LENGTH_LONG
                    ).show()
                }

            })
    }


}