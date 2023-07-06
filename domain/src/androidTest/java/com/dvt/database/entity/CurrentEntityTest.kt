package com.dvt.database.entity

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dvt.database.KilimanjaroDatabase
import com.dvt.database.dao.CurrentDao
import org.junit.Before
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
internal class CurrentEntityTest {

    private lateinit var currentDao: CurrentDao
    private lateinit var db:KilimanjaroDatabase

    @Before
    fun createDb(){
        val context = ApplicationProvider.getApplicationContext<Context>()
      //  db = Room.in
    }


}