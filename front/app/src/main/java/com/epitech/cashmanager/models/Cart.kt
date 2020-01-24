package com.epitech.cashmanager.models


object Cart {
   private var articles : MutableList<Article> = mutableListOf()


    //get total price of cart
    fun total() : Float {
        var total = 0f
        for(a in this.articles)
            total+= (a.price * a.quantity)
        return total
    }

    fun add(article: Article) : Unit {
        this.articles.add(article)
    }
}