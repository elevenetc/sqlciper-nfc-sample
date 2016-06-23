package su.levenetc.sqlciphernfc.database;

import android.content.Context;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

/**
 * Created by eugene.levenetc on 09/05/16.
 */
public class SQLHelper extends SQLiteOpenHelper {

    private final String creationQuery;

    public SQLHelper(Context context, String name, int version, String creationQuery) {
        super(context, name, null, version);
        this.creationQuery = creationQuery;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(creationQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}