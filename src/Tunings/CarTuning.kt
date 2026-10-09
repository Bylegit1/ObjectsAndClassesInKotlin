package Tunings

import Model.Car

abstract class CarTuning(protected  val car: Car): Car {
    override val description: String get() = car.description
    override val maxSpeed: Int get() = car.maxSpeed
    override val power: Int get() = car.power
    override val price: Double get() = car.price
    override val weight: Int get() = car.weight
    override val engineVolume: Double get() = car.engineVolume
    override val tuningHistory: List<String> get() = car.tuningHistory
}