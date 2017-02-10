package br.edu.unifor.ewallet;

import com.orhanobut.hawk.Hawk;
import com.orm.SugarApp;

/**
 * Created by maycon on 2/10/17.
 */

public class WalletApplication extends SugarApp {

    @Override
    public void onCreate() {
        super.onCreate();
        Hawk.init(this).build();
    }
}
