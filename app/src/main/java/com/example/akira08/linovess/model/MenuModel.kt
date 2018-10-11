package com.example.akira08.linovess.model

class MenuModel(headerText:String, bodyText:MutableList<MutableList<Any>>, drawableName:String){
    var drawableName:String
    var headerText:String
    var bodyText:MutableList<MutableList<Any>>

    init {
        this.drawableName = drawableName
        this.headerText = headerText
        this.bodyText = bodyText
    }
}