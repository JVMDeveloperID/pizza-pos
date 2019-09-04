package id.jasoet.pizzapos.service

import id.jasoet.pizzapos.domain.Pizza
import id.jasoet.pizzapos.type.Money
import id.jasoet.pizzapos.value.CrustSize
import id.jasoet.pizzapos.value.CrustType
import id.jasoet.pizzapos.value.Topping

interface PizzaService {
    fun addTopping(pizza: Pizza, topping: Topping): Pizza {
        val toppings = pizza.toppings + topping
        return pizza.copy(toppings = toppings)
    }

    fun removeTopping(pizza: Pizza, topping: Topping): Pizza {
        val toppings = pizza.toppings - topping
        return pizza.copy(toppings = toppings)
    }

    fun removeAllTopping(pizza: Pizza): Pizza {
        return pizza.copy(toppings = emptyList())
    }

    fun updateCrustSize(pizza: Pizza, crustSize: CrustSize): Pizza {
        return pizza.copy(crustSize = crustSize)
    }

    fun updateCrustType(pizza: Pizza, crustType: CrustType): Pizza {
        return pizza.copy(crustType = crustType)
    }

    fun calculatePizzaPrice(pizza: Pizza,
                            toppingPrices: Map<Topping, Money>,
                            crustTypePrices: Map<CrustType, Money>,
                            crustSizePrices: Map<CrustSize, Money>): Money? {

        val toppingsPrice: Money = pizza.toppings
                .map {
                    toppingPrices[it]
                }
                .reduce { sum: Money?, price: Money? ->
                    if (sum == null || price == null) {
                        null
                    } else {
                        sum + price
                    }
                } ?: return null

        val crustTypePrice: Money = crustTypePrices[pizza.crustType] ?: return null
        val crustSizePrice: Money = crustSizePrices[pizza.crustSize] ?: return null

        return toppingsPrice + crustSizePrice + crustTypePrice
    }

}

