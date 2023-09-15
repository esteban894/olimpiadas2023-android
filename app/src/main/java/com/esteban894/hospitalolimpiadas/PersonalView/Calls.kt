package com.esteban894.hospitalolimpiadas.PersonalView

data class Calls(val sector: String, val tipo: TypeCall, var estado: Boolean = false)

enum class TypeCall {
    NORMAL,
    EMERGENCIA
}
