package Tunings

import Model.BasicCar
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NitroTest {

    private val base = BasicCar("Lada Vesta", 180, 106, 1200000.0, 1200, 1.6)

    @Test
    fun `Увеличивает мощность на 100`() {
        val car = Nitro(base)
        assertEquals(206, car.power)
    }

    @Test
    fun `Увеличивает скорость на 40`() {
        val car = Nitro(base)
        assertEquals(220, car.maxSpeed)
    }

    @Test
    fun `Увеличивает цену на 200 000`() {
        val car = Nitro(base)
        assertEquals(1400000.0, car.price)
    }

    @Test
    fun `Увеличивает массу на 25 кг`() {
        val car = Nitro(base)
        assertEquals(1225, car.weight)
    }

    @Test
    fun `Добавляет запись в историю`() {
        val car = Nitro(base)
        assertEquals(listOf("Система NOS"), car.tuningHistory)
    }
}