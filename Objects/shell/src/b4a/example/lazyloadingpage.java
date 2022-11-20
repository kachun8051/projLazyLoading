
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

public class lazyloadingpage implements IRemote{
	public static lazyloadingpage mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public lazyloadingpage() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("lazyloadingpage"), "b4a.example.lazyloadingpage");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, lazyloadingpage.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _clv1 = RemoteObject.declareNull("b4a.example3.customlistview");
public static RemoteObject _imageview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _lbltitle = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _lblcontent = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _lblaction1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lblaction2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lstofproduction = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.svcproduction _svcproduction = null;
public static b4a.example.modcommon _modcommon = null;
public static b4a.example.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",lazyloadingpage.mostCurrent._activity,"CLV1",lazyloadingpage.mostCurrent._clv1,"HttpUtils2Service",Debug.moduleToString(b4a.example.httputils2service.class),"ImageView1",lazyloadingpage.mostCurrent._imageview1,"lblAction1",lazyloadingpage.mostCurrent._lblaction1,"lblAction2",lazyloadingpage.mostCurrent._lblaction2,"lblContent",lazyloadingpage.mostCurrent._lblcontent,"lblTitle",lazyloadingpage.mostCurrent._lbltitle,"lstOfProduction",lazyloadingpage.mostCurrent._lstofproduction,"Main",Debug.moduleToString(b4a.example.main.class),"modCommon",Debug.moduleToString(b4a.example.modcommon.class),"Starter",Debug.moduleToString(b4a.example.starter.class),"svcProduction",Debug.moduleToString(b4a.example.svcproduction.class),"xui",lazyloadingpage._xui};
}
}