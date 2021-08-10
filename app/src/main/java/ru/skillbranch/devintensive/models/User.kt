package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User (
        val id:String,
        var firstName:String?,
        var lastName:String?,
        var avatar:String?,
        var raiting:Int = 0,
        var respect:Int = 0,
        val isOnline:Boolean = false,
        val lastVisit:Date? = Date()
)   {
        constructor(id:String, firstName:String?, lastName:String?) : this(
            id = id,
            firstName = firstName,
            lastName = lastName,
            avatar = null
        )

        constructor(id:String) : this(id, "John", "Doe")

    init {
        println("It's Alive!!! \n" +
                "${if (lastName=="Doe") "His name is $firstName $lastName" else "And his name is $firstName $lastName"}\n")
    }

    companion object Factory {
        private var lastId = -1
        fun makeUser(fullName:String?) : User {
            lastId++

            val (firstName, lastName) = Utils.ParceFullName(fullName)

            return User(id = "$lastId", firstName = firstName, lastName = lastName)
        }
    }

//    private fun getIntro() = """
//        tu tu ru!!!
//        tutututu! tutututututut tu tu tu tu tuuuuu!!!. . .
//
//        tu tu ru!!!
//        tutututu! tutututututut tu tu tu tu tuuuuu!!!. . .
//        ${"\n\n\n"}
//        $firstName $lastName
//    """.trimIndent()
//
//    fun printMe():Unit{
//        println("""
//           id: $id
//           firstName: $firstName
//           lastName: $lastName
//           avatar: $avatar
//           raiting: $raiting
//           respect: $respect
//           isOnline: $isOnline
//           lastVisit: $lastVisit
//        """.trimIndent())
//    }
}