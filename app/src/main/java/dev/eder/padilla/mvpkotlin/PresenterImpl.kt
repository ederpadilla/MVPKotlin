package dev.eder.padilla.mvpkotlin

import android.text.TextUtils
import dev.eder.padilla.mvpkotlin.api.ServiceGenerator
import dev.eder.padilla.mvpkotlin.api.response.LogInResponse
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class PresenterImpl(internal var mLogInView: LogInView) : LoginPresenter {

    override fun performLogin(mail: String, pass: String) {
        if (TextUtils.isEmpty(mail) || TextUtils.isEmpty(pass)) {
            mLogInView.logInValidation()
        } else {
            val client = ServiceGenerator.getService()
            val scheduler = Schedulers.newThread()
            client.login(mail,pass)
                    .subscribeOn(scheduler)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe ({ loginResponse -> sucessLogin(loginResponse)},{error -> errorLogin(error)})
            //if (mail == "eder@uble.mx" && pass == "12345678") {
            //    mLogInView.loginSuccesss()
            //} else {
            //    mLogInView.loginError()
            //}
        }
    }


    private fun sucessLogin(loginResponse: LogInResponse?) {
        mLogInView.loginSuccesss()
    }

    private fun errorLogin(error: Throwable?) {
        mLogInView.loginError()
    }

}
