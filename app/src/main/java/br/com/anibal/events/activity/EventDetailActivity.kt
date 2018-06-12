package br.com.anibal.events.activity

import android.os.Bundle
import br.com.anibal.events.R
import br.com.anibal.events.adapter.TabsAdapterEvent
import br.com.anibal.events.domain.Arguments
import br.com.anibal.events.domain.Setting
import br.com.anibal.events.extension.loadUrl
import br.com.anibal.events.extension.setupToolBar
import kotlinx.android.synthetic.main.activity_detail.*

open class EventDetailActivity : BaseActivity() {

    protected val event by lazy { Arguments.event }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setupToolBar(R.id.toolbar, event.name, true)
        initViews()
        setupViewPagerTabs()
    }

    private fun initViews() {
        val urlImage = Setting.server + event.image
        appBarImage.loadUrl(urlImage)
    }

    open fun setupViewPagerTabs() {
        viewPager.offscreenPageLimit = 2
        viewPager.adapter = TabsAdapterEvent(context, supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }
}
