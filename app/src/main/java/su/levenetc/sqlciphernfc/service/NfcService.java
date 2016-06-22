package su.levenetc.sqlciphernfc.service;

import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;

/**
 * Created by Eugene Levenetc on 22/06/2016.
 */
public class NfcService extends HostApduService {
	@Override public byte[] processCommandApdu(byte[] commandApdu, Bundle extras) {
		return new byte[0];
	}

	@Override public void onDeactivated(int reason) {
		
	}
}
