import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.recipe_detail.*

class RecipeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_detail)

        val recipe = intent.getParcelableExtra<Recipe>("recipe")
        
        recipe?.let {
            titleTextView.text = it.title
            typeTextView.text = it.type
            servesTextView.text = getString(R.string.serves_text, it.serves)
            difficultyTextView.text = getString(R.string.difficulty_text, it.difficulty)
            ingredientsTextView.text = buildIngredientsString(it.ingredients)
            preparationStepsTextView.text = buildPreparationStepsString(it.preparationSteps)
        }
    }

    private fun buildIngredientsString(ingredients: List<String>): String {
        val builder = StringBuilder()
        for (ingredient in ingredients) {
            builder.append("- $ingredient\n")
        }
        return builder.toString().trim()
    }

    private fun buildPreparationStepsString(steps: List<String>): String {
        val builder = StringBuilder()
        for ((index, step) in steps.withIndex()) {
            builder.append("${index + 1}. $step\n")
        }
        return builder.toString().trim()
    }
}

