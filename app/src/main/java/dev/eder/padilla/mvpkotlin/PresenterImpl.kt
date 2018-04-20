package dev.eder.padilla.mvpkotlin

import android.text.TextUtils
import dev.eder.padilla.mvpkotlin.api.ServiceGenerator
import dev.eder.padilla.mvpkotlin.api.response.LogInResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class PresenterImpl(internal var mLogInView: LogInView) : LoginPresenter {

    override fun performLogin(mail: String, pass: String) {
        if (TextUtils.isEmpty(mail) || TextUtils.isEmpty(pass)) {
            mLogInView.logInValidation()
        } else {
            val client = ServiceGenerator.getService()
            client.login(mail,pass)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe (this::sucessLogin,this::errorLogin)
        }
    }


    private fun sucessLogin(loginResponse: LogInResponse?) {
        mLogInView.loginSuccesss()
    }

    private fun errorLogin(error: Throwable?) {
        mLogInView.loginError()
    }

}
