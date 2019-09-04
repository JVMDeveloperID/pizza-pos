package id.jasoet.pizzapos.value

sealed class Topping
object Cheese : Topping()
object Pepperoni : Topping()
object Sausage : Topping()
object Mushrooms : Topping()
object Onions : Topping()

sealed class CrustType
object RegularCrustType : CrustType()
object ThinCrustType : CrustType()
object ThickCrustType : CrustType()

sealed class CrustSize
object SmallCrustSize : CrustSize()
object MediumCrustSize : CrustSize()
object LargeCrustSize : CrustSize()


