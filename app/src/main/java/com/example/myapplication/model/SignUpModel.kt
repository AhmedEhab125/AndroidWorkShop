package com.example.myapplication.model


data class SignUpModel(

    var email: String? = null,
    var password: String? = null,
    var displayName: String? = null,
    var returnSecureToken: Boolean? = null

)
data class  RetriveData(   var kind         : String? = null,
                           var idToken      : String? = null,
                           var displayName  : String? = null,
                           var email        : String? = null,
                          var refreshToken : String? = null,
                          var expiresIn    : String? = null,
                          var localId      : String? = null)