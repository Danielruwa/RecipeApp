data class Recipe(
    val title: String,
    val type: String,
    val serves: Int,
    val difficulty: String,
    val ingredients: List<String>,
    val preparationSteps: List<String>
)
