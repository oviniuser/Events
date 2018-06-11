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
import br.com.anibal.events.adapter.TabsAdapterMain
import br.com.anibal.events.domain.MenuItemString
import br.com.anibal.events.domain.Setting
import br.com.anibal.events.extension.setupToolBar
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolBar(R.id.toolbar)
        setupNavDrawer()

        Setting.server = getString(R.string.server)

        setupViewPagerTabs()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_item_favorites -> {
                toast("Não implementado!")
            }
            R.id.nav_item_settings -> {
                toast("Não implementado!")
            }
            R.id.nav_item_about -> {
                toast("Não implementado!")
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

    private fun setupViewPagerTabs() {
        viewPager.offscreenPageLimit = 2
        viewPager.adapter = TabsAdapterMain(context, supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }
}
