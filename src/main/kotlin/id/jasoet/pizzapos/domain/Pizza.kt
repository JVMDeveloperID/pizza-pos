package id.jasoet.pizzapos.domain

import id.jasoet.pizzapos.value.CrustSize
import id.jasoet.pizzapos.value.CrustType
import id.jasoet.pizzapos.value.RegularCrustType
import id.jasoet.pizzapos.value.SmallCrustSize
import id.jasoet.pizzapos.value.Topping

data class Pizza(
        val crustSize: CrustSize = SmallCrustSize,
        val crustType: CrustType = RegularCrustType,
        val toppings: List<Topping> = emptyList())
