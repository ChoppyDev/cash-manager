package cash_manager.epitech.cashmanager

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_nav.*
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import cash_manager.epitech.cashmanager.contentList.ArticlesContent


class NavActivity : AppCompatActivity(), ArticleFragment.OnListFragmentInteractionListener {

    override fun onListFragmentInteraction(item: ArticlesContent.ArticlesItems?) {
         //To change body of created functions use File | Settings | File Templates.
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val manager = supportFragmentManager
        when (item.itemId) {
            R.id.navigation_article -> {
                manager.beginTransaction().replace(R.id.view, ArticleFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            /*R.id.navigation_cart -> {
                manager.beginTransaction().replace(R.id.view, Settings()).commit()
                return@OnNavigationItemSelectedListener true
            }*/
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

        setContentView(R.layout.activity_nav)
        val tx = supportFragmentManager
        tx.beginTransaction().replace(cash_manager.epitech.cashmanager.R.id.view, ArticleFragment()).commit()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }
}
