package ru.itis.comparisondrone

import android.util.Log
import androidx.lifecycle.ViewModel
import ru.itis.comparisondrone.data.AgriculturalDroneBuilder
import ru.itis.comparisondrone.data.CommercialDroneBuilder
import ru.itis.comparisondrone.data.Drone
import ru.itis.comparisondrone.data.MilitaryDroneBuilder
import ru.itis.comparisondrone.data.RacingDroneBuilder
import kotlin.random.Random

class MainActivityViewModel: ViewModel() {

    private val droneList = mutableListOf<Drone>()

    fun createDrone(count: Int) {
        droneList.clear()
        val droneType = Random.nextInt(4)
        for (i in 1..count) {
            val newDrone =  when (droneType) {
                0 -> AgriculturalDroneBuilder().randomize().build()
                1 -> RacingDroneBuilder().randomize().build()
                2 -> MilitaryDroneBuilder().randomize().build()
                3 -> CommercialDroneBuilder().randomize().build()
                else -> Drone()
            }
            droneList.add(newDrone)
        }
    }

    private fun race(drone1: Drone, drone2: Drone): Drone {
        val winner = if (drone1.maxSpeed == drone2.maxSpeed) {
            drone1
        } else {
            if (drone1.maxSpeed!! > drone2.maxSpeed!!) drone1 else drone2
        }
        Log.d("RACE","Гонка между ${drone1.name} и ${drone2.name}, Победитель ${winner.name}")
        return winner
    }

    fun organizeRaces(): Drone {
        var currentRound = droneList
        var roundNumber = 1

        while (currentRound.size > 1) {
            Log.d("RACE","--- Раунд $roundNumber ---")
            val nextRound = mutableListOf<Drone>()
            val rndDrones = currentRound.shuffled()

            for (i in rndDrones.indices step 2) {
                if (i + 1 < rndDrones.size) {
                    val winner = race(rndDrones[i], rndDrones[i + 1])
                    nextRound.add(winner)
                } else {
                    Log.d("RACE","${rndDrones[i].name} - Нет пары, следующий круг")
                    nextRound.add(rndDrones[i])
                }
            }

            currentRound = nextRound
            roundNumber++
        }

        return currentRound.first()
    }
}