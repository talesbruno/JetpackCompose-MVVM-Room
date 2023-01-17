package co.talesbruno.notes.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.talesbruno.notes.models.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM notes ORDER BY id ASC")
    fun getAllNotes(): Flow<List<Note>>

    @Query("UPDATE notes SET title = :title, note = :note WHERE id = :id")
    suspend fun update(id: Int?, title: String?, note: String?)
}