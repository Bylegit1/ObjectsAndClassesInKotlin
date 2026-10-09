package Tunings

import Model.BasicCar
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class EngineBoreTest {

    private val base = BasicCar("Lada Vesta", 180, 106, 1200000.0, 1200, 1.6)

    @Test
    fun `Увеличивает мощность на 30`() {
        val car = EngineBore(base)
        assertEquals(136, car.power)
    }

    @Test
    fun `Увеличивает объём двигателя на 0,2`() {
        val car = EngineBore(base)
        assertEquals(1.8, car.engineVolume, 0.0001)
    }

    @Test
    fun `Увеличивает цену на 90 000`() {
        val car = EngineBore(base)
        assertEquals(1290000.0, car.price)
    }

    @Test
    fun `Добавляет запись в историю`() {
        val car = EngineBore(base)
        assertEquals(listOf("Расточка двигателя"), car.tuningHistory)
    }
}