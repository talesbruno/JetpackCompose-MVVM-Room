//package co.talesbruno.notes
//
//import android.app.Application
//import co.talesbruno.notes.database.NoteDao
//import co.talesbruno.notes.database.NoteDatabase
//
//class App : Application() {
//
//    lateinit var db: NoteDatabase
//
//    override fun onCreate() {
//        super.onCreate()
//        db = NoteDatabase.getDatabase(this)
//    }
//}