import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Check if it's the first time the user opens the app
        val isFirstTime = getSharedPreferences("PREFS", MODE_PRIVATE)
            .getBoolean("isFirstTime", true)

        if (isFirstTime) {
            // Show the welcome page or intro slides
            showWelcomePage()
        } else {
            // User has already opened the app before, navigate to the Explore Page
            navigateToExplorePage()
        }
    }

    private fun showWelcomePage() {
        // TODO: Implement the code to show the welcome page or intro slides
        // For example, you can use a ViewPager with intro slides or a simple splash screen
        // After showing the welcome page, update the SharedPreferences to mark isFirstTime as false
        getSharedPreferences("PREFS", MODE_PRIVATE)
            .edit()
            .putBoolean("isFirstTime", false)
            .apply()

        // Once the welcome page is shown, navigate to the Explore Page
        navigateToExplorePage()
    }

    private fun navigateToExplorePage() {
        // Intent to navigate to the Explore Page
        val intent = Intent(this, ExploreActivity::class.java)
        startActivity(intent)
        finish() // Finish the MainActivity so that the user can't go back to it with the back button
    }
}
