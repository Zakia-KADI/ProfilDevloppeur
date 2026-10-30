# Profil développeur

## Description du projet

Cette application Android a été réalisée avec Kotlin et Jetpack Compose.
Elle permet d'afficher mon profil de développeuse avec mon nom, mon rôle, une présentation personnelle, mes compétences techniques et mon adresse email.
Un bouton "Me contacter" permet d'ouvrir une application de messagerie pour envoyer un email.

## Notions utilisées

- Composables : création de l'interface à l'aide de fonctions annotées `@Composable`.
- Paramètres : transmission des informations entre les composables.
- Modifiers : personnalisation de la taille, des espacements et de l'apparence des éléments.
- Padding externe et interne : gestion des espaces autour des sections et à l'intérieur des cartes.
- Callbacks : utilisation de `onContactClick` pour gérer le clic sur le bouton.
- Previews : création de deux aperçus avec `@Preview`.
- Accessibilité de base : ajout d'une `contentDescription` au bouton de contact.

## Explication du code

### 1. Quels composables avez-vous créés ?

J'ai créé six composables principaux :

- `ProfilScreen` : organise l'ensemble de l'écran.
- `ProfilHeader` : affiche le nom et le rôle.
- `DescriptionSection` : affiche la présentation personnelle.
- `CompetencesSection` : affiche les compétences.
- `ContactSection` : affiche l'email et le bouton de contact.
- `TitreSection` : affiche les titres des sections.

J'ai également créé deux composables pour les previews : `ProfilPreview` et `ProfilAndroidPreview`.

### 2. Quel composable représente l'écran principal ?

Le composable `ProfilScreen` représente l'écran principal. Il regroupe les différentes sections du profil dans une `Column`.

### 3. Où utilisez-vous un padding externe ?

J'utilise un padding externe dans `ProfilScreen` avec `Modifier.padding(20.dp)` pour laisser un espace entre le contenu et les bords de l'écran.
J'utilise également `Arrangement.spacedBy(16.dp)` pour espacer les différentes sections.

### 4. Où utilisez-vous un padding interne ?

J'utilise un padding interne dans les `Column` placées à l'intérieur des `Surface`, par exemple `Modifier.padding(24.dp)` dans `ProfilHeader` et `Modifier.padding(20.dp)` dans les autres sections.

Cela permet d'espacer le texte des bords des cartes.

### 5. Quel composant reçoit un callback ?

Le composable `ContactSection` reçoit le callback `onContactClick` en paramètre.
Ce callback est utilisé par le bouton « Me contacter » avec `onClick`. Lors du clic, l'application demande à Android d'ouvrir une application de messagerie.

### 6. Quelle information d'accessibilité avez-vous ajoutée ?

J'ai ajouté une `contentDescription` au bouton « Me contacter » avec `Modifier.semantics`.
La description est : « Envoyer un email à Zakia Kadi ».
Elle permet aux outils d'accessibilité de comprendre l'action du bouton.

### 7. Pourquoi vos composants peuvent-ils être considérés comme réutilisables ?

Mes composables sont réutilisables parce qu'ils reçoivent leurs informations sous forme de paramètres au lieu de contenir directement des valeurs fixes.
Ils possèdent également un paramètre `modifier: Modifier = Modifier` pour personnaliser leur affichage.
Par exemple, les deux previews utilisent le même composable `ProfilScreen` avec des informations différentes : mon profil et celui d'Alex Martin.
Cela permet d'afficher plusieurs profils sans modifier la structure de l'interface.

## Captures d'écran

Les captures d'écran sont disponibles dans le dossier `captures/` :

- `profil.png` : application sur l'émulateur.
- `previews.png` : les deux previews Jetpack Compose.
