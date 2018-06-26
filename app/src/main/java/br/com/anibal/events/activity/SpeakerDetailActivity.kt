package br.com.anibal.events.activity

import android.os.Bundle
import android.view.View
import br.com.anibal.events.R
import br.com.anibal.events.adapter.TabsAdapterSpeaker
import br.com.anibal.events.domain.Arguments
import br.com.anibal.events.domain.Setting
import br.com.anibal.events.extension.loadUrl
import br.com.anibal.events.extension.setupToolBar
import kotlinx.android.synthetic.main.activity_detail.*

class SpeakerDetailActivity : BaseActivity() {

    private val speaker = Arguments.speaker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setupToolBar(R.id.toolbar, speaker.name, true)
        initViews()
        setupViewPagerTabs()
        fab.visibility = View.INVISIBLE
    }

    private fun initViews() {
        val urlImage = Setting.server + speaker.image
        appBarImage.loadUrl(urlImage)
    }

    private fun setupViewPagerTabs() {
        viewPager.offscreenPageLimit = 1
        viewPager.adapter = TabsAdapterSpeaker(context, supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }
}
