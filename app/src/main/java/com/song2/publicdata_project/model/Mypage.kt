package com.song2.publicdata_project.model

import java.io.Serializable

class Mypage: Serializable {

    var name : String = ""
    var point : Int = 0
    var visitMarketDtos : ArrayList<VisitMarketDto>? = null
}