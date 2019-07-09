package com.song2.publicdata_project.model.Mypage


data class VisitMarketDto (
    var date : String ,
    var marketName : String,
    var visitMarketDetailDtos : VisitMarketDtailDto
)