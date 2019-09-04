package id.jasoet.pizzapos.domain

import id.jasoet.pizzapos.type.Money

class Order {
    var id: String? = null
    private val pizzas = mutableListOf<Pizza>()
    var customer: Customer? = null

    fun getPizzas(): MutableList<Pizza> {
        return pizzas
    }

    fun addPizzaToOrder(pizza: Pizza) {
        pizzas += pizza
    }

    fun removePizzaFromOrder(pizza: Pizza) {
        pizzas -= pizza
    }

    fun getBasePrice(): Money = TODO("Calculate Base Price")
    fun getTaxes(): Money = TODO("Calculate Taxes")
    fun getTotalPrice(): Money = TODO("Calculate Total Price")

    fun printRecipe(): Unit = TODO("Print Recipe")

}