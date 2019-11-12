package cash_manager.epitech.cashmanager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import cash_manager.epitech.cashmanager.ArticleAdapter.*
import cash_manager.epitech.cashmanager.model.Article

class ArticleAdapter(private val articles: ArrayList<Article>) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.title.text = articles[position].title


    }

    override fun getItemCount() = articles.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.article_row, parent, false)
        return ViewHolder(view)
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.photo)
        val title: TextView = itemView.findViewById(R.id.title)
    }

}