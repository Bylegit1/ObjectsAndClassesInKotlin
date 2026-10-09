package Tunings

import Model.BasicCar
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CeramicBrakesTest {

    private val base = BasicCar("Lada Vesta", 180, 106, 1200000.0, 1200, 1.6)

    @Test
    fun `Увеличивает скорость на 5`() {
        val car = CeramicBrakes(base)
        assertEquals(185, car.maxSpeed)
    }

    @Test
    fun `Увеличивает цену на 150000`() {
        val car = CeramicBrakes(base)
        assertEquals(1350000.0, car.price)
    }

    @Test
    fun `Снижает массу на 10 кг`() {
        val car = CeramicBrakes(base)
        assertEquals(1190, car.weight)
    }

    @Test
    fun `Добавляет запись в историю`() {
        val car = CeramicBrakes(base)
        assertEquals(listOf("Керамические тормоза"), car.tuningHistory)
    }
}