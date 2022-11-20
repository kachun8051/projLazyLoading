
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class modcommon implements IRemote{
	public static modcommon mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public modcommon() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
     private static PCBA pcBA = new PCBA(null, modcommon.class);
    static {
		mostCurrent = new modcommon();
        remoteMe = RemoteObject.declareNull("b4a.example.modcommon");
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("modcommon"), "b4a.example.modcommon");
        RDebug.INSTANCE.eventTargets.put(new DeviceClass("b4a.example.modcommon"), new java.lang.ref.WeakReference<PCBA> (pcBA));
	}
   
	public static RemoteObject runMethod(boolean notUsed, String method, Object... args) throws Exception{
		return (RemoteObject) pcBA.raiseEvent(method.substring(1), args);
	}
    public static void runVoidMethod(String method, Object... args) throws Exception{
		runMethod(false, method, args);
	}
	public PCBA create(Object[] args) throws ClassNotFoundException{
        throw new RuntimeException("CREATE is not supported.");
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _appid = RemoteObject.createImmutable("");
public static RemoteObject _apikey = RemoteObject.createImmutable("");
public static RemoteObject _masterkey = RemoteObject.createImmutable("");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.lazyloadingpage _lazyloadingpage = null;
public static b4a.example.svcproduction _svcproduction = null;
public static b4a.example.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"apikey",modcommon._apikey,"appid",modcommon._appid,"HttpUtils2Service",Debug.moduleToString(b4a.example.httputils2service.class),"LazyLoadingPage",Debug.moduleToString(b4a.example.lazyloadingpage.class),"Main",Debug.moduleToString(b4a.example.main.class),"masterkey",modcommon._masterkey,"Starter",Debug.moduleToString(b4a.example.starter.class),"svcProduction",Debug.moduleToString(b4a.example.svcproduction.class)};
}
}