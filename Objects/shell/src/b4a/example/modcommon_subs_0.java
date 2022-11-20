package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class modcommon_subs_0 {


public static RemoteObject  _initparams(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("initParams (modcommon) ","modcommon",4,_ba,modcommon.mostCurrent,10);
if (RapidSub.canDelegate("initparams")) { return b4a.example.modcommon.remoteMe.runUserSub(false, "modcommon","initparams", _ba);}
;
 BA.debugLineNum = 10;BA.debugLine="Public Sub initParams()";
Debug.ShouldStop(512);
 BA.debugLineNum = 11;BA.debugLine="appid = \"5vUD5SzypdFDZfa7Sxjya1yLliHMAJ52ML3sqBf6";
Debug.ShouldStop(1024);
modcommon._appid = BA.ObjectToString("5vUD5SzypdFDZfa7Sxjya1yLliHMAJ52ML3sqBf6");
 BA.debugLineNum = 12;BA.debugLine="apikey = \"sgyDDR9YYlvTfkZv1datnUu75nhnnjqejm2yMFN";
Debug.ShouldStop(2048);
modcommon._apikey = BA.ObjectToString("sgyDDR9YYlvTfkZv1datnUu75nhnnjqejm2yMFNL");
 BA.debugLineNum = 13;BA.debugLine="masterkey = \"xFPWpeqIXuGXBek7CljLVsRH72TjvQen5Rd9";
Debug.ShouldStop(4096);
modcommon._masterkey = BA.ObjectToString("xFPWpeqIXuGXBek7CljLVsRH72TjvQen5Rd9XxiF");
 BA.debugLineNum = 14;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Public appid, apikey As String";
modcommon._appid = RemoteObject.createImmutable("");
modcommon._apikey = RemoteObject.createImmutable("");
 //BA.debugLineNum = 7;BA.debugLine="Public masterkey As String";
modcommon._masterkey = RemoteObject.createImmutable("");
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}