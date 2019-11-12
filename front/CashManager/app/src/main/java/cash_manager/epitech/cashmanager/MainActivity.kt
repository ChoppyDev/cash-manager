package cash_manager.epitech.cashmanager

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog


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
                val alertDialog = AlertDialog.Builder(this)
                alertDialog.setTitle("Déconnexion")
                alertDialog.setMessage("Voulez-vous vraiment vous déconnecter ?")

                alertDialog.setPositiveButton("Oui", DialogInterface.OnClickListener { dialog, which ->
                    // here you can add functions
                })
                alertDialog.setNegativeButton("Non", DialogInterface.OnClickListener { dialog, which ->
                    // here you can add functions
                })
                alertDialog.show()
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
