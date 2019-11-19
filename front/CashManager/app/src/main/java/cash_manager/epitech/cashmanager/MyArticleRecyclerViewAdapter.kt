package cash_manager.epitech.cashmanager

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import cash_manager.epitech.cashmanager.R.layout


import cash_manager.epitech.cashmanager.ArticleFragment.OnListFragmentInteractionListener
import cash_manager.epitech.cashmanager.contentList.ArticlesContent.ArticlesItems

import kotlinx.android.synthetic.main.fragment_article.view.*
import android.R
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.content.res.AppCompatResources


/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyArticleRecyclerViewAdapter(
    private val mValues: List<ArticlesItems>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MyArticleRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as ArticlesItems
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout.fragment_article, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = mValues[position]

        holder.mContentView.text = item.content
        val myUri = Uri.parse(item.image)
        if(myUri != null)
            try{
                holder.mImageView.setImageDrawable(holder.mContentView.context.resources.getDrawable(holder.mContentView.context.resources.getIdentifier(item.image, "drawable", "cash_manager.epitech.cashmanager")))
            }
            catch (e:Exception)
            {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                    val myIcon =  holder.mContentView.context.resources.getDrawable(R.drawable.ic_menu_camera)
                    holder.mImageView.setImageDrawable(myIcon)
                } else {
                    val myIcon =  holder.mView.context.resources.getDrawable(R.drawable.ic_menu_camera, null)
                    holder.mImageView.setImageDrawable(myIcon)
                }
            }

        else
        {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                val myIcon =  holder.mContentView.context.resources.getDrawable(R.drawable.ic_menu_camera)
                holder.mImageView.setImageDrawable(myIcon)
            } else {
                val myIcon =  holder.mView.context.resources.getDrawable(R.drawable.ic_menu_camera, null)
                holder.mImageView.setImageDrawable(myIcon)
            }


        }


        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mContentView: TextView = mView.content
        val mImageView: ImageView = mView.item_image



        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
