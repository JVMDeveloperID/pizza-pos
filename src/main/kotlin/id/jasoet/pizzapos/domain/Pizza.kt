package id.jasoet.pizzapos.domain

import id.jasoet.pizzapos.type.Money
import id.jasoet.pizzapos.value.CrustSize
import id.jasoet.pizzapos.value.CrustType
import id.jasoet.pizzapos.value.MediumCrustSize
import id.jasoet.pizzapos.value.RegularCrustType
import id.jasoet.pizzapos.value.Topping

data class Pizza(var crustSize: CrustSize = MediumCrustSize, var crustType: CrustType = RegularCrustType) {
    private val toppings = mutableListOf<Topping>()

    fun getToppings(): MutableList<Topping> {
        return toppings
    }

    fun addTopping(topping: Topping) {
        toppings += topping
    }

    fun removeTopping(topping: Topping) {
        toppings -= topping
    }

    fun getPrice(
            toppingPrices: Map<Topping, Money>,
            crustSizePrices: Map<CrustSize, Money>,
            crustTypePrices: Map<CrustType, Money>
    ): Money = TODO("Calculate Price")

}
