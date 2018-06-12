package br.com.anibal.events.activity

import br.com.anibal.events.adapter.TabsAdapterTalk
import kotlinx.android.synthetic.main.activity_detail.*

class TalkDetailActivity : EventDetailActivity() {

    override fun setupViewPagerTabs() {
        viewPager.offscreenPageLimit = 1
        viewPager.adapter = TabsAdapterTalk(context, supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }
}
