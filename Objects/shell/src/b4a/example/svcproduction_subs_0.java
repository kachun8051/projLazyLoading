package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class svcproduction_subs_0 {


public static RemoteObject  _getaddoneday(RemoteObject _datecode) throws Exception{
try {
		Debug.PushSubsStack("getAddOneDay (svcproduction) ","svcproduction",3,svcproduction.processBA,svcproduction.mostCurrent,100);
if (RapidSub.canDelegate("getaddoneday")) { return b4a.example.svcproduction.remoteMe.runUserSub(false, "svcproduction","getaddoneday", _datecode);}
RemoteObject _onedayadded = RemoteObject.createImmutable("");
RemoteObject _df = RemoteObject.createImmutable("");
RemoteObject _dt1 = RemoteObject.createImmutable(0L);
RemoteObject _dt2 = RemoteObject.createImmutable(0L);
RemoteObject _date1 = RemoteObject.createImmutable("");
Debug.locals.put("datecode", _datecode);
 BA.debugLineNum = 100;BA.debugLine="Private Sub getAddOneDay(datecode As String) As St";
Debug.ShouldStop(8);
 BA.debugLineNum = 101;BA.debugLine="If IsNumber(datecode) = False Or datecode.Length";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",svcproduction.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(_datecode)),svcproduction.mostCurrent.__c.getField(true,"False")) || RemoteObject.solveBoolean("!",_datecode.runMethod(true,"length"),BA.numberCast(double.class, 8))) { 
 BA.debugLineNum = 102;BA.debugLine="Return \"\"";
Debug.ShouldStop(32);
if (true) return BA.ObjectToString("");
 };
 BA.debugLineNum = 104;BA.debugLine="Dim OneDayAdded As String = \"\"";
Debug.ShouldStop(128);
_onedayadded = BA.ObjectToString("");Debug.locals.put("OneDayAdded", _onedayadded);Debug.locals.put("OneDayAdded", _onedayadded);
 BA.debugLineNum = 106;BA.debugLine="Dim df As String = DateTime.DateFormat";
Debug.ShouldStop(512);
_df = svcproduction.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getDateFormat");Debug.locals.put("df", _df);Debug.locals.put("df", _df);
 BA.debugLineNum = 107;BA.debugLine="DateTime.DateFormat = \"yyyyMMdd\"";
Debug.ShouldStop(1024);
svcproduction.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("yyyyMMdd"));
 BA.debugLineNum = 108;BA.debugLine="Try";
Debug.ShouldStop(2048);
try { BA.debugLineNum = 109;BA.debugLine="Dim dt1 As Long = DateTime.DateParse(datecode)";
Debug.ShouldStop(4096);
_dt1 = svcproduction.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateParse",(Object)(_datecode));Debug.locals.put("dt1", _dt1);Debug.locals.put("dt1", _dt1);
 BA.debugLineNum = 110;BA.debugLine="Dim dt2 As Long = DateTime.Add(dt1, 0, 0, 1)";
Debug.ShouldStop(8192);
_dt2 = svcproduction.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Add",(Object)(_dt1),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 1)));Debug.locals.put("dt2", _dt2);Debug.locals.put("dt2", _dt2);
 BA.debugLineNum = 111;BA.debugLine="DateTime.DateFormat = \"dd/MM/yyyy\"";
Debug.ShouldStop(16384);
svcproduction.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("dd/MM/yyyy"));
 BA.debugLineNum = 112;BA.debugLine="Dim date1 As String = DateTime.Date(dt2)";
Debug.ShouldStop(32768);
_date1 = svcproduction.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(_dt2));Debug.locals.put("date1", _date1);Debug.locals.put("date1", _date1);
 BA.debugLineNum = 113;BA.debugLine="OneDayAdded = date1 & \" 00:00:00+8:00\"";
Debug.ShouldStop(65536);
_onedayadded = RemoteObject.concat(_date1,RemoteObject.createImmutable(" 00:00:00+8:00"));Debug.locals.put("OneDayAdded", _onedayadded);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e14) {
			BA.rdebugUtils.runVoidMethod("setLastException",svcproduction.processBA, e14.toString()); BA.debugLineNum = 115;BA.debugLine="Log(LastException)";
Debug.ShouldStop(262144);
svcproduction.mostCurrent.__c.runVoidMethod ("LogImpl","06684687",BA.ObjectToString(svcproduction.mostCurrent.__c.runMethod(false,"LastException",svcproduction.processBA)),0);
 BA.debugLineNum = 116;BA.debugLine="OneDayAdded = \"\"";
Debug.ShouldStop(524288);
_onedayadded = BA.ObjectToString("");Debug.locals.put("OneDayAdded", _onedayadded);
 };
 BA.debugLineNum = 119;BA.debugLine="DateTime.DateFormat = df";
Debug.ShouldStop(4194304);
svcproduction.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",_df);
 BA.debugLineNum = 120;BA.debugLine="Return OneDayAdded";
Debug.ShouldStop(8388608);
if (true) return _onedayadded;
 BA.debugLineNum = 122;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getthisday(RemoteObject _datecode) throws Exception{
try {
		Debug.PushSubsStack("getThisDay (svcproduction) ","svcproduction",3,svcproduction.processBA,svcproduction.mostCurrent,92);
if (RapidSub.canDelegate("getthisday")) { return b4a.example.svcproduction.remoteMe.runUserSub(false, "svcproduction","getthisday", _datecode);}
Debug.locals.put("datecode", _datecode);
 BA.debugLineNum = 92;BA.debugLine="Private Sub getThisDay(datecode As String) As Stri";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 93;BA.debugLine="If IsNumber(datecode) = False Or datecode.Length";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",svcproduction.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(_datecode)),svcproduction.mostCurrent.__c.getField(true,"False")) || RemoteObject.solveBoolean("!",_datecode.runMethod(true,"length"),BA.numberCast(double.class, 8))) { 
 BA.debugLineNum = 94;BA.debugLine="Return \"\"";
Debug.ShouldStop(536870912);
if (true) return BA.ObjectToString("");
 };
 BA.debugLineNum = 96;BA.debugLine="Return datecode.SubString(6) & \"/\" & datecode.Sub";
Debug.ShouldStop(-2147483648);
if (true) return RemoteObject.concat(_datecode.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 6))),RemoteObject.createImmutable("/"),_datecode.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 4)),(Object)(BA.numberCast(int.class, 6))),RemoteObject.createImmutable("/"),_datecode.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 4))),RemoteObject.createImmutable(" 00:00:00+8:00"));
 BA.debugLineNum = 97;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _geturlfromonedate(RemoteObject _datecode) throws Exception{
try {
		Debug.PushSubsStack("getUrlFromOneDate (svcproduction) ","svcproduction",3,svcproduction.processBA,svcproduction.mostCurrent,76);
if (RapidSub.canDelegate("geturlfromonedate")) { return b4a.example.svcproduction.remoteMe.runUserSub(false, "svcproduction","geturlfromonedate", _datecode);}
RemoteObject _dt1 = RemoteObject.createImmutable("");
RemoteObject _dt2 = RemoteObject.createImmutable("");
RemoteObject _url = RemoteObject.createImmutable("");
Debug.locals.put("datecode", _datecode);
 BA.debugLineNum = 76;BA.debugLine="Private Sub getUrlFromOneDate(datecode As String)";
Debug.ShouldStop(2048);
 BA.debugLineNum = 78;BA.debugLine="If IsNumber(datecode) = False Or datecode.Length";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",svcproduction.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(_datecode)),svcproduction.mostCurrent.__c.getField(true,"False")) || RemoteObject.solveBoolean("!",_datecode.runMethod(true,"length"),BA.numberCast(double.class, 8))) { 
 BA.debugLineNum = 79;BA.debugLine="Return \"\"";
Debug.ShouldStop(16384);
if (true) return BA.ObjectToString("");
 };
 BA.debugLineNum = 82;BA.debugLine="Dim dt1 As String = getThisDay(datecode)";
Debug.ShouldStop(131072);
_dt1 = _getthisday(_datecode);Debug.locals.put("dt1", _dt1);Debug.locals.put("dt1", _dt1);
 BA.debugLineNum = 84;BA.debugLine="Dim dt2 As String = getAddOneDay(datecode)";
Debug.ShouldStop(524288);
_dt2 = _getaddoneday(_datecode);Debug.locals.put("dt2", _dt2);Debug.locals.put("dt2", _dt2);
 BA.debugLineNum = 85;BA.debugLine="Dim url As String = \"https://parseapi.back4app.co";
Debug.ShouldStop(1048576);
_url = RemoteObject.concat(RemoteObject.createImmutable("https://parseapi.back4app.com/classes/Production?"),(RemoteObject.concat(RemoteObject.createImmutable("where={\"packingdt\":{\""),svcproduction.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((svcproduction.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 36)))))),RemoteObject.createImmutable("gt\":\""),svcproduction.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_dt1))),RemoteObject.createImmutable("\",\""),svcproduction.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((svcproduction.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 36)))))),RemoteObject.createImmutable("lt\":\""),svcproduction.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_dt2))),RemoteObject.createImmutable("\"}}"))),(RemoteObject.createImmutable("&order=itemnum")));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 88;BA.debugLine="Log(url)";
Debug.ShouldStop(8388608);
svcproduction.mostCurrent.__c.runVoidMethod ("LogImpl","06094860",_url,0);
 BA.debugLineNum = 89;BA.debugLine="Return url";
Debug.ShouldStop(16777216);
if (true) return _url;
 BA.debugLineNum = 90;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _jobdone(RemoteObject _j) throws Exception{
try {
		Debug.PushSubsStack("JobDone (svcproduction) ","svcproduction",3,svcproduction.processBA,svcproduction.mostCurrent,55);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.svcproduction.remoteMe.runUserSub(false, "svcproduction","jobdone", _j);}
RemoteObject _jresponse = RemoteObject.createImmutable("");
RemoteObject _jparser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _map1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("j", _j);
 BA.debugLineNum = 55;BA.debugLine="Private Sub JobDone(j As HttpJob)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 56;BA.debugLine="If j.Success Then";
Debug.ShouldStop(8388608);
if (_j.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 57;BA.debugLine="Dim jResponse As String = j.GetString";
Debug.ShouldStop(16777216);
_jresponse = _j.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("jResponse", _jresponse);Debug.locals.put("jResponse", _jresponse);
 BA.debugLineNum = 58;BA.debugLine="Log(jResponse)";
Debug.ShouldStop(33554432);
svcproduction.mostCurrent.__c.runVoidMethod ("LogImpl","07208963",_jresponse,0);
 BA.debugLineNum = 59;BA.debugLine="Try";
Debug.ShouldStop(67108864);
try { BA.debugLineNum = 60;BA.debugLine="Dim jparser As JSONParser";
Debug.ShouldStop(134217728);
_jparser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("jparser", _jparser);
 BA.debugLineNum = 61;BA.debugLine="jparser.Initialize(jResponse)";
Debug.ShouldStop(268435456);
_jparser.runVoidMethod ("Initialize",(Object)(_jresponse));
 BA.debugLineNum = 62;BA.debugLine="Dim map1 As Map = jparser.Nextobject";
Debug.ShouldStop(536870912);
_map1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_map1 = _jparser.runMethod(false,"NextObject");Debug.locals.put("map1", _map1);Debug.locals.put("map1", _map1);
 BA.debugLineNum = 63;BA.debugLine="lstOfProduction = map1.Get(\"results\")";
Debug.ShouldStop(1073741824);
svcproduction._lstofproduction = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), _map1.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("results")))));
 BA.debugLineNum = 64;BA.debugLine="CallSubDelayed2(mySender, \"getQueryResponse\", C";
Debug.ShouldStop(-2147483648);
svcproduction.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",svcproduction.processBA,(Object)((svcproduction._mysender)),(Object)(BA.ObjectToString("getQueryResponse")),(Object)((svcproduction.mostCurrent.__c.runMethod(false, "createMap", (Object)(new RemoteObject[] {RemoteObject.createImmutable(("issuccess")),(svcproduction.mostCurrent.__c.getField(true,"True")),RemoteObject.createImmutable(("datalist")),(svcproduction._lstofproduction.getObject())})))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e11) {
			BA.rdebugUtils.runVoidMethod("setLastException",svcproduction.processBA, e11.toString()); BA.debugLineNum = 66;BA.debugLine="Log(LastException)";
Debug.ShouldStop(2);
svcproduction.mostCurrent.__c.runVoidMethod ("LogImpl","07208971",BA.ObjectToString(svcproduction.mostCurrent.__c.runMethod(false,"LastException",svcproduction.processBA)),0);
 BA.debugLineNum = 67;BA.debugLine="CallSubDelayed2(mySender, \"getQueryResponse\", C";
Debug.ShouldStop(4);
svcproduction.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",svcproduction.processBA,(Object)((svcproduction._mysender)),(Object)(BA.ObjectToString("getQueryResponse")),(Object)((svcproduction.mostCurrent.__c.runMethod(false, "createMap", (Object)(new RemoteObject[] {RemoteObject.createImmutable(("issuccess")),(svcproduction.mostCurrent.__c.getField(true,"False")),RemoteObject.createImmutable(("errmsg")),(svcproduction.mostCurrent.__c.runMethod(false,"LastException",svcproduction.processBA).runMethod(true,"getMessage"))})))));
 };
 }else {
 BA.debugLineNum = 70;BA.debugLine="CallSubDelayed2(mySender, \"getQueryResponse\", Cr";
Debug.ShouldStop(32);
svcproduction.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",svcproduction.processBA,(Object)((svcproduction._mysender)),(Object)(BA.ObjectToString("getQueryResponse")),(Object)((svcproduction.mostCurrent.__c.runMethod(false, "createMap", (Object)(new RemoteObject[] {RemoteObject.createImmutable(("issuccess")),(svcproduction.mostCurrent.__c.getField(true,"False")),RemoteObject.createImmutable(("errmsg")),(RemoteObject.createImmutable("Network access error"))})))));
 };
 BA.debugLineNum = 72;BA.debugLine="j.Release";
Debug.ShouldStop(128);
_j.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 73;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private Job As HttpJob";
svcproduction._job = RemoteObject.createNew ("b4a.example.httpjob");
 //BA.debugLineNum = 10;BA.debugLine="Private lstOfProduction As List";
svcproduction._lstofproduction = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 11;BA.debugLine="Private mySender As String";
svcproduction._mysender = RemoteObject.createImmutable("");
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _sendback4appreq(RemoteObject _url) throws Exception{
try {
		Debug.PushSubsStack("sendBack4AppReq (svcproduction) ","svcproduction",3,svcproduction.processBA,svcproduction.mostCurrent,47);
if (RapidSub.canDelegate("sendback4appreq")) { return b4a.example.svcproduction.remoteMe.runUserSub(false, "svcproduction","sendback4appreq", _url);}
Debug.locals.put("url", _url);
 BA.debugLineNum = 47;BA.debugLine="Private Sub sendBack4AppReq(url As String)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 48;BA.debugLine="Job.initialize(\"query\", Me)";
Debug.ShouldStop(32768);
svcproduction._job.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,svcproduction.processBA,(Object)(BA.ObjectToString("query")),(Object)(svcproduction.getObject()));
 BA.debugLineNum = 49;BA.debugLine="Job.Download(url)";
Debug.ShouldStop(65536);
svcproduction._job.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(_url));
 BA.debugLineNum = 50;BA.debugLine="Job.GetRequest.SetHeader(\"X-Parse-Application-Id\"";
Debug.ShouldStop(131072);
svcproduction._job.runClassMethod (b4a.example.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetHeader",(Object)(BA.ObjectToString("X-Parse-Application-Id")),(Object)(svcproduction.mostCurrent._modcommon._appid /*RemoteObject*/ ));
 BA.debugLineNum = 51;BA.debugLine="Job.GetRequest.SetHeader(\"X-Parse-REST-API-Key\",";
Debug.ShouldStop(262144);
svcproduction._job.runClassMethod (b4a.example.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetHeader",(Object)(BA.ObjectToString("X-Parse-REST-API-Key")),(Object)(svcproduction.mostCurrent._modcommon._apikey /*RemoteObject*/ ));
 BA.debugLineNum = 52;BA.debugLine="Job.GetRequest.SetHeader(\"X-Parse-Master-Key\", mo";
Debug.ShouldStop(524288);
svcproduction._job.runClassMethod (b4a.example.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetHeader",(Object)(BA.ObjectToString("X-Parse-Master-Key")),(Object)(svcproduction.mostCurrent._modcommon._masterkey /*RemoteObject*/ ));
 BA.debugLineNum = 53;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (svcproduction) ","svcproduction",3,svcproduction.processBA,svcproduction.mostCurrent,14);
if (RapidSub.canDelegate("service_create")) { return b4a.example.svcproduction.remoteMe.runUserSub(false, "svcproduction","service_create");}
 BA.debugLineNum = 14;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(8192);
 BA.debugLineNum = 15;BA.debugLine="lstOfProduction.Initialize";
Debug.ShouldStop(16384);
svcproduction._lstofproduction.runVoidMethod ("Initialize");
 BA.debugLineNum = 16;BA.debugLine="modCommon.initParams";
Debug.ShouldStop(32768);
svcproduction.mostCurrent._modcommon.runVoidMethod ("_initparams" /*RemoteObject*/ ,svcproduction.processBA);
 BA.debugLineNum = 17;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (svcproduction) ","svcproduction",3,svcproduction.processBA,svcproduction.mostCurrent,43);
if (RapidSub.canDelegate("service_destroy")) { return b4a.example.svcproduction.remoteMe.runUserSub(false, "svcproduction","service_destroy");}
 BA.debugLineNum = 43;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(1024);
 BA.debugLineNum = 45;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (svcproduction) ","svcproduction",3,svcproduction.processBA,svcproduction.mostCurrent,19);
if (RapidSub.canDelegate("service_start")) { return b4a.example.svcproduction.remoteMe.runUserSub(false, "svcproduction","service_start", _startingintent);}
RemoteObject _mytask = RemoteObject.createImmutable("");
RemoteObject _myparam = RemoteObject.createImmutable("");
RemoteObject _url = RemoteObject.createImmutable("");
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 19;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 20;BA.debugLine="Service.StopAutomaticForeground 'Call this when t";
Debug.ShouldStop(524288);
svcproduction.mostCurrent._service.runVoidMethod ("StopAutomaticForeground");
 BA.debugLineNum = 21;BA.debugLine="If StartingIntent.HasExtra(\"sender\") = False Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",_startingintent.runMethod(true,"HasExtra",(Object)(RemoteObject.createImmutable("sender"))),svcproduction.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 22;BA.debugLine="Return";
Debug.ShouldStop(2097152);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 24;BA.debugLine="If StartingIntent.HasExtra(\"task\") = False Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",_startingintent.runMethod(true,"HasExtra",(Object)(RemoteObject.createImmutable("task"))),svcproduction.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 25;BA.debugLine="Return";
Debug.ShouldStop(16777216);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 27;BA.debugLine="mySender = StartingIntent.GetExtra(\"sender\")";
Debug.ShouldStop(67108864);
svcproduction._mysender = BA.ObjectToString(_startingintent.runMethod(false,"GetExtra",(Object)(RemoteObject.createImmutable("sender"))));
 BA.debugLineNum = 28;BA.debugLine="Dim myTask As String = StartingIntent.GetExtra(\"t";
Debug.ShouldStop(134217728);
_mytask = BA.ObjectToString(_startingintent.runMethod(false,"GetExtra",(Object)(RemoteObject.createImmutable("task"))));Debug.locals.put("myTask", _mytask);Debug.locals.put("myTask", _mytask);
 BA.debugLineNum = 29;BA.debugLine="Dim myParam As String";
Debug.ShouldStop(268435456);
_myparam = RemoteObject.createImmutable("");Debug.locals.put("myParam", _myparam);
 BA.debugLineNum = 30;BA.debugLine="If StartingIntent.HasExtra(\"param\") Then";
Debug.ShouldStop(536870912);
if (_startingintent.runMethod(true,"HasExtra",(Object)(RemoteObject.createImmutable("param"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 31;BA.debugLine="myParam = StartingIntent.GetExtra(\"param\")";
Debug.ShouldStop(1073741824);
_myparam = BA.ObjectToString(_startingintent.runMethod(false,"GetExtra",(Object)(RemoteObject.createImmutable("param"))));Debug.locals.put("myParam", _myparam);
 }else {
 BA.debugLineNum = 33;BA.debugLine="myParam = \"\"";
Debug.ShouldStop(1);
_myparam = BA.ObjectToString("");Debug.locals.put("myParam", _myparam);
 };
 BA.debugLineNum = 35;BA.debugLine="Select myTask";
Debug.ShouldStop(4);
switch (BA.switchObjectToInt(_mytask,BA.ObjectToString("query"))) {
case 0: {
 BA.debugLineNum = 37;BA.debugLine="Dim url As String = getUrlFromOneDate(myParam)";
Debug.ShouldStop(16);
_url = _geturlfromonedate(_myparam);Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 38;BA.debugLine="sendBack4AppReq(url)";
Debug.ShouldStop(32);
_sendback4appreq(_url);
 break; }
}
;
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}