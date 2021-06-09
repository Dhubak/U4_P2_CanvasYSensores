package mx.tecnm.tepic.u4_p2_canvasysensores

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View

class Lienzo(p:MainActivity) : View(p){
    var img = BitmapFactory.decodeResource(resources,R.drawable.estrella2)
    var fondo = BitmapFactory.decodeResource(resources,R.drawable.fondo2)
    var fond = BitmapFactory.decodeResource(resources,R.drawable.fondo1)

    var normal = AtributosGraficos(-250,-700, fondo)
    var atrapado = AtributosGraficos(-250,-700, fond)
    var estrella = AtributosGraficos(250,550, img)

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var p = Paint()

        atrapado.draw(c, p)
        normal.draw(c, p)
        estrella.draw(c, p)
    }
}