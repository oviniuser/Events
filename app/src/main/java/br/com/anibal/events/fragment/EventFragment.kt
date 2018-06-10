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
import br.com.anibal.events.web.WebClient
import br.com.anibal.events.extension.toast
import kotlinx.android.synthetic.main.fragment_recycler_view.*
import org.jetbrains.anko.startActivity


open class EventFragment : BaseFragment() {

    protected var events = listOf<Event>()
    private val type by lazy { arguments?.getSerializable("type") as MenuItemString }

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
            configureAdapter()
        }, {
            toast("Falha ao carregar lista.")
        }, type)
    }

    private fun configureAdapter() {
        recyclerView.adapter = EventAdapter(events) { onClickEvent(it) }
    }

    open fun onClickEvent(event: Event) {
        activity?.startActivity<EventDetailActivity>("event" to event)
    }
}
