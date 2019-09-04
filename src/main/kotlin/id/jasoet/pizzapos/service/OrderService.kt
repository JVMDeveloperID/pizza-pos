package id.jasoet.pizzapos.service

import id.jasoet.pizzapos.domain.Order

interface OrderService {
    fun save(order: Order): Unit
    fun update(id: String, order: Order): Unit
    fun delete(id: String): Unit
    fun getById(id: String): Order
}

class OrderServiceImpl : OrderService {
    override fun save(order: Order) = TODO("Implement this")
    override fun update(id: String, order: Order) = TODO("Implement this")
    override fun delete(id: String) = TODO("Implement this")
    override fun getById(id: String): Order = TODO("Implement this")
}