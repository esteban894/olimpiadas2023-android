package com.esteban894.hospitalolimpiadas.Login.Models

sealed class ValidationResult {
    object Success : ValidationResult()
    data class Error(val errorMessage: String) : ValidationResult()
}