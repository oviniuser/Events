package br.com.anibal.events.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.com.anibal.events.R
import br.com.anibal.events.extension.setupToolBar

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val title = "Login"
        setupToolBar(R.id.toolbar, title, true)

        val button = findViewById<Button>(R.id.buttonLogin)
        button.setOnClickListener { login() }
    }

    fun login() {
        val editText = findViewById<EditText>(R.id.editTextUserName)
        val passwordText = findViewById<EditText>(R.id.editTextUserPassword)
        val userName = editText.text
        val userPassword = passwordText.text

//        autenticar

//        val menuItem = findViewById<MenuItem>(R.id.nav_item_app_login)
//        val textView = findViewById<TextView>(R.id.textViewUserName)
//        textView.text = userName
    }
}
