package com.example.lab06

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab06.ui.theme.Lab06Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab06Theme {
                AppNavigation()  // Inicia la navegación
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { CustomScaffold(navController) }
        composable("profile") { UserProfileScreen() }
        composable("settings") { SettingsScreen() }
        composable("favorites") { FavoritesScreen() }
        composable("info") { InfoScreen() }
    }
}

@Composable
fun CustomScaffold(navController: NavController) {
    // Estado para llevar el conteo de las veces que se presiona el FAB
    var count by remember { mutableStateOf(0) }

    Scaffold(
        topBar = { CustomTopBar(navController) },
        bottomBar = { CustomBottomBar(navController) },
        floatingActionButton = { CustomFAB { count++ } }, // Pasa la acción para incrementar el contador
        content = { padding ->
            CustomContent(padding) // Reemplaza el contenido aquí con tu nuevo CustomContent
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(navController: NavController) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
            }
        },
        title = { Text(text = "Sample Title") },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null
                )
            }
            IconButton(onClick = {
                navController.navigate("profile") // Navega a la vista de perfil
            }) {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = "Profile"
                )
            }
        }
    )
}

@Composable
fun CustomBottomBar(navController: NavController) {
    BottomAppBar {
        IconButton(onClick = { navController.navigate("home") }) {
            Icon(Icons.Filled.Home, contentDescription = "Home")
        }
        IconButton(onClick = { navController.navigate("settings") }) {
            Icon(
                Icons.Filled.Settings,
                contentDescription = "Settings",
            )
        }
        IconButton(onClick = { navController.navigate("favorites") }) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = "Favorites",
            )
        }
        IconButton(onClick = { navController.navigate("info") }) {
            Icon(
                Icons.Filled.Info,
                contentDescription = "Info",
            )
        }
    }
}

@Composable
fun CustomFAB(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() } // Acción al hacer clic en el FAB
    ) {
        Text(
            fontSize = 24.sp, // Tamaño de fuente del texto del botón
            text = "+" // Texto del botón
        )
    }
}

@Composable
fun CustomContent(padding: PaddingValues) {
    Column(
        // Modificadores de estilo de la columna
        modifier = Modifier
            // Ocupar todo el espacio disponible
            .fillMaxSize()
            .padding(padding),

        // Centrar verticalmente y horizontalmente el contenido
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        // Contenido de la aplicación
        Text(
            text = "My app content",
            fontSize = 24.sp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("User Profile") })
        },
        content = {
            Text(
                text = "Bienvenido a la vista de perfil",
                modifier = Modifier.padding(16.dp)
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingsScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Settings") })
        },
        content = {
            Text(
                text = "Bienvenido a la configuración",
                modifier = Modifier.padding(16.dp)
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FavoritesScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Favorites") })
        },
        content = {
            Text(
                text = "Aquí están tus favoritos",
                modifier = Modifier.padding(16.dp)
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun InfoScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Info") })
        },
        content = {
            Text(
                text = "Información de la aplicación",
                modifier = Modifier.padding(16.dp)
            )
        }
    )
}


