package Tunings

import Model.Car

class EngineBore(car: Car) : CarTuning(car) {
    override val power get() = car.power + 30
    override val engineVolume get() = car.engineVolume + 0.2
    override val price get() = car.price + 90000.0
    override val tuningHistory get() = car.tuningHistory + "Расточка двигателя"
}