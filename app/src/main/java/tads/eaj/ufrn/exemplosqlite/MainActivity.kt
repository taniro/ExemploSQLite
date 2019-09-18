package tads.eaj.ufrn.exemplosqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var c1 = Carro(0,2018, "Palio", "Hatch", "Carro" )

        var db = CarroDBOpener(this)
        db.readableDatabase

        //db.insert(c1)
    }
}
