
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

public class svcproduction implements IRemote{
	public static svcproduction mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public svcproduction() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("svcproduction"), "b4a.example.svcproduction");
	}
     public static RemoteObject getObject() {
		return myClass;
	 }
	public RemoteObject _service;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
        _service = (RemoteObject) args[2];
        remoteMe = RemoteObject.declareNull("b4a.example.svcproduction");
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[3];
		pcBA = new PCBA(this, svcproduction.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _job = RemoteObject.declareNull("b4a.example.httpjob");
public static RemoteObject _lstofproduction = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _mysender = RemoteObject.createImmutable("");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.lazyloadingpage _lazyloadingpage = null;
public static b4a.example.modcommon _modcommon = null;
public static b4a.example.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"HttpUtils2Service",Debug.moduleToString(b4a.example.httputils2service.class),"Job",svcproduction._job,"LazyLoadingPage",Debug.moduleToString(b4a.example.lazyloadingpage.class),"lstOfProduction",svcproduction._lstofproduction,"Main",Debug.moduleToString(b4a.example.main.class),"modCommon",Debug.moduleToString(b4a.example.modcommon.class),"mySender",svcproduction._mysender,"Service",svcproduction.mostCurrent._service,"Starter",Debug.moduleToString(b4a.example.starter.class)};
}
}