package com.example.myapplication.utility

class RegisterValidation {

    fun isEmpty(str:String) : Boolean {
        return str.isEmpty()

    }

    fun isPassMatching(pass: String , confPass: String) : Boolean {
        return pass == confPass
    }

    fun isEmailValid(email: String) : Boolean {
        return email.matches(Constant.emailValidation.toRegex())
    }

}


