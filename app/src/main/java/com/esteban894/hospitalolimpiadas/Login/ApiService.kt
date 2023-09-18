package com.esteban894.hospitalolimpiadas.Login

import com.esteban894.hospitalolimpiadas.Login.Models.UserDto
import com.esteban894.hospitalolimpiadas.Login.Models.UserDtoResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("users")
    suspend fun login(@Body user: UserDto): Response<UserDtoResponse>
}
