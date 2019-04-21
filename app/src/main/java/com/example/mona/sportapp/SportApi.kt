package com.example.mona.sportapp

import retrofit2.Call
import retrofit2.http.GET

interface SportApi {

    @GET("MohamedWael/1406437f14e9a769a3a572a78906388f/raw/5be50e67c96c5ed1da9fe6344d2dd7befef0ba25/?fbclid=IwAR15mW67urFuId4M1k_JKEJlAD74LOJlc2q3B1K20-jDvkclByn9JuJUgM0")
    fun getMyJSON(): Call<Sport>
}