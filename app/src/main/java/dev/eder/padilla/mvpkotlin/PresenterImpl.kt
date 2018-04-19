package dev.eder.padilla.mvpkotlin

import android.text.TextUtils

class PresenterImpl(internal var mLogInView: LogInView) : LoginPresenter {

    override fun performLogin(mail: String, pass: String) {
        if (TextUtils.isEmpty(mail) || TextUtils.isEmpty(pass)) {
            mLogInView.logInValidation()
        } else {
            if (mail == "eder@uble.mx" && pass == "12345678") {
                mLogInView.loginSuccesss()
            } else {
                mLogInView.loginError()
            }
        }
    }
}
