package main

import Model.BasicCar
import Model.Car
import Tunings.EngineChip
import Tunings.SportSuspension
import Tunings.Spoiler
import Tunings.CeramicBrakes
import Tunings.Nitro
import Tunings.EngineBore
import TuningPackages.TuningPackages

fun main() {
    var car: Car? = null

    while (true) {
        println("\n=== Тюнинг автомобилей ===")
        println("1. Ввод базовых характеристик автомобиля")
        println("2. Выполнить тюнинг")
        println("3. Выход")

        print("Выбор: ")
        val choice = readln().trim()

        when (choice) {
            "1" -> {
                print("Модель: ")
                val model = readln().trim()

                print("Макс. скорость (км/ч): ")
                val speed = readln().trim().toInt()

                print("Мощность (л.с.): ")
                val power = readln().trim().toInt()

                print("Объём двигателя (л): ")
                val engine = readln().trim().replace(',', '.').toDouble()

                print("Снаряжённая масса (кг): ")
                val weight = readln().trim().toInt()

                print("Цена (руб.): ")
                val price = readln().trim().replace(',', '.').toDouble()

                car = BasicCar(model, speed, power, price, weight, engine)
                println("Данные автомобиля добавлены!")
                printCar(car)
            }

            "2" -> {
                val current = car
                if (current == null) {
                    println("Сначала введите характеристики автомобиля!")
                    continue
                }

                println("1. Выбрать Stage-пакет")
                println("2. Выбрать тюнинг вручную")
                print("Выбор: ")
                val sub = readln().trim()

                if (sub == "1") {
                    println("1. Stage 1")
                    println("2. Stage 2")
                    println("3. Stage 3")
                    print("Выбор: ")
                    val stage = readln().trim()

                    val result = when (stage) {
                        "1" -> TuningPackages.stage1(current)
                        "2" -> TuningPackages.stage2(current)
                        "3" -> TuningPackages.stage3(current)
                        else -> null
                    }

                    if (result == null) {
                        println("Неверный выбор!")
                    } else if (result.tuningHistory == current.tuningHistory) {
                        println("Этот Stage-пакет уже установлен!")
                    } else {
                        car = result
                        printCar(result)
                    }
                } else if (sub == "2") {
                    println("1. Чип-тюнинг")
                    println("2. Спортивная подвеска")
                    println("3. Спойлер")
                    println("4. Керамические тормоза")
                    println("5. Система NOS")
                    println("6. Расточка двигателя")
                    print("Выбор: ")
                    val t = readln().trim()

                    val tuningName = when (t) {
                        "1" -> "Чип-тюнинг"
                        "2" -> "Спортивная подвеска"
                        "3" -> "Спойлер"
                        "4" -> "Керамические тормоза"
                        "5" -> "Система NOS"
                        "6" -> "Расточка двигателя"
                        else -> null
                    }

                    if (tuningName == null) {
                        println("Неверный выбор!")
                    } else if (tuningName in current.tuningHistory) {
                        println("Этот тюнинг уже установлен!")
                    } else {
                        val result = when (t) {
                            "1" -> EngineChip(current)
                            "2" -> SportSuspension(current)
                            "3" -> Spoiler(current)
                            "4" -> CeramicBrakes(current)
                            "5" -> Nitro(current)
                            "6" -> EngineBore(current)
                            else -> current
                        }
                        car = result
                        printCar(result)
                    }
                }
            }

            "3" -> {
                println("Выходим из приложения...")
                return
            }

            else -> println("Неверный выбор!")
        }
    }
}

fun printCar(car: Car) {
    println("------------------------------")
    println(car.description)
    println("Мощность: ${car.power} л.с.")
    println("Объём двигателя: ${car.engineVolume} л")
    println("Макс. скорость: ${car.maxSpeed} км/ч")
    println("Масса: ${car.weight} кг")
    println("Цена: ${car.price} руб.")
    if (car.tuningHistory.isNotEmpty()) {
        println("Тюнинг: ${car.tuningHistory.joinToString(", ")}")
    }
    println("------------------------------")
}