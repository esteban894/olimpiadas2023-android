package com.esteban894.hospitalolimpiadas.Login.Models

data class UserDto(var name: String, var password: String)

data class UserDtoResponse(
    val apellido: String?,
    val createdAt: String?,
    val direccion: String?,
    val dni: Int?,
    val genero: String?,
    val id: Int?,
    val name: String?,
    val password: String?,
    val updatedAt: String?,
)


data class UserSuccess(
    val apellido: String,
    val createdAt: String,
    val direccion: String,
    val dni: Int,
    val genero: String,
    val id: Int,
    val name: String,
    val password: String,
    val updatedAt: String
)

data class UserError(val message: String)
