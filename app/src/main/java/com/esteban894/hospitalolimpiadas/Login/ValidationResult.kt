package com.esteban894.hospitalolimpiadas.Login

sealed class ValidationResult {
    object Success : ValidationResult()
    data class Error(val errorMessage: String) : ValidationResult()
}