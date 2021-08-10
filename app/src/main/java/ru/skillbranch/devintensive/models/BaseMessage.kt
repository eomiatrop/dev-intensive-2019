package ru.skillbranch.devintensive.models

import java.util.*

abstract class BaseMessage (
    val id:String,
    val from: User?,
    val chat: Chat,
    val isIncoming:Boolean = false,
    val date: Date = Date()
) {

     abstract fun formatNessage() : String
     companion object AbstractFactory {
         var lastId = -1
         fun makeMessage(from: User?, chat: Chat, Date: Date = Date(), type:String = "text", payload:Any?): BaseMessage {
             lastId++
             return when (type) {
                "image" -> ImageMessage("$lastId", from, date = Date(), image = payload as String, chat = Chat("01"))
                    else -> TextMessage("$lastId", from, date = Date(), text = payload as String, chat = Chat("01"))
             }
         }
     }
}