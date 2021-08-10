package ru.skillbranch.devintensive.utils

object Utils {
    fun ParceFullName(fullName: String?) : Pair<String?, String?> {
        val parts : List<String>? = fullName?.split(" ")

        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)
        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        TODO("Not yet implemented")
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        TODO("Not yet implemented")
    }
}