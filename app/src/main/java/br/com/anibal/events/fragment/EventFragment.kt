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
import br.com.anibal.events.database.EventDatabaseService
import br.com.anibal.events.domain.Arguments
import br.com.anibal.events.domain.Event
import br.com.anibal.events.domain.MenuItemString
import br.com.anibal.events.extension.getBrDate
import br.com.anibal.events.web.WebClient
import br.com.anibal.events.extension.toast
import kotlinx.android.synthetic.main.fragment_recycler_view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread

open class EventFragment : BaseFragment() {

    protected var events = listOf<Event>()
    private lateinit var type: MenuItemString

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val argument = arguments?.getSerializable("type")
        if(argument != null)
            this.type = argument as MenuItemString
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_recycler_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        taskEvent()
    }

    open fun taskEvent() {
        WebClient().getEvents({
            this.events = it
            formatDate()
            saveEvents()
            configureAdapter()
        }, {
            toast(getString(R.string.txt_not_connected))
            loadSavedEvents()
        }, type)
    }

    private fun loadSavedEvents() {
        doAsync {
            events = EventDatabaseService.getEvents()

            uiThread {
                configureAdapter()
            }
        }
    }

    private fun formatDate() {
        for(event in this.events) {
            event.startDate = event.startDate.getBrDate()
            event.finishDate = event.finishDate.getBrDate()
        }
    }

    private fun saveEvents() {
        doAsync {
            EventDatabaseService.saveEvents(events)
        }
    }

    private fun configureAdapter() {
        recyclerView.adapter = EventAdapter(events) { onClickEvent(it) }
    }

    open fun onClickEvent(event: Event) {
        Arguments.event = event
        activity?.startActivity<EventDetailActivity>()
    }
}
