package io.github.bersoncrios.starwarsfans.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.github.bersoncrios.starwarsfans.models.Result

@Database(entities = [Result::class], version = 1)
abstract class PersonDataBase : RoomDatabase() {

    abstract fun personDao(): PersonDao

    companion object {
        @Volatile
        private var INSTANCE : PersonDataBase? = null

        fun getDataBase(context: Context) : PersonDataBase {

            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        PersonDataBase::class.java,
                    "SwDB"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}