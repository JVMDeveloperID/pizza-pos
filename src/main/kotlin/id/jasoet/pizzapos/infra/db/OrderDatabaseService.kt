package id.jasoet.pizzapos.infra.db

import arrow.core.Try
import id.jasoet.pizzapos.domain.Order

interface OrderDatabaseService {
    fun save(order: Order): Try<Unit>
    fun update(id: String, order: Order): Try<Unit>
    fun deleteById(id: String): Try<Unit>
    fun getById(id: String): Try<Order>
}

class OrderDatabaseServiceImpl : OrderDatabaseService {
    override fun save(order: Order): Try<Unit> = TODO("Implement this")
    override fun update(id: String, order: Order): Try<Unit> = TODO("Implement this")
    override fun deleteById(id: String): Try<Unit> = TODO("Implement this")
    override fun getById(id: String): Try<Order> = TODO("Implement this")
}