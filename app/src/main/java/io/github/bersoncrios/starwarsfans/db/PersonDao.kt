package io.github.bersoncrios.starwarsfans.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.github.bersoncrios.starwarsfans.models.Result

@Dao
interface PersonDao {

    @Insert
    suspend fun addPerson(person: List<Result>)

    @Query("SELECT * FROM person")
    suspend fun fetchPerson() : List<Result>

}