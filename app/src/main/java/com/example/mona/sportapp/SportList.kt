package com.example.mona.sportapp

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class SportList {

    @SerializedName("athletes")
    @Expose
    var sport: ArrayList<Sport>? = null
}