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
import kotlinx.android.synthetic.main.fragment_info.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class InfoFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }


    private fun getData() {
        RetrofitClient.getInstance.sensor()
            .enqueue(object : Callback<DataSensor> {
                override fun onResponse(call: Call<DataSensor>, response: Response<DataSensor>) {
                    if (response.isSuccessful) {
                        Log.d("dataaaaaaa", response.body()!!.toString())

                        textStatus.text = response.body()!!.last().kondisi

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