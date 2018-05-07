package br.com.anibal.events.fragment

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.anibal.events.R
import br.com.anibal.events.activity.EventDetailActivity
import br.com.anibal.events.adapter.EventAdapter
import br.com.anibal.events.domain.Event
import br.com.anibal.events.domain.MenuItemString
import br.com.anibal.events.domain.WebClient
import br.com.anibal.events.extension.toast
import kotlinx.android.synthetic.main.fragment_event.*
import org.jetbrains.anko.startActivity


class EventFragment : BaseFragment() {

    private var menuItem = MenuItemString.all_events
    private var events = listOf<Event>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        menuItem = arguments?.getSerializable("menuItem") as MenuItemString
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_event, container, false)
        return view
    }

    override fun onResume() {
        super.onResume()
        WebClient().list({
            this.events = it
            configureAdapter()
        }, {
            toast("Falha ao carregar lista.")
        })
//        configureAdapter()
    }

    fun configureAdapter() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = EventAdapter(events) { onClickEvent(it) }
    }

    private fun onClickEvent(event: Event) {
        activity?.startActivity<EventDetailActivity>("event" to event)
    }
}
