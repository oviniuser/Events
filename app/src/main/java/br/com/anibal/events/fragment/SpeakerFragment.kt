package br.com.anibal.events.fragment

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.anibal.events.R
import br.com.anibal.events.activity.SpeakerDetailActivity
import br.com.anibal.events.adapter.SpeakerAdapter
import br.com.anibal.events.domain.Arguments.talk
import br.com.anibal.events.domain.Speaker
import br.com.anibal.events.extension.toast
import br.com.anibal.events.web.WebClient
import kotlinx.android.synthetic.main.fragment_recycler_view.*
import org.jetbrains.anko.startActivity

class SpeakerFragment : BaseFragment() {

    protected var speakers = listOf<Speaker>()

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
        taskSpeaker()
    }

    open fun taskSpeaker() {
        WebClient().getSpeakers({
            this.speakers = it
            configureAdapter()
        }, {
            toast("Falha ao carregar lista.")
        }, talk.id)
    }

    private fun configureAdapter() {
        recyclerView.adapter = SpeakerAdapter(speakers) { onClickSpeaker(it) }
    }

    open fun onClickSpeaker(speaker: Speaker) {
//        Arguments
        activity?.startActivity<SpeakerDetailActivity>()
    }
}
