package com.example.pkmporang.app

import org.json.JSONObject
import retrofit2.Response


public class ErrorUtil {
//    fun parseError(response: Response<*>): ApiError? {
//        var bodyObj: JSONObject? = null
//        var success: Boolean
//        val messages = ArrayList<Any>()
//
//        try {
//            val errorBody: String = response.errorBody().toString()
//            if (errorBody != null) {
//                bodyObj = JSONObject(errorBody)
//                success = bodyObj.getBoolean("success")
//                val errors = bodyObj.getJSONArray("errors")
//                for (i in 0 until errors.length()) {
//                    messages.add(errors[i])
//                }
//            } else {
//                success = false
//                messages.add("Unable to parse error")
//            }
//        } catch (e: Exception) {
//            e.printStackTrace()
//            success = false
//            messages.add("Unable to parse error")
//        }
//        return ApiError.Builder()
//            .success(false)
//            .messages(messages)
//            .build()
//    }
}