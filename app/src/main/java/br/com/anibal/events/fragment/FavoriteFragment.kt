package br.com.anibal.events.fragment

import br.com.anibal.events.activity.EventDetailActivity
import br.com.anibal.events.adapter.EventAdapter
import br.com.anibal.events.domain.Arguments
import br.com.anibal.events.domain.Event
import br.com.anibal.events.database.DatabaseService
import kotlinx.android.synthetic.main.fragment_recycler_view.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class FavoriteFragment: EventFragment() {

    override fun taskEvent() {
        doAsync {
            events = DatabaseService.getFavoriteEvents()

            uiThread {
                recyclerView.adapter = EventAdapter(events) { onClickEvent(it) }
            }
        }
    }

    override fun onClickEvent(event: Event) {
        Arguments.event = event
        activity?.startActivity<EventDetailActivity>()
    }
}