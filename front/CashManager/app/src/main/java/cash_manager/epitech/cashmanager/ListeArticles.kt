package cash_manager.epitech.cashmanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cash_manager.epitech.cashmanager.model.Article
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_liste_articles.view.*
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_liste_articles.*
import kotlinx.android.synthetic.main.fragment_liste_articles.view.list_articles



/**
 * A simple [Fragment] subclass.
 *
 */
class ListeArticles : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        val articles = arrayListOf<Article>()

        for(i in 0..100){
            articles.add(Article("Pen", "", 2.50))

        }



        val toto = this@ListeArticles.context


        list_articles.apply {

            layoutManager = LinearLayoutManager(activity)
            adapter = ArticleAdapter(articles)
        }
        println("jjj");
    }

}
