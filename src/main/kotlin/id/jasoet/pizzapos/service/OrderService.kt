package id.jasoet.pizzapos.service

import id.jasoet.pizzapos.domain.Customer
import id.jasoet.pizzapos.domain.Order
import id.jasoet.pizzapos.domain.Pizza
import id.jasoet.pizzapos.type.Money
import id.jasoet.pizzapos.value.CrustSize
import id.jasoet.pizzapos.value.CrustType
import id.jasoet.pizzapos.value.Topping

interface OrderService {
    fun updateId(order: Order, id: String): Order {
        return order.copy(id = id)
    }

    fun updateCustomer(order: Order, customer: Customer): Order {
        return order.copy(customer = customer)
    }

    fun addPizza(order: Order, pizza: Pizza): Order {
        val pizzas = order.pizzas + pizza
        return order.copy(pizzas = pizzas)
    }

    fun removePizza(order: Order, pizza: Pizza): Order {
        val pizzas = order.pizzas - pizza
        return order.copy(pizzas = pizzas)
    }

    fun calculatePrice(order: Order,
                           pizzaService: PizzaService,
                           toppingPrices: Map<Topping, Money>,
                           crustTypePrices: Map<CrustType, Money>,
                           crustSizePrices: Map<CrustSize, Money>): Money? {

        return order.pizzas
                .map {
                    pizzaService.calculatePizzaPrice(it, toppingPrices, crustTypePrices, crustSizePrices)
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