package Tunings

import Model.Car

class CeramicBrakes(car: Car): CarTuning(car) {
    override val maxSpeed get() = car.maxSpeed + 5
    override val price get() = car.price + 150000.0
    override val weight get() = (car.weight - 10).coerceAtLeast(1)
    override val tuningHistory get() = car.tuningHistory + "Керамические тормоза"
}