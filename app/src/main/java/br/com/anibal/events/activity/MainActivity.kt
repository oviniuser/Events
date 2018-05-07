package br.com.anibal.events.activity

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import org.jetbrains.anko.startActivity
import br.com.anibal.events.R
import br.com.anibal.events.domain.MenuItemString
import br.com.anibal.events.extension.setupToolBar
import org.jetbrains.anko.toast

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolBar(R.id.toolbar)
        setupNavDrawer()

//        if(savedInstanceState == null) {
//            addFragment(R.id.container, NewsFragment())
//        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_item_all_events -> {
                startActivity<EventActivity>("menuItem" to MenuItemString.all_events)
            }
            R.id.nav_item_subscribed_events -> {
                startActivity<EventActivity>("menuItem" to MenuItemString.subscribed_events)
            }
            R.id.nav_item_app_login -> {
                startActivity<LoginActivity>()
            }
            R.id.nav_item_app_settings -> {
                toast("Não implementado!")
            }
            R.id.nav_item_app_about -> {
                startActivity<SiteAppActivity>()
            }
        }
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    private fun setupNavDrawer() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }
}
