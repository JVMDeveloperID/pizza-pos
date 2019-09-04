package id.jasoet.pizzapos.service

import id.jasoet.pizzapos.type.Money
import id.jasoet.pizzapos.value.CrustSize
import id.jasoet.pizzapos.value.CrustType
import id.jasoet.pizzapos.value.Topping

interface PizzaService {
    fun getAvailableTopping(): List<Topping>
    fun getAvailableCrustType(): List<CrustType>
    fun getAvailableCrustSize(): List<CrustSize>

    fun getToppingPrizes(): Map<Topping, Money>
    fun getCrustTypePrizes(): Map<CrustType, Money>
    fun getCrustSizePrizes(): Map<CrustSize, Money>
}

class PizzaServiceImpl : PizzaService {
    override fun getAvailableTopping(): List<Topping> = TODO("Implement this")
    override fun getAvailableCrustType(): List<CrustType> = TODO("Implement this")
    override fun getAvailableCrustSize(): List<CrustSize> = TODO("Implement this")
    override fun getToppingPrizes(): Map<Topping, Money> = TODO("Implement this")
    override fun getCrustTypePrizes(): Map<CrustType, Money> = TODO("Implement this")
    override fun getCrustSizePrizes(): Map<CrustSize, Money> = TODO("Implement this")
}