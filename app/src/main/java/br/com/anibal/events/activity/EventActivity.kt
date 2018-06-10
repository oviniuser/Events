package br.com.anibal.events.activity

import android.os.Bundle
import br.com.anibal.events.R
import br.com.anibal.events.domain.MenuItemString
import br.com.anibal.events.extension.addFragment
import br.com.anibal.events.extension.setupToolBar
import br.com.anibal.events.fragment.EventFragment

class EventActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        val menuItem = intent.getSerializableExtra("type") as MenuItemString
        val title = getString(menuItem.string)
        setupToolBar(R.id.toolbar, title, true)

        if(savedInstanceState == null) {
            addFragment(R.id.container, EventFragment())
        }
    }
}
