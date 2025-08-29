package com.uvg.teamapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.uvg.teamapp.model.FakeTeamRepository
import com.uvg.teamapp.model.TeamMember

@Composable
fun TeamListScreen(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(16.dp)
) {
    val repository = FakeTeamRepository()
    val members = repository.getTeamMembers()

    Image(
        painter = painterResource(id = com.uvg.teamapp.R.drawable.background),
        contentDescription = "Fondo",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = contentPadding
    ) {
        items(members) { member ->
            TeamMemberItem(member = member)
        }
    }
}

@Composable
fun TeamMemberItem(member: TeamMember, onClick: () -> Unit = {}) { // Añadimos onClick opcional por si lo necesitas luego
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp) // Añade padding horizontal aquí también
            .clickable(onClick = onClick), // Hacemos la tarjeta clickeable
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant, // Color de fondo para la tarjeta
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp) // Padding interno para el contenido de la Card
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically // Alinea el icono y el texto verticalmente
        ) {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "Icono de Miembro del Equipo",
                modifier = Modifier.size(40.dp), // Ajusta el tamaño del icono según necesites
                tint = MaterialTheme.colorScheme.onSurfaceVariant // Color del icono
            )



            Spacer(modifier = Modifier.width(16.dp)) // Espacio entre el icono y la columna de texto

            Column { // Mantenemos la columna para nombre y descripción
                Text(
                    text = member.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant // Color del texto del nombre
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = member.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f) // Color del texto de descripción, un poco más suave
                )
            }
        }
    }
}
