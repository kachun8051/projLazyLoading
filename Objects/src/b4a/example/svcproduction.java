package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class svcproduction extends  android.app.Service{
	public static class svcproduction_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (svcproduction) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, svcproduction.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, false, anywheresoftware.b4a.ShellBA.class);
		}

	}
    static svcproduction mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return svcproduction.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new anywheresoftware.b4a.ShellBA(this, null, null, "b4a.example", "b4a.example.svcproduction");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.svcproduction", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!false && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (svcproduction) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (false) {
			ServiceHelper.StarterHelper.runWaitForLayouts();
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() {
            public void run() {
                handleStart(intent);
            }}))
			;
		else {
			ServiceHelper.StarterHelper.addWaitForLayout (new Runnable() {
				public void run() {
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (svcproduction) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
				}
			});
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    public void onTaskRemoved(android.content.Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (false)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (svcproduction) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = ServiceHelper.StarterHelper.handleStartIntent(intent, _service, processBA);
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	
	@Override
	public void onDestroy() {
        super.onDestroy();
        if (false) {
            BA.LogInfo("** Service (svcproduction) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (svcproduction) Destroy **");
		    processBA.raiseEvent(null, "service_destroy");
            processBA.service = null;
		    mostCurrent = null;
		    processBA.setActivityPaused(true);
            processBA.runHook("ondestroy", this, null);
        }
	}

@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}
public anywheresoftware.b4a.keywords.Common __c = null;
public static b4a.example.httpjob _job = null;
public static anywheresoftware.b4a.objects.collections.List _lstofproduction = null;
public static String _mysender = "";
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.lazyloadingpage _lazyloadingpage = null;
public b4a.example.modcommon _modcommon = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _getaddoneday(String _datecode) throws Exception{
RDebugUtils.currentModule="svcproduction";
if (Debug.shouldDelegate(processBA, "getaddoneday", false))
	 {return ((String) Debug.delegate(processBA, "getaddoneday", new Object[] {_datecode}));}
String _onedayadded = "";
String _df = "";
long _dt1 = 0L;
long _dt2 = 0L;
String _date1 = "";
RDebugUtils.currentLine=6684672;
 //BA.debugLineNum = 6684672;BA.debugLine="Private Sub getAddOneDay(datecode As String) As St";
RDebugUtils.currentLine=6684673;
 //BA.debugLineNum = 6684673;BA.debugLine="If IsNumber(datecode) = False Or datecode.Length";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_datecode)==anywheresoftware.b4a.keywords.Common.False || _datecode.length()!=8) { 
RDebugUtils.currentLine=6684674;
 //BA.debugLineNum = 6684674;BA.debugLine="Return \"\"";
if (true) return "";
 };
RDebugUtils.currentLine=6684676;
 //BA.debugLineNum = 6684676;BA.debugLine="Dim OneDayAdded As String = \"\"";
_onedayadded = "";
RDebugUtils.currentLine=6684678;
 //BA.debugLineNum = 6684678;BA.debugLine="Dim df As String = DateTime.DateFormat";
_df = anywheresoftware.b4a.keywords.Common.DateTime.getDateFormat();
RDebugUtils.currentLine=6684679;
 //BA.debugLineNum = 6684679;BA.debugLine="DateTime.DateFormat = \"yyyyMMdd\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("yyyyMMdd");
RDebugUtils.currentLine=6684680;
 //BA.debugLineNum = 6684680;BA.debugLine="Try";
try {RDebugUtils.currentLine=6684681;
 //BA.debugLineNum = 6684681;BA.debugLine="Dim dt1 As Long = DateTime.DateParse(datecode)";
_dt1 = anywheresoftware.b4a.keywords.Common.DateTime.DateParse(_datecode);
RDebugUtils.currentLine=6684682;
 //BA.debugLineNum = 6684682;BA.debugLine="Dim dt2 As Long = DateTime.Add(dt1, 0, 0, 1)";
_dt2 = anywheresoftware.b4a.keywords.Common.DateTime.Add(_dt1,(int) (0),(int) (0),(int) (1));
RDebugUtils.currentLine=6684683;
 //BA.debugLineNum = 6684683;BA.debugLine="DateTime.DateFormat = \"dd/MM/yyyy\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("dd/MM/yyyy");
RDebugUtils.currentLine=6684684;
 //BA.debugLineNum = 6684684;BA.debugLine="Dim date1 As String = DateTime.Date(dt2)";
_date1 = anywheresoftware.b4a.keywords.Common.DateTime.Date(_dt2);
RDebugUtils.currentLine=6684685;
 //BA.debugLineNum = 6684685;BA.debugLine="OneDayAdded = date1 & \" 00:00:00+8:00\"";
_onedayadded = _date1+" 00:00:00+8:00";
 } 
       catch (Exception e14) {
			processBA.setLastException(e14);RDebugUtils.currentLine=6684687;
 //BA.debugLineNum = 6684687;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("06684687",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(processBA)),0);
RDebugUtils.currentLine=6684688;
 //BA.debugLineNum = 6684688;BA.debugLine="OneDayAdded = \"\"";
_onedayadded = "";
 };
RDebugUtils.currentLine=6684691;
 //BA.debugLineNum = 6684691;BA.debugLine="DateTime.DateFormat = df";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat(_df);
RDebugUtils.currentLine=6684692;
 //BA.debugLineNum = 6684692;BA.debugLine="Return OneDayAdded";
if (true) return _onedayadded;
RDebugUtils.currentLine=6684694;
 //BA.debugLineNum = 6684694;BA.debugLine="End Sub";
return "";
}
public static String  _getthisday(String _datecode) throws Exception{
RDebugUtils.currentModule="svcproduction";
if (Debug.shouldDelegate(processBA, "getthisday", false))
	 {return ((String) Debug.delegate(processBA, "getthisday", new Object[] {_datecode}));}
RDebugUtils.currentLine=7143424;
 //BA.debugLineNum = 7143424;BA.debugLine="Private Sub getThisDay(datecode As String) As Stri";
RDebugUtils.currentLine=7143425;
 //BA.debugLineNum = 7143425;BA.debugLine="If IsNumber(datecode) = False Or datecode.Length";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_datecode)==anywheresoftware.b4a.keywords.Common.False || _datecode.length()!=8) { 
RDebugUtils.currentLine=7143426;
 //BA.debugLineNum = 7143426;BA.debugLine="Return \"\"";
if (true) return "";
 };
RDebugUtils.currentLine=7143428;
 //BA.debugLineNum = 7143428;BA.debugLine="Return datecode.SubString(6) & \"/\" & datecode.Sub";
if (true) return _datecode.substring((int) (6))+"/"+_datecode.substring((int) (4),(int) (6))+"/"+_datecode.substring((int) (0),(int) (4))+" 00:00:00+8:00";
RDebugUtils.currentLine=7143429;
 //BA.debugLineNum = 7143429;BA.debugLine="End Sub";
return "";
}
public static String  _geturlfromonedate(String _datecode) throws Exception{
RDebugUtils.currentModule="svcproduction";
if (Debug.shouldDelegate(processBA, "geturlfromonedate", false))
	 {return ((String) Debug.delegate(processBA, "geturlfromonedate", new Object[] {_datecode}));}
String _dt1 = "";
String _dt2 = "";
String _url = "";
RDebugUtils.currentLine=6094848;
 //BA.debugLineNum = 6094848;BA.debugLine="Private Sub getUrlFromOneDate(datecode As String)";
RDebugUtils.currentLine=6094850;
 //BA.debugLineNum = 6094850;BA.debugLine="If IsNumber(datecode) = False Or datecode.Length";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_datecode)==anywheresoftware.b4a.keywords.Common.False || _datecode.length()!=8) { 
RDebugUtils.currentLine=6094851;
 //BA.debugLineNum = 6094851;BA.debugLine="Return \"\"";
if (true) return "";
 };
RDebugUtils.currentLine=6094854;
 //BA.debugLineNum = 6094854;BA.debugLine="Dim dt1 As String = getThisDay(datecode)";
_dt1 = _getthisday(_datecode);
RDebugUtils.currentLine=6094856;
 //BA.debugLineNum = 6094856;BA.debugLine="Dim dt2 As String = getAddOneDay(datecode)";
_dt2 = _getaddoneday(_datecode);
RDebugUtils.currentLine=6094857;
 //BA.debugLineNum = 6094857;BA.debugLine="Dim url As String = \"https://parseapi.back4app.co";
_url = "https://parseapi.back4app.com/classes/Production?"+("where={\"packingdt\":{\""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(anywheresoftware.b4a.keywords.Common.Chr((int) (36))))+"gt\":\""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_dt1))+"\",\""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(anywheresoftware.b4a.keywords.Common.Chr((int) (36))))+"lt\":\""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_dt2))+"\"}}")+("&order=itemnum");
RDebugUtils.currentLine=6094860;
 //BA.debugLineNum = 6094860;BA.debugLine="Log(url)";
anywheresoftware.b4a.keywords.Common.LogImpl("06094860",_url,0);
RDebugUtils.currentLine=6094861;
 //BA.debugLineNum = 6094861;BA.debugLine="Return url";
if (true) return _url;
RDebugUtils.currentLine=6094862;
 //BA.debugLineNum = 6094862;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _j) throws Exception{
RDebugUtils.currentModule="svcproduction";
if (Debug.shouldDelegate(processBA, "jobdone", false))
	 {return ((String) Debug.delegate(processBA, "jobdone", new Object[] {_j}));}
String _jresponse = "";
anywheresoftware.b4a.objects.collections.JSONParser _jparser = null;
anywheresoftware.b4a.objects.collections.Map _map1 = null;
RDebugUtils.currentLine=7208960;
 //BA.debugLineNum = 7208960;BA.debugLine="Private Sub JobDone(j As HttpJob)";
RDebugUtils.currentLine=7208961;
 //BA.debugLineNum = 7208961;BA.debugLine="If j.Success Then";
if (_j._success /*boolean*/ ) { 
RDebugUtils.currentLine=7208962;
 //BA.debugLineNum = 7208962;BA.debugLine="Dim jResponse As String = j.GetString";
_jresponse = _j._getstring /*String*/ (null);
RDebugUtils.currentLine=7208963;
 //BA.debugLineNum = 7208963;BA.debugLine="Log(jResponse)";
anywheresoftware.b4a.keywords.Common.LogImpl("07208963",_jresponse,0);
RDebugUtils.currentLine=7208964;
 //BA.debugLineNum = 7208964;BA.debugLine="Try";
try {RDebugUtils.currentLine=7208965;
 //BA.debugLineNum = 7208965;BA.debugLine="Dim jparser As JSONParser";
_jparser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=7208966;
 //BA.debugLineNum = 7208966;BA.debugLine="jparser.Initialize(jResponse)";
_jparser.Initialize(_jresponse);
RDebugUtils.currentLine=7208967;
 //BA.debugLineNum = 7208967;BA.debugLine="Dim map1 As Map = jparser.Nextobject";
_map1 = new anywheresoftware.b4a.objects.collections.Map();
_map1 = _jparser.NextObject();
RDebugUtils.currentLine=7208968;
 //BA.debugLineNum = 7208968;BA.debugLine="lstOfProduction = map1.Get(\"results\")";
_lstofproduction = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_map1.Get((Object)("results"))));
RDebugUtils.currentLine=7208969;
 //BA.debugLineNum = 7208969;BA.debugLine="CallSubDelayed2(mySender, \"getQueryResponse\", C";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(_mysender),"getQueryResponse",(Object)(anywheresoftware.b4a.keywords.Common.createMap(new Object[] {(Object)("issuccess"),(Object)(anywheresoftware.b4a.keywords.Common.True),(Object)("datalist"),(Object)(_lstofproduction.getObject())})));
 } 
       catch (Exception e11) {
			processBA.setLastException(e11);RDebugUtils.currentLine=7208971;
 //BA.debugLineNum = 7208971;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("07208971",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(processBA)),0);
RDebugUtils.currentLine=7208972;
 //BA.debugLineNum = 7208972;BA.debugLine="CallSubDelayed2(mySender, \"getQueryResponse\", C";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(_mysender),"getQueryResponse",(Object)(anywheresoftware.b4a.keywords.Common.createMap(new Object[] {(Object)("issuccess"),(Object)(anywheresoftware.b4a.keywords.Common.False),(Object)("errmsg"),(Object)(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage())})));
 };
 }else {
RDebugUtils.currentLine=7208975;
 //BA.debugLineNum = 7208975;BA.debugLine="CallSubDelayed2(mySender, \"getQueryResponse\", Cr";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(_mysender),"getQueryResponse",(Object)(anywheresoftware.b4a.keywords.Common.createMap(new Object[] {(Object)("issuccess"),(Object)(anywheresoftware.b4a.keywords.Common.False),(Object)("errmsg"),(Object)("Network access error")})));
 };
RDebugUtils.currentLine=7208977;
 //BA.debugLineNum = 7208977;BA.debugLine="j.Release";
_j._release /*String*/ (null);
RDebugUtils.currentLine=7208978;
 //BA.debugLineNum = 7208978;BA.debugLine="End Sub";
return "";
}
public static String  _sendback4appreq(String _url) throws Exception{
RDebugUtils.currentModule="svcproduction";
if (Debug.shouldDelegate(processBA, "sendback4appreq", false))
	 {return ((String) Debug.delegate(processBA, "sendback4appreq", new Object[] {_url}));}
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Private Sub sendBack4AppReq(url As String)";
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="Job.initialize(\"query\", Me)";
_job._initialize /*String*/ (null,processBA,"query",svcproduction.getObject());
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="Job.Download(url)";
_job._download /*String*/ (null,_url);
RDebugUtils.currentLine=2162691;
 //BA.debugLineNum = 2162691;BA.debugLine="Job.GetRequest.SetHeader(\"X-Parse-Application-Id\"";
_job._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null).SetHeader("X-Parse-Application-Id",mostCurrent._modcommon._appid /*String*/ );
RDebugUtils.currentLine=2162692;
 //BA.debugLineNum = 2162692;BA.debugLine="Job.GetRequest.SetHeader(\"X-Parse-REST-API-Key\",";
_job._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null).SetHeader("X-Parse-REST-API-Key",mostCurrent._modcommon._apikey /*String*/ );
RDebugUtils.currentLine=2162693;
 //BA.debugLineNum = 2162693;BA.debugLine="Job.GetRequest.SetHeader(\"X-Parse-Master-Key\", mo";
_job._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null).SetHeader("X-Parse-Master-Key",mostCurrent._modcommon._masterkey /*String*/ );
RDebugUtils.currentLine=2162694;
 //BA.debugLineNum = 2162694;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="svcproduction";
if (Debug.shouldDelegate(processBA, "service_create", false))
	 {return ((String) Debug.delegate(processBA, "service_create", null));}
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="lstOfProduction.Initialize";
_lstofproduction.Initialize();
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="modCommon.initParams";
mostCurrent._modcommon._initparams /*String*/ (processBA);
RDebugUtils.currentLine=1966083;
 //BA.debugLineNum = 1966083;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
RDebugUtils.currentModule="svcproduction";
if (Debug.shouldDelegate(processBA, "service_destroy", false))
	 {return ((String) Debug.delegate(processBA, "service_destroy", null));}
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub Service_Destroy";
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
RDebugUtils.currentModule="svcproduction";
if (Debug.shouldDelegate(processBA, "service_start", false))
	 {return ((String) Debug.delegate(processBA, "service_start", new Object[] {_startingintent}));}
String _mytask = "";
String _myparam = "";
String _url = "";
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="Service.StopAutomaticForeground 'Call this when t";
mostCurrent._service.StopAutomaticForeground();
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="If StartingIntent.HasExtra(\"sender\") = False Then";
if (_startingintent.HasExtra("sender")==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2031621;
 //BA.debugLineNum = 2031621;BA.debugLine="If StartingIntent.HasExtra(\"task\") = False Then";
if (_startingintent.HasExtra("task")==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=2031622;
 //BA.debugLineNum = 2031622;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2031624;
 //BA.debugLineNum = 2031624;BA.debugLine="mySender = StartingIntent.GetExtra(\"sender\")";
_mysender = BA.ObjectToString(_startingintent.GetExtra("sender"));
RDebugUtils.currentLine=2031625;
 //BA.debugLineNum = 2031625;BA.debugLine="Dim myTask As String = StartingIntent.GetExtra(\"t";
_mytask = BA.ObjectToString(_startingintent.GetExtra("task"));
RDebugUtils.currentLine=2031626;
 //BA.debugLineNum = 2031626;BA.debugLine="Dim myParam As String";
_myparam = "";
RDebugUtils.currentLine=2031627;
 //BA.debugLineNum = 2031627;BA.debugLine="If StartingIntent.HasExtra(\"param\") Then";
if (_startingintent.HasExtra("param")) { 
RDebugUtils.currentLine=2031628;
 //BA.debugLineNum = 2031628;BA.debugLine="myParam = StartingIntent.GetExtra(\"param\")";
_myparam = BA.ObjectToString(_startingintent.GetExtra("param"));
 }else {
RDebugUtils.currentLine=2031630;
 //BA.debugLineNum = 2031630;BA.debugLine="myParam = \"\"";
_myparam = "";
 };
RDebugUtils.currentLine=2031632;
 //BA.debugLineNum = 2031632;BA.debugLine="Select myTask";
switch (BA.switchObjectToInt(_mytask,"query")) {
case 0: {
RDebugUtils.currentLine=2031634;
 //BA.debugLineNum = 2031634;BA.debugLine="Dim url As String = getUrlFromOneDate(myParam)";
_url = _geturlfromonedate(_myparam);
RDebugUtils.currentLine=2031635;
 //BA.debugLineNum = 2031635;BA.debugLine="sendBack4AppReq(url)";
_sendback4appreq(_url);
 break; }
}
;
RDebugUtils.currentLine=2031638;
 //BA.debugLineNum = 2031638;BA.debugLine="End Sub";
return "";
}
}