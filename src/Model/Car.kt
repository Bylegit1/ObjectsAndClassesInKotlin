package Model

interface Car{
    val description: String
    val maxSpeed: Int
    val power: Int
    val price: Double
    val weight: Int          // снаряжённая масса, кг
    val engineVolume: Double
    val tuningHistory: List<String>
}