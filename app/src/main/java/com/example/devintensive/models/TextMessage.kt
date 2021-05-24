package com.example.devintensive.models

import com.example.devintensive.extentions.humanizeDiff
import java.util.*

class TextMessage (
    id:String,
    from:User?,
    chat:Chat,
    isIncoming:Boolean = false,
    date: Date = Date(),
    var text: String?
) : BaseMessage (id, from, chat, isIncoming, date) {
    override fun formatNessage(): String  = "id$id ${from?.firstName} " +
            "${if(isIncoming) "получил" else "отправил"} сообщение \"$text\"}"
}