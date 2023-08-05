import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "recipe")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val title: String,
    val type: String,
    val serves: Int,
    val difficulty: String,
    val ingredients: List<String>,
    val preparationSteps: List<String>
):Serializable
