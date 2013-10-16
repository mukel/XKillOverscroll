package domainless.xkilloverscroll;

import android.widget.AbsListView;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;

public class KillOverscrollMod implements IXposedHookZygoteInit {
	@Override
	public void initZygote(StartupParam startupParam) throws Throwable {
		XposedBridge.hookAllMethods(AbsListView.class, "initAbsListView", new XC_MethodHook() {
			@Override
			protected void afterHookedMethod(MethodHookParam param) throws Throwable {
				XposedHelpers.setIntField(param.thisObject, "mOverscrollDistance", 0);
				XposedHelpers.setIntField(param.thisObject, "mOverflingDistance", 0);
			}
		});	
	}
}
