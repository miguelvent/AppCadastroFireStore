package com.example.composable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composable.ui.theme.ComposableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableTheme {
            App()
            LoginForm()
            }
        }
    }
}

@Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
        text = "Hello $name!",
        modifier = modifier
                    )
            }

@OptIn(ExperimentalMaterial3Api::class)
    @Composable
        fun App() {
            ComposableTheme {
            Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
        ) {
            Column {
            SimpleCenterAlignedTopAppBar()
            }
            Column {
            LoginForm()
            }

        }
    }
}

@ExperimentalMaterial3Api
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleCenterAlignedTopAppBar() {
    Scaffold(
        topBar = {
    CenterAlignedTopAppBar(
        title = {
    Text(
    "Register",
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )}
    ,)
     },
        content = { innerPadding ->
     LazyColumn(
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {}
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarSample() {
var text by rememberSaveable { mutableStateOf("") }
var active by rememberSaveable { mutableStateOf(false) }
    Box(
        Modifier
        .fillMaxSize()
        .semantics { isTraversalGroup = true }) {
    SearchBar(
        modifier = Modifier
        .align(Alignment.TopCenter)
        .semantics { traversalIndex = -1f },
        query = text,
        onQueryChange = { text = it },
        onSearch = { active = false },
        active = active,
        onActiveChange = {
                active = it
            },
        placeholder = { Text("Hinted search text") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
        trailingIcon = { Icon(Icons.Default.MoreVert, contentDescription = null) },
        ) {
            repeat(4) { idx ->
                val resultText = "Suggestion $idx"
    ListItem(
        headlineContent = { Text(resultText) },
        supportingContent = { Text("Additional info") },
        leadingContent = { Icon(Icons.Filled.Star, contentDescription = null) },
        modifier = Modifier
                        .clickable {
                            text = resultText
                            active = false
                        }
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp)
                )
            }
        }

    LazyColumn(
        contentPadding = PaddingValues(start = 16.dp, top = 72.dp, end = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            }
        }
    }

@Composable
fun LoginForm() {
    var nome by remember {mutableStateOf("")}
    var telefone by remember {mutableStateOf("")}
    var origem by remember {mutableStateOf("")}
    var data by remember {mutableStateOf("")}
    var observacao by remember {mutableStateOf("")}
    Column(
        modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
     OutlinedTextField(
        value = nome,
        onValueChange = {nome = it },
        label = {Text(text = "Nome") },
        keyboardOptions = KeyboardOptions.Default.copy(
        imeAction = ImeAction.Next,
        keyboardType = KeyboardType.Text
            ),
        modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
     OutlinedTextField(
        value = telefone,
        onValueChange = { telefone = it },
        label = { Text(text = "Telefone") },
        keyboardOptions = KeyboardOptions.Default.copy(
        imeAction = ImeAction.Done,
        keyboardType = KeyboardType.Phone
            ),
        modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
     EditableExposedDropdownMenuSample()
     OutlinedTextField(
        value = data,
        onValueChange = { data = it },
        label = { Text(text = "Data") },
        keyboardOptions = KeyboardOptions.Default.copy(
        imeAction = ImeAction.Done,
        keyboardType = KeyboardType.Text
            ),
        modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
     OutlinedTextField(
        value = observacao,
        onValueChange = { observacao = it },
        label = { Text(text = "Observação") },
        keyboardOptions = KeyboardOptions.Default.copy(
        imeAction = ImeAction.Done,
        keyboardType = KeyboardType.Text
            ),
        modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
     Row(
        modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
        ) {
     Button(
        onClick = {},
        modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
     Text(text = "Register")
            }
     Button(
        onClick = {},
        modifier = Modifier
                    .weight(1f)
            ) {
     Text(text = "Cancel")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditableExposedDropdownMenuSample() {
    val options = listOf("Choose  I", "Choose  II", "Choose  III", "Choose  IV", "Choose  V")
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf("") }
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
    TextField(
         modifier = Modifier.menuAnchor(),
         value = selectedOptionText,
         onValueChange = { selectedOptionText = it },
         label = { Text("Origem") },
         trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
         colors = ExposedDropdownMenuDefaults.textFieldColors(),
        )
        val filteringOptions = options.filter { it.contains(selectedOptionText, ignoreCase = true) }
        if (filteringOptions.isNotEmpty()) {
    ExposedDropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
            ) {
                filteringOptions.forEach { selectionOption ->
    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        onClick = {
                            selectedOptionText = selectionOption
                            expanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    ComposableTheme {
        App()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposableTheme {
        Greeting("Android")
    }
}