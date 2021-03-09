package tads.eaj.ufrn.exemplosqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val c1 = Carro(0,2018, "Palio", "Hatch", "Carro" )
        val c2 = Carro(0,2017, "Fusca", "Hatch", "Carro" )
        val c3 = Carro(0,2015, "Uno", "Hatch", "Carro" )
        val c4 = Carro(0,2018, "HB20", "Sedan", "Carro" )
        val c5 = Carro(0,2019, "Spin", "Sedan", "Carro" )

        val db = CarroDBOpener(this)

        db.insert(c1)
        db.insert(c2)
        db.insert(c3)
        db.insert(c4)
        db.insert(c5)

        /*
        var carros = db.findAll()
        carros.forEach { Log.i("AULABANCO", it.toString()) }

        db.delete(db.findById(2))
        db.delete(db.findById(3))

        Log.i("AULABANCO", "Carros deletados.")

        carros = db.findAll()

        carros.forEach { Log.i("AULABANCO", it.toString()) }

        val c6 = db.findByName("HB20")
        c6.nome = "HB20S"

        db.update(c6)

        Log.i("AULABANCO", "Carro HB20 atualizado.")
        carros = db.findAll()
        carros.forEach { Log.i("AULABANCO", it.toString()) }

         */

    }
}
