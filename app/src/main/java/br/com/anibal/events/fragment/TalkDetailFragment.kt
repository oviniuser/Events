package br.com.anibal.events.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.anibal.events.R
import br.com.anibal.events.domain.Arguments
import kotlinx.android.synthetic.main.adapter_talk.*
import kotlinx.android.synthetic.main.desc_content.*
import kotlinx.android.synthetic.main.fragment_talk_detail.*

class TalkDetailFragment : BaseFragment() {

    private val talk = Arguments.talk

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_talk_detail, container, false)
    }

    override fun onResume() {
        super.onResume()
        textViewTalkName.text = talk.name
        textViewDate.text = talk.date
        textViewStartTime.text = talk.startTime
        textViewFinishTime.text = talk.finishTime
        textViewCategory.text = talk.category
        textViewMaxPeople.text = talk.maxPeople.toString()
        textViewLocation.text = talk.location
        textViewDesc.text = talk.desc
    }
}
