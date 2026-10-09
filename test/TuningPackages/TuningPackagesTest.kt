package TuningPackages

import Model.BasicCar
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TuningPackagesTest {

    private fun baseCar() = BasicCar("Lada Vesta", 180, 106, 1200000.0, 1200, 1.6)

    @Test
    fun `Stage1 добавляет чип-тюнинг`() {
        val car = TuningPackages.stage1(baseCar())
        assertEquals(listOf("Чип-тюнинг"), car.tuningHistory)
        assertEquals(156, car.power)
    }

    @Test
    fun `Stage1 не дублирует чип, если уже установлен`() {
        val once = TuningPackages.stage1(baseCar())
        val twice = TuningPackages.stage1(once)
        assertEquals(1, twice.tuningHistory.count { it == "Чип-тюнинг" })
    }

    @Test
    fun `Stage2 добавляет три тюнинга`() {
        val car = TuningPackages.stage2(baseCar())
        assertEquals(3, car.tuningHistory.size)
        assertTrue("Чип-тюнинг" in car.tuningHistory)
        assertTrue("Спортивная подвеска" in car.tuningHistory)
        assertTrue("Керамические тормоза" in car.tuningHistory)
    }

    @Test
    fun `Stage2 не дублирует тюнинги при повторном применении`() {
        val once = TuningPackages.stage2(baseCar())
        val twice = TuningPackages.stage2(once)
        assertEquals(3, twice.tuningHistory.size)
    }

    @Test
    fun `Stage2 добавляет только отсутствующие тюнинги`() {
        val withChip = TuningPackages.stage1(baseCar())
        assertEquals(1, withChip.tuningHistory.size)

        val stage2 = TuningPackages.stage2(withChip)
        assertEquals(3, stage2.tuningHistory.size)
        assertEquals(1, stage2.tuningHistory.count { it == "Чип-тюнинг" })
    }

    @Test
    fun `Stage3 добавляет пять тюнингов`() {
        val car = TuningPackages.stage3(baseCar())
        assertEquals(5, car.tuningHistory.size)
        assertTrue("Чип-тюнинг" in car.tuningHistory)
        assertTrue("Спортивная подвеска" in car.tuningHistory)
        assertTrue("Керамические тормоза" in car.tuningHistory)
        assertTrue("Система NOS" in car.tuningHistory)
        assertTrue("Спойлер" in car.tuningHistory)
    }

    @Test
    fun `Stage3 не дублирует тюнинги при повторном применении`() {
        val once = TuningPackages.stage3(baseCar())
        val twice = TuningPackages.stage3(once)
        assertEquals(5, twice.tuningHistory.size)
    }

    @Test
    fun `Stage3 поверх stage2 добавляет только отсутствующие`() {
        val stage2 = TuningPackages.stage2(baseCar())
        val stage3 = TuningPackages.stage3(stage2)
        assertEquals(5, stage3.tuningHistory.size)
    }

    @Test
    fun `Базовый автомобиль не изменяется`() {
        val base = baseCar()
        TuningPackages.stage3(base)
        assertEquals(106, base.power)
        assertEquals(180, base.maxSpeed)
        assertTrue(base.tuningHistory.isEmpty())
    }
}