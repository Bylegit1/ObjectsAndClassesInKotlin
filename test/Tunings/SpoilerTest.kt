package Tunings

import Model.BasicCar
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SpoilerTest {

    private val base = BasicCar("Lada Vesta", 180, 106, 1200000.0, 1200, 1.6)

    @Test
    fun `Увеличивает цену на 25000`() {
        val car = Spoiler(base)
        assertEquals(1225000.0, car.price)
    }

    @Test
    fun `Не меняет мощность, скорость, массу`() {
        val car = Spoiler(base)
        assertEquals(106, car.power)
        assertEquals(180, car.maxSpeed)
        assertEquals(1200, car.weight)
    }

    @Test
    fun `Добавляет запись в историю`() {
        val car = Spoiler(base)
        assertEquals(listOf("Спойлер"), car.tuningHistory)
    }
}