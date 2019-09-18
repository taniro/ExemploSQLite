package tads.eaj.ufrn.exemplosqlite

import android.provider.BaseColumns

object CarroContrato {

    const val DATABASE_NAME = "carrodb.sqlite"
    const val DATA_BASE_VERSION = 1

    object CarroEntry : BaseColumns {
        const val TABLE_NAME = "carro"
        const val NOME = "nome"
        const val DESCRICAO = "desc"
        const val TIPO_CARRO = "tipo"
        const val ANO = "ano"
    }
}