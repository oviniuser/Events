package br.com.anibal.events.activity

import android.os.Bundle
import android.util.Log
import br.com.anibal.events.R
import br.com.anibal.events.domain.MenuItemString
import br.com.anibal.events.extension.addFragment
import br.com.anibal.events.extension.setupToolBar
import br.com.anibal.events.fragment.FavoriteFragment

class FavoriteActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        val title = getString(MenuItemString.Favorites.string)
        setupToolBar(R.id.toolbar, title, true)

        if(savedInstanceState == null) {
            addFragment(R.id.container, FavoriteFragment())
        }
    }
}
