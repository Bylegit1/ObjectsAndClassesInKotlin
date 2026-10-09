package TuningPackages

import Model.Car
import Tunings.EngineChip
import Tunings.SportSuspension
import Tunings.CeramicBrakes
import Tunings.Nitro
import Tunings.Spoiler

object TuningPackages {

    fun stage1(base: Car): Car {
        var car = base
        if ("Чип-тюнинг" !in car.tuningHistory) car = EngineChip(car)
        return car
    }

    fun stage2(base: Car): Car {
        var car = base
        if ("Чип-тюнинг" !in car.tuningHistory) car = EngineChip(car)
        if ("Спортивная подвеска" !in car.tuningHistory) car = SportSuspension(car)
        if ("Керамические тормоза" !in car.tuningHistory) car = CeramicBrakes(car)
        return car
    }

    fun stage3(base: Car): Car {
        var car = base
        if ("Чип-тюнинг" !in car.tuningHistory) car = EngineChip(car)
        if ("Спортивная подвеска" !in car.tuningHistory) car = SportSuspension(car)
        if ("Керамические тормоза" !in car.tuningHistory) car = CeramicBrakes(car)
        if ("Система NOS" !in car.tuningHistory) car = Nitro(car)
        if ("Спойлер" !in car.tuningHistory) car = Spoiler(car)
        return car
    }
}