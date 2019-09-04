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
import id.jasoet.pizzapos.infra.db.OrderDatabaseServiceImpl
import id.jasoet.pizzapos.infra.db.PriceDatabaseServiceImpl
import id.jasoet.pizzapos.value.Cheese
import id.jasoet.pizzapos.value.LargeCrustSize
import id.jasoet.pizzapos.value.MediumCrustSize
import id.jasoet.pizzapos.value.Mushrooms
import id.jasoet.pizzapos.value.Pepperoni
import id.jasoet.pizzapos.value.Sausage
import id.jasoet.pizzapos.value.SmallCrustSize
import id.jasoet.pizzapos.value.ThickCrustType
import id.jasoet.pizzapos.value.ThinCrustType
import org.slf4j.LoggerFactory

object Application {
    private val log = LoggerFactory.getLogger(Application::class.java)

    @JvmStatic
    fun main(args: Array<String>) {
        val orderDbService = OrderDatabaseServiceImpl()
        val priceDatabaseService = PriceDatabaseServiceImpl()


        val pizza1 = Pizza(crustSize = SmallCrustSize, crustType = ThickCrustType)
        val pizza2 = pizza1.addTopping(Cheese)
        val pizza3 = pizza2.addTopping(Pepperoni)
        val pizza4 = pizza3.updateCrustSize(MediumCrustSize)

        val bpizza1 = Pizza(crustSize = LargeCrustSize, crustType = ThinCrustType)
        val bpizza2 = bpizza1.addTopping(Sausage)
        val bpizza3 = bpizza2.addTopping(Mushrooms)

        val customer1 = Customer("Jasoet", "009", address = "Yogyakarta")
        val order1 = Order(id = "Some Id", customer = customer1)
        val order2 = order1.addPizza(pizza4)
        val order3 = order2.addPizza(bpizza3)

        val totalPrice = order3
                .calculatePrice(
                        priceDatabaseService.getToppingPrices(),
                        priceDatabaseService.getCrustTypPrices(),
                        priceDatabaseService.getCrustSizePrices()
                )

        println("Total Price: $totalPrice")

        orderDbService.save(order3)
    }
}
