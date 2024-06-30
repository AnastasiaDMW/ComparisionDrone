package ru.itis.comparisondrone.data

import kotlin.random.Random

open class DroneBuilder<T : Drone>(protected val drone: T) {
    fun setName(name: String) = apply { drone.name = name }
    fun setModel(model: String) = apply { drone.model = model }
    fun setYear(year: Int) = apply { drone.yearManufacturer = year }
    fun setMaxSpeed(maxSpeed: Int) = apply { drone.maxSpeed = maxSpeed }
    fun setRange(range: Int) = apply { drone.range = range }

    fun build(): T {
        return drone
    }

    open fun randomize(): DroneBuilder<T> {
        return setName("Дрон ${Random.nextInt(1, 100)}")
            .setModel("AG-${Random.nextInt(100, 999)}")
            .setYear(Random.nextInt(2015, 2024))
            .setMaxSpeed(Random.nextInt(30, 60))
            .setRange(Random.nextInt(5, 15))
    }
}

class AgriculturalDroneBuilder : DroneBuilder<AgriculturalDrone>(AgriculturalDrone()) {
    fun setSensorType(sensorType: String) = apply { drone.sensorType = sensorType }
    fun setTankVolume(tankVolume: Int) = apply { drone.tankVolume = tankVolume }

    override fun randomize(): AgriculturalDroneBuilder {
        super.randomize()
        val randomSensorType = listOf("Тепловизионный", "Оптический", "Акустический").random()
        val randomTankVolume = Random.nextInt(10, 30)

        return setSensorType(randomSensorType)
            .setTankVolume(randomTankVolume)
    }
}

class RacingDroneBuilder : DroneBuilder<RacingDrone>(RacingDrone()) {
    fun setEngineType(engineType: String) = apply { drone.engineType = engineType }
    fun setBattery(battery: String) = apply { drone.battery = battery }

    override fun randomize(): RacingDroneBuilder {
        super.randomize()
        val randomEngineType = listOf("Турбированный", "Электрический").random()
        val randomBattery = Random.nextInt(2000, 5000)

        return setEngineType(randomEngineType)
            .setBattery("Литий-ионный, $randomBattery мАч")
    }
}

class MilitaryDroneBuilder : DroneBuilder<MilitaryDrone>(MilitaryDrone()) {
    fun setWeaponType(weaponType: String) = apply { drone.weaponType = weaponType }
    fun setArmor(armor: String) = apply { drone.armor = armor }

    override fun randomize(): MilitaryDroneBuilder {
        super.randomize()
        val randomWeaponType = listOf("Ракетный", "Лазерный", "Пулеметный").random()
        val randomArmor = listOf("Кевларовая", "Титановая", "Керамическая").random()

        return setWeaponType(randomWeaponType)
            .setArmor(randomArmor)
    }
}

class CommercialDroneBuilder : DroneBuilder<CommercialDrone>(CommercialDrone()) {
    fun setCameraType(cameraType: String) = apply { drone.cameraType = cameraType }
    fun setPayload(payload: Int) = apply { drone.payload = payload }

    override fun randomize(): CommercialDroneBuilder {
        super.randomize()
        val randomCameraType = listOf("HD", "4K", "Тепловизионная").random()
        val randomPayload = Random.nextInt(5, 15)

        return setCameraType(randomCameraType)
            .setPayload(randomPayload)
    }
}