package mx.tecnm.tepic.u4_p2_canvasysensores

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint


class AtributosGraficos () {
    var x = 0f
    var y = 0f
    var imagen : Bitmap?=null
    var v = true

    constructor(x:Int, y:Int,i : Bitmap) : this(){
        this.imagen = i
        this.x = x.toFloat()
        this.y = y.toFloat()
    }

    fun draw(c: Canvas, p: Paint){
        if(this.v){
            c.drawBitmap(imagen!!,x,y,p)
        }
    }

    fun setVisible(v: Boolean){
        this.v = v
    }

    fun setX(x: Int){
        this.x = x.toFloat()
    }

    fun setY(y: Int){
        this.y = y.toFloat()
    }

}