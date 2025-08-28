package com.uvg.teamapp.model

class FakeTeamRepository {



    fun getTeamMembers(): List<TeamMember> {
        return listOf(

            TeamMember("Marcela","Disfruto hacer actividades físicas y mis artistas favoritos son BTS, The weeknd y Lana del Rey."),
            TeamMember("Marian","En mi tiempo libre me gusta mucho caminar o leer"),
            TeamMember("Ivana","Mis hobbies son tejer, pintar y escuchar música, también me  gusta mucho las matemáticas")




        )

    }
}