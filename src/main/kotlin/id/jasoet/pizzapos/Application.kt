/*
 * Copyright (C)2018 - Deny Prasetyo <jasoet87@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package id.jasoet.pizzapos

import id.jasoet.pizzapos.domain.Customer
import id.jasoet.pizzapos.domain.Order
import id.jasoet.pizzapos.domain.Pizza
import id.jasoet.pizzapos.service.OrderService
import id.jasoet.pizzapos.service.OrderServiceImpl
import id.jasoet.pizzapos.service.PizzaService
import id.jasoet.pizzapos.service.PizzaServiceImpl
import id.jasoet.pizzapos.value.Cheese
import id.jasoet.pizzapos.value.MediumCrustSize
import id.jasoet.pizzapos.value.Pepperoni
import id.jasoet.pizzapos.value.SmallCrustSize
import id.jasoet.pizzapos.value.ThickCrustType
import org.slf4j.LoggerFactory

object Application {
    private val log = LoggerFactory.getLogger(Application::class.java)

    @JvmStatic
    fun main(args: Array<String>) {
        val pizzaService: PizzaService = PizzaServiceImpl()
        val orderService: OrderService = OrderServiceImpl()

        val pizza1 = Pizza(crustSize = SmallCrustSize, crustType = ThickCrustType)
        pizza1.addTopping(Cheese)
        pizza1.addTopping(Pepperoni)
        pizza1.crustSize = MediumCrustSize
        pizza1.getPrice(
                pizzaService.getToppingPrizes(),
                pizzaService.getCrustSizePrizes(),
                pizzaService.getCrustTypePrizes()
        )

        val order1 = Order()
        order1.addPizzaToOrder(pizza1)
        order1.id = "Order1"
        order1.customer = Customer("Jasoet", "009", address = "Yogyakarta")


        orderService.save(order1)

    }
}
