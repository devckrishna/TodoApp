package com.example.todoapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {
    @Insert()
    suspend fun insertTask(todoMode:TodoModel):Long

    @Query("SELECT * FROM TODOMODEL WHERE Finished==0")
    fun getTask():LiveData<List<TodoModel>>

    @Query("UPDATE TODOMODEL SET Finished=1 WHERE id=:uid")
    fun finishTask(uid:Long)

    @Query("DELETE FROM TODOMODEL WHERE id=:uid")
    fun deleteTask(uid:Long)
}