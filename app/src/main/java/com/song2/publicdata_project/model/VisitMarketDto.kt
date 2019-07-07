package com.song2.publicdata_project.model

import java.io.Serializable

class VisitMarketDto : Serializable {
    var date : String = ""
    var marketName : String = ""
    var visitMarketDetailDtos : VisitMarketDtailDto? = null
}