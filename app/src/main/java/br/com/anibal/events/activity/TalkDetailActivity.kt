package br.com.anibal.events.activity

import android.view.View
import br.com.anibal.events.adapter.TabsAdapterTalk
import kotlinx.android.synthetic.main.activity_detail.*

class TalkDetailActivity : EventDetailActivity() {

    override fun setupViewPagerTabs() {
        viewPager.offscreenPageLimit = 1
        viewPager.adapter = TabsAdapterTalk(context, supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun setupFAB() {
        fab.visibility = View.INVISIBLE
    }
}
