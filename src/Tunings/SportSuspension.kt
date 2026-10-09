package Tunings

import Model.Car

class SportSuspension(car: Car) : CarTuning(car) {
    override val maxSpeed get() = car.maxSpeed + 10
    override val price get() = car.price + 80000.0
    override val weight get() = (car.weight - 15).coerceAtLeast(1)
    override val tuningHistory get() = car.tuningHistory + "Спортивная подвеска"
}