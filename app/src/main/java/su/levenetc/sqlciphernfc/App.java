package su.levenetc.sqlciphernfc;

import android.app.Application;
import android.util.Log;

import net.sqlcipher.database.SQLiteDatabase;

import java.io.File;

import su.levenetc.sqlciphernfc.database.SQLHelper;

/**
 * Created by eugene.levenetc on 23/06/16.
 */
public class App extends Application {

    private static String TAG = App.class.getSimpleName();
    private static SQLiteDatabase database;
    private static SQLHelper helper;
    private static String password = "test123";
    private static App inst;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate");
        inst = this;
    }

    public void initDatabase() {
        Log.i(TAG, "initDatabase");
        String name = "demo.db";
        String creationQuery = "create table if not exists t1(a, b)";
        int version = 1;
        helper = new SQLHelper(this, name, version, creationQuery);
        SQLiteDatabase.loadLibs(this);
        File databaseFile = getDatabasePath(name);
//        databaseFile.mkdirs();
//        databaseFile.delete();
        //database = SQLiteDatabase.openOrCreateDatabase(databaseFile, "test123", null);
        //database.execSQL(creationQuery);
        //database.execSQL("insert into t1(a, b) values(?, ?)", new Object[]{"one for the money", "two for the show"});
    }

    public static App getInst() {
        return inst;
    }

    public static String password() {
        return password;
    }

    public static SQLiteDatabase getDatabase() {
        return database;
    }

    public static SQLHelper getHelper() {
        return helper;
    }


}
