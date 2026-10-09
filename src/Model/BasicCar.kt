package Model

class BasicCar(
    private val model: String,
    private val baseSpeed: Int,
    private val basePower: Int,
    private val basePrice: Double,
    private val baseWeight: Int,
    private val baseEngineVolume: Double
) : Car {
    init {
        require(model.isNotBlank()) { "Модель не может быть пустой" }
        require(baseSpeed > 0)     { "Скорость должна быть > 0" }
        require(basePower > 0)     { "Мощность должна быть > 0" }
        require(basePrice > 0)      { "Цена должна быть > 0" }
        require(baseWeight > 0)       { "Масса должна быть > 0" }
        require(baseEngineVolume > 0)  { "Объём двигателя должен быть > 0" }
    }

    override val description: String = "Автомобиль: $model"
    override val maxSpeed: Int = baseSpeed
    override val power: Int = basePower
    override val price: Double = basePrice
    override val weight: Int = baseWeight
    override val engineVolume: Double = baseEngineVolume
    override val tuningHistory: List<String> = emptyList()
}