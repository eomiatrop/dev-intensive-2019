package ru.skillbranch.devintensive.models

class Bender(var status: Status = Status.NORMAL, var question: Question = Question.NAME) {

    fun askQuestion(): String = when (question) {
        Question.NAME -> Question.NAME.question
        Question.PROFESSION -> Question.PROFESSION.question
        Question.MATERIAL -> Question.MATERIAL.question
        Question.BDAY -> Question.BDAY.question
        Question.SERIAL -> Question.SERIAL.question
        Question.IDOL -> Question.IDOL.question
    }

    fun listenAnswer(answer:String) : Pair<String, Triple<Int, Int, Int>> {
        return if (question.answers.contains(answer)) {
            question = question.nextQuestion()
            "Отлично - это правильный ответ!\n\n${question.question}" to status.color
        } else {
            status = status.nextStatus()
            "Это не правильный ответ!\n\n${question.question}" to status.color
        }
    }

    enum class Status(val color: Triple <Int, Int, Int>) {
        NORMAL (Triple(255, 255, 255)),
        WARNING (Triple(255, 120, 0)),
        DANGER (Triple(255, 60, 60)),
        CRITICAL (Triple(255, 255, 0));


        fun nextStatus(): Status {
            return if(this.ordinal< values().lastIndex) {
                values()[this.ordinal +1]
            } else {
                values()[0]
            }
        }
    }

    enum class Question(val question: String, val answers: List<String>) {
        NAME(question = "Как меня зовут?", listOf("бендер", "bender")) {
            override fun nextQuestion(): Question = PROFESSION
        },
        PROFESSION(question = "Назови мою профессию?", listOf("сгибальщик", "bender")) {
            override fun nextQuestion(): Question = MATERIAL
        },
        MATERIAL(question = "Из чего я сделан?", listOf("металл", "дерево", "iron", "metall", "wood")) {
            override fun nextQuestion(): Question = BDAY
        },
        BDAY(question = "Когда меня создали?", listOf("2993")) {
            override fun nextQuestion(): Question = SERIAL
        },
        SERIAL(question = "Мой серийный номер?", listOf("2716057")) {
            override fun nextQuestion(): Question = IDOL
        },
        IDOL(question = "На этом все, вопросов больше нет?", listOf()) {
            override fun nextQuestion(): Question = IDOL
        };

        abstract fun nextQuestion() : Question
    }
}