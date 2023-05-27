package com.example.myapplication.network

import kotlinx.coroutines.flow.Flow

interface NetworkObservation {
    fun observeOnNetwork () : Flow<InternetStatus>



}
enum class InternetStatus {
    Avaliavle , Lost
}