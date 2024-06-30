package ru.itis.comparisondrone.data

import android.util.Log

open class Drone {

    var name:  String? = ""
    var model: String? = ""
    var maxSpeed: Int? = 0
    var yearManufacturer: Int? = 0
    var range: Int? = 0

    open fun getInfo() {
        Log.d("INFO", "$name имеет следующую характеристику:\n" +
                "Модель --- $model\n" +
                "Максимальная скорость --- $maxSpeed\n" +
                "Дальность полета --- $range\n" +
                "Год выпуска --- $yearManufacturer\n")
    }
}

class AgriculturalDrone : Drone() {
    var sensorType: String = ""
    var tankVolume: Int = 0

    override fun getInfo() {
        super.getInfo()
        println("\nТип сенсора --- $sensorType\nОбъем бака для удобрений --- $tankVolume л")
    }
}

class RacingDrone : Drone() {
    var engineType: String = ""
    var battery: String = ""

    override fun getInfo() {
        super.getInfo()
        println("\nТип двигателя --- $engineType\nАккумулятор --- $battery")
    }
}

class MilitaryDrone : Drone() {
    var weaponType: String = ""
    var armor: String = ""

    override fun getInfo() {
        super.getInfo()
        println("\nТип оружия --- $weaponType\nБроня --- $armor")
    }
}

class CommercialDrone : Drone() {
    var cameraType: String = ""
    var payload: Int = 0

    override fun getInfo() {
        super.getInfo()
        println("\nТип камеры --- $cameraType\nГрузоподъемность --- $payload кг")
    }
}