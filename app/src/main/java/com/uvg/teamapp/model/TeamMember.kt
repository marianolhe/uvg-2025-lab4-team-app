package com.uvg.teamapp.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.uvg.teamapp.model.FakeTeamRepository
import com.uvg.teamapp.model.TeamMember

data class TeamMember(val name: String, val description: String)

@Composable
fun TeamListScreen() {
    val repository = FakeTeamRepository()
    val members = repository.getTeamMembers()

    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = com.uvg.teamapp.R.drawable.background),
            contentDescription = "Fondo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(members) { member ->
            TeamMemberItem(member = member)
        }
    }
}}

@Composable
fun TeamMemberItem(member: TeamMember) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = member.name, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = member.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}