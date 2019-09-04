package id.jasoet.pizzapos.domain

data class Order(
        val id: String,
        val customer: Customer,
        val pizzas: List<Pizza> = emptyList())
