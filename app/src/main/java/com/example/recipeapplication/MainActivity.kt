import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val isFirstTime = getSharedPreferences("PREFS", MODE_PRIVATE)
            .getBoolean("isFirstTime", true)

        if (isFirstTime) {
            showWelcomePage()
        } else {
            navigateToExplorePage()
        }
    }

    private fun showWelcomePage() {
        getSharedPreferences("PREFS", MODE_PRIVATE)
            .edit()
            .putBoolean("isFirstTime", false)
            .apply()

        navigateToExplorePage()
    }

    private fun navigateToExplorePage() {
        val intent = Intent(this, ExploreActivity::class.java)
        startActivity(intent)
        finish() 
    }
}
