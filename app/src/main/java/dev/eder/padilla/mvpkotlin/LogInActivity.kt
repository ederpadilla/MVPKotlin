package dev.eder.padilla.mvpkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_log_in.*

class LogInActivity : AppCompatActivity() , LogInView{

    internal var lmLoginPresenter: LoginPresenter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        lmLoginPresenter = PresenterImpl(this@LogInActivity)
    }

    fun login(view : View) {
        val email = mEtMail.getText().toString()
        val pass = mEtPass.getText().toString()
        lmLoginPresenter!!.performLogin(email, pass)
    }

    override fun logInValidation() {
        Toast.makeText(applicationContext, "campos vacios 👹", Toast.LENGTH_SHORT).show()
    }

    override fun loginSuccesss() {
        Toast.makeText(applicationContext, "🌮 SucessLogin 🌮", Toast.LENGTH_SHORT).show()
    }

    override fun loginError() {
        Toast.makeText(applicationContext, "Wrong mail or pass 😬 ", Toast.LENGTH_SHORT).show()
    }}
