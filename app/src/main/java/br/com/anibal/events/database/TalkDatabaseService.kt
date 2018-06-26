package br.com.anibal.events.database

import br.com.anibal.events.domain.Arguments.event
import br.com.anibal.events.domain.Talk

object TalkDatabaseService {
    fun getEventTalks(): List<Talk> {
        val dao = TalkDatabaseManager.getTalkDAO()
        return dao.getEventTalks(event.id)
    }

    private fun isSaved(talk: Talk): Boolean {
        val dao = TalkDatabaseManager.getTalkDAO()
        return dao.getTalkById(talk.id) != null
    }

    fun saveTalks(talks: List<Talk>) {
        val dao = TalkDatabaseManager.getTalkDAO()

        for(talk in talks) {
            val insert = isSaved(talk)
            if(!insert)
                dao.insertTalk(talk)
        }
    }
}