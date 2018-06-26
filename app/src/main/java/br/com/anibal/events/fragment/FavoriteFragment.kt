package br.com.anibal.events.fragment

import android.util.Log
import br.com.anibal.events.activity.EventDetailActivity
import br.com.anibal.events.adapter.EventAdapter
import br.com.anibal.events.domain.Arguments
import br.com.anibal.events.domain.Event
import br.com.anibal.events.domain.FavoriteService
import kotlinx.android.synthetic.main.fragment_recycler_view.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class FavoriteFragment: EventFragment() {

    override fun taskEvent() {
        doAsync {
            events = FavoriteService.getEvents()

            uiThread {
                Log.d("XAXO", events.size.toString())
                recyclerView.adapter = EventAdapter(events) { onClickEvent(it) }
            }
        }
    }

    override fun onClickEvent(event: Event) {
        Arguments.event = event
        activity?.startActivity<EventDetailActivity>()
    }
}