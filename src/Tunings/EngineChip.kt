package Tunings

import Model.Car

class EngineChip(car: Car) : CarTuning(car) {
    override val power get() = car.power + 50
    override val maxSpeed get() = car.maxSpeed + 20
    override val price get() = car.price + 30000.0
    override val tuningHistory get() = car.tuningHistory + "Чип-тюнинг"
}