package Tunings

import Model.Car

class Spoiler(car: Car): CarTuning(car) {
    override val price get() = car.price + 25000.0
    override val tuningHistory get() = car.tuningHistory + "Спойлер"
}