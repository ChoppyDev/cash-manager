package cash_manager.epitech.cashmanager.contentList

import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object ArticlesContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<ArticlesItems> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, ArticlesItems> = HashMap()

    private val COUNT = 25

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createArticlesItem(i))
        }
    }

    private fun addItem(item: ArticlesItems) {
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
    }

    private fun createArticlesItem(position: Int): ArticlesItems {
        return ArticlesItems(position.toString(), "Item en vente n° $position","ic_add_circle_outline_black_24dp.xml" ,makeDetails(position))
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0 until position) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A dummy item representing a piece of content.
     */
    data class ArticlesItems(val id: String, val content: String, val image: String, val details: String) {
        override fun toString(): String = content
    }
}
