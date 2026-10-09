package Tunings

import Model.Car

class Nitro (car: Car): CarTuning(car) {
    override val power get() = car.power + 100
    override val maxSpeed get() = car.maxSpeed + 40
    override val price get() = car.price + 200000.0
    override val weight get() = car.weight + 25
    override val tuningHistory get() = car.tuningHistory + "Система NOS"
}