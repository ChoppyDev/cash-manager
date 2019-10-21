package cash_manager.epitech.cashmanager

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val manager = supportFragmentManager
        when (item.itemId) {
            R.id.navigation_article -> {
                manager.beginTransaction().replace(R.id.view, ListeArticles()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_cart -> {
                manager.beginTransaction().replace(R.id.view, Settings()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_preferences -> {
                manager.beginTransaction().replace(R.id.view, Settings()).commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }
}
