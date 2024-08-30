import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.* // Para Spacer y Grid
import androidx.compose.foundation.lazy.LazyColumn // Para LazyColumn
import androidx.compose.foundation.lazy.LazyRow // Para LazyRow
import androidx.compose.material3.* // Para Scaffold, FloatingActionButton, AlertDialog, etc.
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("My App") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Acción al hacer clic */ }) {
                Text("+")
            }
        }
    ) {
        // Aquí puedes llamar a tus funciones de contenedores y controles
        LazyColumnExample()
        Spacer(modifier = Modifier.height(16.dp))
        LazyRowExample()
        Spacer(modifier = Modifier.height(16.dp))
        GridExample()
        Spacer(modifier = Modifier.height(16.dp))
        ShowAlertDialog()
    }
}

@Composable
fun LazyColumnExample() {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(10) { index ->
            Text(text = "Elemento $index", modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun LazyRowExample() {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(10) { index ->
            Text(text = "Elemento $index", modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun GridExample() {
    Column(modifier = Modifier.padding(16.dp)) {
        for (i in 0..1) { // Número de filas
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                for (j in 0..2) { // Número de columnas
                    Text(text = "Item ${i * 3 + j}")
                }
            }
        }
    }
}

@Composable
fun ShowAlertDialog() {
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Alerta") },
            text = { Text("Este es un mensaje de alerta.") },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Aceptar")
                }
            }
        )
    }

    Button(onClick = { showDialog = true }) {
        Text("Mostrar Alerta")
    }
}
