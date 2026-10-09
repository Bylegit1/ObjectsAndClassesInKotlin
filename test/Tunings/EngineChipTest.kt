package Tunings

import Model.BasicCar
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class EngineChipTest {

    private val base = BasicCar("Lada Vesta", 180, 106, 1200000.0, 1200, 1.6)

    @Test
    fun `Увеличивает мощность на 50`() {
        val car = EngineChip(base)
        assertEquals(156, car.power)
    }

    @Test
    fun `Увеличивает скорость на 20`() {
        val car = EngineChip(base)
        assertEquals(200, car.maxSpeed)
    }

    @Test
    fun `Увеличивает цену на 30000`() {
        val car = EngineChip(base)
        assertEquals(1230000.0, car.price)
    }

    @Test
    fun `Не меняет массу и объём двигателя`() {
        val car = EngineChip(base)
        assertEquals(1200, car.weight)
        assertEquals(1.6, car.engineVolume)
    }

    @Test
    fun `Добавляет запись в историю тюнинга`() {
        val car = EngineChip(base)
        assertEquals(listOf("Чип-тюнинг"), car.tuningHistory)
    }

    @Test
    fun `Базовый автомобиль не изменяется`() {
        EngineChip(base)
        assertEquals(106, base.power)
        assertEquals(180, base.maxSpeed)
        assertTrue(base.tuningHistory.isEmpty())
    }
}