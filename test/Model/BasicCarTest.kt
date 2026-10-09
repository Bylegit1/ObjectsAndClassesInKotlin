package Model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.*

class BasicCarTest {

    @Test
    fun `Создаётся корректно с валидными данными`() {
        val car = BasicCar("Lada Vesta", 180, 106, 1200000.0, 1200, 1.6)

        assertEquals("Автомобиль: Lada Vesta", car.description)
        assertEquals(180, car.maxSpeed)
        assertEquals(106, car.power)
        assertEquals(1_200_000.0, car.price)
        assertEquals(1200, car.weight)
        assertEquals(1.6, car.engineVolume)
        assertTrue(car.tuningHistory.isEmpty())
    }

    @Test
    fun `Пустая модель вызывает исключение`() {
        assertThrows<IllegalArgumentException> {
            BasicCar("", 180, 106, 1200000.0, 1200, 1.6)
        }
    }

    @Test
    fun `Нулевая скорость вызывает исключение`() {
        assertThrows<IllegalArgumentException> {
            BasicCar("Lada", 0, 106, 1200000.0, 1200, 1.6)
        }
    }

    @Test
    fun `Отрицательная мощность вызывает исключение`() {
        assertThrows<IllegalArgumentException> {
            BasicCar("Lada", 180, -10, 1200000.0, 1200, 1.6)
        }
    }

    @Test
    fun `Нулевая цена вызывает исключение`() {
        assertThrows<IllegalArgumentException> {
            BasicCar("Lada", 180, 106, 0.0, 1200, 1.6)
        }
    }

    @Test
    fun `Нулевая масса вызывает исключение`() {
        assertThrows<IllegalArgumentException> {
            BasicCar("Lada", 180, 106, 1200000.0, 0, 1.6)
        }
    }

    @Test
    fun `Нулевой объём двигателя вызывает исключение`() {
        assertThrows<IllegalArgumentException> {
            BasicCar("Lada", 180, 106, 1200000.0, 1200, 0.0)
        }
    }
}