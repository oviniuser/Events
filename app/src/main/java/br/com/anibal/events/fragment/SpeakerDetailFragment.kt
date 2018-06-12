package br.com.anibal.events.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.anibal.events.R
import br.com.anibal.events.domain.Arguments
import kotlinx.android.synthetic.main.desc_content.*
import kotlinx.android.synthetic.main.fragment_speaker_detail.*

class SpeakerDetailFragment : BaseFragment() {

    private val speaker = Arguments.speaker

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_speaker_detail, container, false)
    }

    override fun onResume() {
        super.onResume()
        textViewSpeakerName.text = this.speaker.name
        textViewFormation.text = this.speaker.formation
        textViewEmail.text = this.speaker.email
        textViewDesc.text = this.speaker.bio
    }
}
