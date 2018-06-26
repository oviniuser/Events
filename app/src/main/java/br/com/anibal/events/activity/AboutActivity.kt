package br.com.anibal.events.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.anibal.events.R
import br.com.anibal.events.domain.MenuItemString
import br.com.anibal.events.extension.setupToolBar

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val title = getString(MenuItemString.About.string)
        setupToolBar(R.id.toolbar, title, true)
    }
}
