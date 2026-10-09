package Tunings

import Model.BasicCar
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SportSuspensionTest {

    private val base = BasicCar("Lada Vesta", 180, 106, 1200000.0, 1200, 1.6)

    @Test
    fun `Увеличивает скорость на 10`() {
        val car = SportSuspension(base)
        assertEquals(190, car.maxSpeed)
    }

    @Test
    fun `Увеличивает цену на 80000`() {
        val car = SportSuspension(base)
        assertEquals(1280000.0, car.price)
    }

    @Test
    fun `Снижает массу на 15 кг`() {
        val car = SportSuspension(base)
        assertEquals(1185, car.weight)
    }

    @Test
    fun `Не меняет мощность`() {
        val car = SportSuspension(base)
        assertEquals(106, car.power)
    }

    @Test
    fun `Добавляет запись в историю`() {
        val car = SportSuspension(base)
        assertEquals(listOf("Спортивная подвеска"), car.tuningHistory)
    }
}