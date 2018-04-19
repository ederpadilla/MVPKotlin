package dev.eder.padilla.mvpkotlin

interface LoginPresenter {
    fun performLogin(mail: String, pass: String)
}
