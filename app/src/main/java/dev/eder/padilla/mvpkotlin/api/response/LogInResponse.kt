package dev.eder.padilla.mvpkotlin.api.response

data class LogInResponse(var success: Int?,

                         var message: String?,

                         var userInfo: UserInfo?,

                         var zones: List<Zone>?)