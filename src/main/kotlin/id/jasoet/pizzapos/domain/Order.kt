package id.jasoet.pizzapos.domain

import id.jasoet.pizzapos.type.Money
import id.jasoet.pizzapos.value.CrustSize
import id.jasoet.pizzapos.value.CrustType
import id.jasoet.pizzapos.value.Topping

data class Order(
        val id: String,
        val customer: Customer,
        val pizzas: List<Pizza> = emptyList()) {

    fun updateId(id: String): Order {
        return this.copy(id = id)
    }

    fun updateCustomer(customer: Customer): Order {
        return this.copy(customer = customer)
    }

    fun addPizza(pizza: Pizza): Order {
        val pizzas = this.pizzas + pizza
        return this.copy(pizzas = pizzas)
    }

    fun removePizza(pizza: Pizza): Order {
        val pizzas = this.pizzas - pizza
        return this.copy(pizzas = pizzas)
    }

    fun calculatePrice(toppingPrices: Map<Topping, Money>,
                       crustTypePrices: Map<CrustType, Money>,
                       crustSizePrices: Map<CrustSize, Money>): Money? {

        return this.pizzas
                .map {
                    it.calculatePizzaPrice(toppingPrices, crustTypePrices, crustSizePrices)
                }
                .reduce { sum: Money?, price: Money? ->
                    if (sum == null || price == null) {
                        null
                    } else {
                        sum + price
                    }
                }
    }

}
