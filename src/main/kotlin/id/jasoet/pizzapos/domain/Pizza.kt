package id.jasoet.pizzapos.domain

import id.jasoet.pizzapos.type.Money
import id.jasoet.pizzapos.value.CrustSize
import id.jasoet.pizzapos.value.CrustType
import id.jasoet.pizzapos.value.RegularCrustType
import id.jasoet.pizzapos.value.SmallCrustSize
import id.jasoet.pizzapos.value.Topping

data class Pizza(
        val crustSize: CrustSize = SmallCrustSize,
        val crustType: CrustType = RegularCrustType,
        val toppings: List<Topping> = emptyList()) {

    fun addTopping(topping: Topping): Pizza {
        val toppings = this.toppings + topping
        return this.copy(toppings = toppings)
    }

    fun removeTopping(topping: Topping): Pizza {
        val toppings = this.toppings - topping
        return this.copy(toppings = toppings)
    }

    fun removeAllTopping(): Pizza {
        return this.copy(toppings = emptyList())
    }

    fun updateCrustSize(crustSize: CrustSize): Pizza {
        return this.copy(crustSize = crustSize)
    }

    fun updateCrustType(crustType: CrustType): Pizza {
        return this.copy(crustType = crustType)
    }

    fun calculatePizzaPrice(toppingPrices: Map<Topping, Money>,
                            crustTypePrices: Map<CrustType, Money>,
                            crustSizePrices: Map<CrustSize, Money>): Money? {

        val toppingsPrice: Money = this.toppings
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

        val crustTypePrice: Money = crustTypePrices[this.crustType] ?: return null
        val crustSizePrice: Money = crustSizePrices[this.crustSize] ?: return null

        return toppingsPrice + crustSizePrice + crustTypePrice
    }
}
