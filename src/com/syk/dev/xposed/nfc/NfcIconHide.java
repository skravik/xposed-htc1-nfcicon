package com.syk.dev.xposed.nfc;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

/**
 * Xposed module that hides NFC taskbar icon when enabled
 * 
 * Created by Steven on 10/6/13.
 */
public class NfcIconHide implements IXposedHookLoadPackage{
	
	/**
	 * Hook the nfc application
	 */
    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("com.android.nfc"))
            return;

        XposedBridge.log("Adding hooks for package " + lpparam.packageName);
        
        findAndHookMethod("com.android.nfc.NfcService", lpparam.classLoader, "updateNfcIcon", new XC_MethodReplacement() {
			@Override
			protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
				return null;
			}
        });
    }
}
