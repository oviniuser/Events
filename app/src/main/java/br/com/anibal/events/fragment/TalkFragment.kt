package br.com.anibal.events.fragment


import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.anibal.events.R
import br.com.anibal.events.activity.TalkDetailActivity
import br.com.anibal.events.adapter.TalkAdapter
import br.com.anibal.events.domain.Arguments
import br.com.anibal.events.domain.Talk
import br.com.anibal.events.extension.getBrDate
import br.com.anibal.events.extension.toast
import br.com.anibal.events.web.WebClient
import kotlinx.android.synthetic.main.fragment_recycler_view.*
import org.jetbrains.anko.startActivity

open class TalkFragment : BaseFragment() {

    private val event = Arguments.event
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
        WebClient().getTalks({
            this.talks = it
            formatDate()
            configureAdapter()
        }, {
            toast("Falha ao carregar lista.")
        }, this.event.id)
    }

    private fun formatDate() {
        for(talk in this.talks) {
            talk.date = talk.date.getBrDate()
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
