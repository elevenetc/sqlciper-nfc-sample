package su.levenetc.sqlciphernfc.service;

import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.util.Log;

import net.sqlcipher.database.SQLiteDatabase;

import su.levenetc.sqlciphernfc.App;
import su.levenetc.sqlciphernfc.database.SQLHelper;

/**
 * Created by Eugene Levenetc on 22/06/2016.
 */
public class NfcService extends HostApduService {

    private static final String TAG = NfcService.class.getSimpleName();

    @Override
    public byte[] processCommandApdu(byte[] commandApdu, Bundle extras) {
        Log.i(TAG, "processCommandApdu");
        return new byte[0];
    }

    @Override
    public void onDeactivated(int reason) {
        Log.i(TAG, "onDeactivated");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        App.getInst().initDatabase();
//        SQLiteDatabase database = App.getDatabase();
        SQLHelper helper = App.getHelper();
        SQLiteDatabase database = helper.getWritableDatabase(App.password());
        Log.i(TAG, "onCreate");
        Log.i(TAG, "database:" + database + " helper: " + helper);

    }
}
