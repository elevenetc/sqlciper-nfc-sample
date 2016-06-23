package su.levenetc.sqlciphernfc;

import android.app.Application;

import net.sqlcipher.database.SQLiteDatabase;

import java.io.File;

/**
 * Created by eugene.levenetc on 23/06/16.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initDatabase();
    }

    private void initDatabase() {
        SQLiteDatabase.loadLibs(this);
        File databaseFile = getDatabasePath("demo.db");
        databaseFile.mkdirs();
        databaseFile.delete();
        SQLiteDatabase database = SQLiteDatabase.openOrCreateDatabase(databaseFile, "test123", null);
        database.execSQL("create table t1(a, b)");
        database.execSQL("insert into t1(a, b) values(?, ?)", new Object[]{"one for the money", "two for the show"});
    }
}
