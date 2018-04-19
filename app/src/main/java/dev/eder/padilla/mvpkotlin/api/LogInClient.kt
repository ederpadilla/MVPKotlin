package dev.eder.padilla.mvpkotlin.api

import dev.eder.padilla.mvpkotlin.api.response.LogInResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import rx.Observable

interface LogInClient {
    @FormUrlEncoded
    @POST("login.php")
    abstract fun login(@Field("email") email: String, @Field("password") password: String): Observable<LogInResponse>
}