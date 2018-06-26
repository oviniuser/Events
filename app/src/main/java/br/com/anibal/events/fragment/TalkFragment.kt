package br.com.anibal.events.fragment

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.anibal.events.R
import br.com.anibal.events.R.id.recyclerView
import br.com.anibal.events.activity.TalkDetailActivity
import br.com.anibal.events.adapter.TalkAdapter
import br.com.anibal.events.database.TalkDatabaseService
import br.com.anibal.events.domain.Arguments
import br.com.anibal.events.domain.MenuItemString
import br.com.anibal.events.domain.Talk
import br.com.anibal.events.extension.getBrDate
import br.com.anibal.events.extension.toast
import br.com.anibal.events.web.WebClient
import kotlinx.android.synthetic.main.fragment_recycler_view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread

open class TalkFragment : BaseFragment() {

    protected var talks = listOf<Talk>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
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
        taskTalk()
    }

    open fun taskTalk() {
        val id = Arguments.type

        WebClient().getTalks({
            this.talks = it
            formatDate()
            saveTalks()
            configureAdapter()
        }, {
            toast(getString(R.string.txt_not_connected))
            loadSavedTalks()
        }, Arguments.findInt(id.toString()),
        id)
    }

    private fun loadSavedTalks() {
        doAsync {
            talks = TalkDatabaseService.getEventTalks()

            uiThread {
                configureAdapter()
            }
        }
    }

    private fun formatDate() {
        for(talk in this.talks) {
            talk.date = talk.date.getBrDate()
        }
    }

    private fun saveTalks() {
        doAsync {
            TalkDatabaseService.saveTalks(talks)
        }
    }

    private fun configureAdapter() {
        recyclerView.adapter = TalkAdapter(talks) { onClickTalk(it) }
    }

    open fun onClickTalk(talk: Talk) {
        Arguments.talk = talk
        activity?.startActivity<TalkDetailActivity>()
    }
}
