package mx.tecnm.tepic.u4_p2_canvasysensores

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), SensorEventListener {

    var lienzo : Lienzo ?= null
    lateinit var sensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lienzo = Lienzo(this)
        setContentView(lienzo)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL)

        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
                SensorManager.SENSOR_DELAY_NORMAL)
    }
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent) {
        if(event.sensor.type == Sensor.TYPE_ACCELEROMETER){
            lienzo!!.estrella.setX(lienzo!!.estrella.x.toInt()-((event.values[0].toInt())*10))
            lienzo!!.estrella.setY(lienzo!!.estrella.y.toInt()+((event.values[1].toInt())*10))
            lienzo!!.invalidate()
        }

        if(event.sensor.type == Sensor.TYPE_PROXIMITY){
            if(event.values[0]<3){
                lienzo!!.normal.setVisible(true)
                lienzo!!.atrapado.setVisible(false)
                lienzo!!.estrella.setVisible(false)
                lienzo!!.invalidate()
            }

            if(event.values[0]>=3){
                lienzo!!.normal.setVisible(false)
                lienzo!!.atrapado.setVisible(true)
                lienzo!!.estrella.setVisible(true)
                lienzo!!.invalidate()
            }

        }
    }

}