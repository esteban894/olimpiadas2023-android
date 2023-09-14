package com.esteban894.hospitalolimpiadas.PersonalView

data class Calls(val sector: String, val tipo: TypeCall, val estado: Boolean = false)

enum class TypeCall {
    NORMAL,
    EMERGENCIA
}
