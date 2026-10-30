
package com.example.profildveloppeur

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profildveloppeur.ui.theme.ProfilDéveloppeurTheme
import android.widget.Toast


// Couleurs de l'application
private val Bleu = Color(0xFF1D4ED8)
private val Fond = Color(0xFFF1F5F9)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ProfilDéveloppeurTheme {

                val context = LocalContext.current

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    ProfilScreen(
                        nom = "Zakia Kadi",
                        role = "Développeuse junior",
                        description = "Étudiante en informatique, passionnée par le développement logiciel, les applications mobiles et les systèmes d'information.",
                        competences = listOf(
                            "Java",
                            "Kotlin",
                            "Python",
                            "SQL",
                            "HTML / CSS",
                            "Git / GitHub"
                        ),
                        email = "z.kadi@myskolae.fr",
                        onContactClick = {
                            val intent = Intent(Intent.ACTION_SENDTO).apply {
                                data = Uri.parse("mailto:z.kadi@myskolae.fr")
                            }

                            try {
                                context.startActivity(intent)
                            } catch (e: android.content.ActivityNotFoundException) {
                                Toast.makeText(
                                    context,
                                    "Aucune application de messagerie disponible",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Écran principal du profil
@Composable
fun ProfilScreen(
    nom: String,
    role: String,
    description: String,
    competences: List<String>,
    email: String,
    onContactClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Fond
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ProfilHeader(
                nom = nom,
                role = role
            )

            DescriptionSection(
                description = description
            )

            CompetencesSection(
                competences = competences
            )

            ContactSection(
                email = email,
                onContactClick = onContactClick
            )
        }
    }
}

// En-tête
@Composable
fun ProfilHeader(
    nom: String,
    role: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = Bleu
    ) {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            Text(
                text = nom,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = role,
                fontSize = 17.sp,
                color = Color.White
            )
        }
    }
}

// A propos
@Composable
fun DescriptionSection(
    description: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        color = Color.White
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            TitreSection(titre = "À propos")

            Text(
                text = description,
                fontSize = 15.sp,
                color = Color.DarkGray
            )
        }
    }
}

// Compétences
@Composable
fun CompetencesSection(
    competences: List<String>,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        color = Color.White
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            TitreSection(titre = "Compétences")

            competences.forEach { competence ->
                Text(
                    text = "• $competence",
                    modifier = Modifier.padding(vertical = 3.dp),
                    color = Color.DarkGray
                )
            }
        }
    }
}

// Contact
@Composable
fun ContactSection(
    email: String,
    onContactClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        color = Color.White
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            TitreSection(titre = "Contact")

            Text(
                text = email,
                color = Color.DarkGray
            )

            Button(
                onClick = onContactClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentDescription = "Envoyer un email à Zakia Kadi"
                    },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Bleu
                )
            ) {
                Text(text = "Me contacter")
            }
        }
    }
}

// Titre réutilisable pour les sections
@Composable
fun TitreSection(
    titre: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = titre,
        modifier = modifier.padding(bottom = 10.dp),
        fontSize = 19.sp,
        fontWeight = FontWeight.Bold,
        color = Bleu
    )
}

// Première preview : profil personnel
@Preview(
    showBackground = true,
    name = "Profil Zakia"
)
@Composable
fun ProfilPreview() {
    ProfilDéveloppeurTheme {
        ProfilScreen(
            nom = "Zakia Kadi",
            role = "Développeuse junior",
            description = "Étudiante en informatique, passionnée par le développement logiciel et les systèmes d'information.",
            competences = listOf(
                "Java",
                "Kotlin",
                "Python",
                "SQL",
                "Git"
            ),
            email = "z.kadi@myskolae.fr",
            onContactClick = {}
        )
    }
}

// Deuxième preview : autre profil
@Preview(
    showBackground = true,
    name = "Profil Android"
)
@Composable
fun ProfilAndroidPreview() {
    ProfilDéveloppeurTheme {
        ProfilScreen(
            nom = "Alex Martin",
            role = "Développeur Android",
            description = "Passionné par le développement d'applications Android modernes.",
            competences = listOf(
                "Kotlin",
                "Jetpack Compose",
                "Git"
            ),
            email = "alex@gmail.com",
            onContactClick = {}
        )
    }
}
