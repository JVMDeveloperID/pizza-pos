package id.jasoet.pizzapos.infra.db

import id.jasoet.pizzapos.type.Money
import id.jasoet.pizzapos.value.CrustSize
import id.jasoet.pizzapos.value.CrustType
import id.jasoet.pizzapos.value.Topping

interface PriceDatabaseService {
    fun getToppingPrices(): Map<Topping, Money>
    fun getCrustSizePrices(): Map<CrustSize, Money>
    fun getCrustTypPrices(): Map<CrustType, Money>
}

class PriceDatabaseServiceImpl : PriceDatabaseService {
    override fun getToppingPrices(): Map<Topping, Money> = TODO("Implement this")
    override fun getCrustSizePrices(): Map<CrustSize, Money>  = TODO("Implement this")
    override fun getCrustTypPrices(): Map<CrustType, Money> = TODO("Implement this")
}