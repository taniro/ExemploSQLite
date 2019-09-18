package tads.eaj.ufrn.exemplosqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import android.util.Log

class CarroDBOpener (context : Context) : SQLiteOpenHelper(context, CarroContrato.DATABASE_NAME, null, CarroContrato.DATA_BASE_VERSION) {

    val TAG = "sql"
    val SQL_CREATE_TABLE =
        "CREATE TABLE ${CarroContrato.CarroEntry.TABLE_NAME}" +
                "( ${BaseColumns._ID} INTEGER PRIMARY KEY, " +
                " ${CarroContrato.CarroEntry.NOME} TEXT," +
                " ${CarroContrato.CarroEntry.DESCRICAO} TEXT," +
                " ${CarroContrato.CarroEntry.TIPO_CARRO} TEXT," +
                " ${CarroContrato.CarroEntry.ANO} INTEGER" +
                ")"
    val SQL_DROP_TABLE =
        "DROP TABLE ${CarroContrato.CarroEntry.TABLE_NAME}"

    override fun onCreate(db: SQLiteDatabase) {
        Log.i(TAG, "Banco de dados Criado")
        db.execSQL(SQL_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if (oldVersion != newVersion) {
            db.execSQL(SQL_DROP_TABLE)
            db.execSQL(SQL_CREATE_TABLE)
        }
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if (oldVersion != newVersion) {
            db.execSQL(SQL_DROP_TABLE)
            db.execSQL(SQL_CREATE_TABLE)
        }
    }

    fun insert (c:Carro){
        var banco:SQLiteDatabase = writableDatabase
        try {

            var values = ContentValues()
            values.put(CarroContrato.CarroEntry.NOME, c.nome)
            values.put(CarroContrato.CarroEntry.ANO, c.ano)
            values.put(CarroContrato.CarroEntry.DESCRICAO, c.desc)
            values.put(CarroContrato.CarroEntry.TIPO_CARRO, c.tipo)

            banco.insert(CarroContrato.CarroEntry.TABLE_NAME, null, values)
            //banco.insert(CarroContrato.CarroEntry.TABLE_NAME, CarroContrato.CarroEntry.NOME, values)

        }finally {
            banco.close()
        }
    }

    fun update (c:Carro){
        var banco:SQLiteDatabase = writableDatabase
        try {

            var values = ContentValues()
            values.put(CarroContrato.CarroEntry.NOME, c.nome)
            values.put(CarroContrato.CarroEntry.ANO, c.ano)
            values.put(CarroContrato.CarroEntry.DESCRICAO, c.desc)
            values.put(CarroContrato.CarroEntry.TIPO_CARRO, c.tipo)

            var selection = "${BaseColumns._ID} = ?"
            var whereArgs = arrayOf("${c.id}")

            banco.update(CarroContrato.CarroEntry.TABLE_NAME, values, selection, whereArgs)

        }finally {
            banco.close()
        }
    }

    fun delete (c:Carro){
        var banco:SQLiteDatabase = writableDatabase
        try{

            var selection = "${BaseColumns._ID} = ?"
            var whereArgs = arrayOf("${c.id}")
            Log.i("AULABANCO", "Delete carro id = ${c.id}")
            banco.delete(CarroContrato.CarroEntry.TABLE_NAME, selection, whereArgs)

        }finally {
            banco.close()
        }
    }

    fun findByName(nome:String): Carro{
        var banco:SQLiteDatabase = readableDatabase
        try{

            var selection = "${CarroContrato.CarroEntry.NOME} = ?"
            var whereArgs = arrayOf("${nome}")
            val cursor:Cursor = banco.query(CarroContrato.CarroEntry.TABLE_NAME, null, selection, whereArgs, null, null, null, null)

            cursor.moveToFirst()

            var carro = Carro()
            carro.id = cursor.getInt(cursor.getColumnIndex(BaseColumns._ID))
            carro.nome = cursor.getString(cursor.getColumnIndex(CarroContrato.CarroEntry.NOME))
            carro.tipo = cursor.getString(cursor.getColumnIndex(CarroContrato.CarroEntry.TIPO_CARRO))
            carro.ano = cursor.getInt(cursor.getColumnIndex(CarroContrato.CarroEntry.ANO))
            carro.desc = cursor.getString(cursor.getColumnIndex(CarroContrato.CarroEntry.DESCRICAO))

            return carro

        }finally {
            banco.close()
        }
    }

    fun findById(id:Int): Carro{
        var banco:SQLiteDatabase = readableDatabase
        try{

            var selection = "${BaseColumns._ID} = ?"
            var whereArgs = arrayOf("${id}")
            val cursor:Cursor = banco.query(CarroContrato.CarroEntry.TABLE_NAME, null, selection, whereArgs, null, null, null, null)

            cursor.moveToFirst()

            var carro = Carro()
            carro.id = cursor.getInt(cursor.getColumnIndex(BaseColumns._ID))
            carro.nome = cursor.getString(cursor.getColumnIndex(CarroContrato.CarroEntry.NOME))
            carro.tipo = cursor.getString(cursor.getColumnIndex(CarroContrato.CarroEntry.TIPO_CARRO))
            carro.ano = cursor.getInt(cursor.getColumnIndex(CarroContrato.CarroEntry.ANO))
            carro.desc = cursor.getString(cursor.getColumnIndex(CarroContrato.CarroEntry.DESCRICAO))

            return carro

        }finally {
            banco.close()
        }
    }

    fun findAll(): ArrayList<Carro>{
        var banco:SQLiteDatabase = readableDatabase
        try{

            val cursor:Cursor = banco.query(CarroContrato.CarroEntry.TABLE_NAME, null, null, null, null, null, null, null)

            var listaCarros = ArrayList<Carro>()

            while( cursor.moveToNext()){
                var carro = Carro()
                carro.id = cursor.getInt(cursor.getColumnIndex(BaseColumns._ID))
                carro.nome = cursor.getString(cursor.getColumnIndex(CarroContrato.CarroEntry.NOME))
                carro.tipo = cursor.getString(cursor.getColumnIndex(CarroContrato.CarroEntry.TIPO_CARRO))
                carro.ano = cursor.getInt(cursor.getColumnIndex(CarroContrato.CarroEntry.ANO))
                carro.desc = cursor.getString(cursor.getColumnIndex(CarroContrato.CarroEntry.DESCRICAO))

                listaCarros.add(carro)
            }

            return listaCarros

        }finally {
            banco.close()
        }
    }
}