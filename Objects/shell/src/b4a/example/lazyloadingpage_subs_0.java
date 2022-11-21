package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class lazyloadingpage_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (lazyloadingpage) ","lazyloadingpage",2,lazyloadingpage.mostCurrent.activityBA,lazyloadingpage.mostCurrent,26);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.lazyloadingpage.remoteMe.runUserSub(false, "lazyloadingpage","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 26;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 29;BA.debugLine="Activity.LoadLayout(\"1\")";
Debug.ShouldStop(268435456);
lazyloadingpage.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("1")),lazyloadingpage.mostCurrent.activityBA);
 BA.debugLineNum = 30;BA.debugLine="Activity.Title = \"Production Data\"";
Debug.ShouldStop(536870912);
lazyloadingpage.mostCurrent._activity.runMethod(false,"setTitle",BA.ObjectToCharSequence("Production Data"));
 BA.debugLineNum = 31;BA.debugLine="If lstOfProduction.IsInitialized = False Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",lazyloadingpage.mostCurrent._lstofproduction.runMethod(true,"IsInitialized"),lazyloadingpage.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 32;BA.debugLine="ProgressDialogShow2(\"Production data loading...\"";
Debug.ShouldStop(-2147483648);
lazyloadingpage.mostCurrent.__c.runVoidMethod ("ProgressDialogShow2",lazyloadingpage.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence("Production data loading...")),(Object)(lazyloadingpage.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 33;BA.debugLine="sendQueryIntent(\"\")";
Debug.ShouldStop(1);
_sendqueryintent(RemoteObject.createImmutable(""));
 };
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (lazyloadingpage) ","lazyloadingpage",2,lazyloadingpage.mostCurrent.activityBA,lazyloadingpage.mostCurrent,42);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.lazyloadingpage.remoteMe.runUserSub(false, "lazyloadingpage","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 42;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(512);
 BA.debugLineNum = 44;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (lazyloadingpage) ","lazyloadingpage",2,lazyloadingpage.mostCurrent.activityBA,lazyloadingpage.mostCurrent,38);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.lazyloadingpage.remoteMe.runUserSub(false, "lazyloadingpage","activity_resume");}
 BA.debugLineNum = 38;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(32);
 BA.debugLineNum = 40;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _clv1_visiblerangechanged(RemoteObject _firstindex,RemoteObject _lastindex) throws Exception{
try {
		Debug.PushSubsStack("CLV1_VisibleRangeChanged (lazyloadingpage) ","lazyloadingpage",2,lazyloadingpage.mostCurrent.activityBA,lazyloadingpage.mostCurrent,79);
if (RapidSub.canDelegate("clv1_visiblerangechanged")) { return b4a.example.lazyloadingpage.remoteMe.runUserSub(false, "lazyloadingpage","clv1_visiblerangechanged", _firstindex, _lastindex);}
RemoteObject _extrasize = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _cd = RemoteObject.declareNull("b4a.example.starter._carddata");
Debug.locals.put("FirstIndex", _firstindex);
Debug.locals.put("LastIndex", _lastindex);
 BA.debugLineNum = 79;BA.debugLine="Sub CLV1_VisibleRangeChanged (FirstIndex As Int, L";
Debug.ShouldStop(16384);
 BA.debugLineNum = 80;BA.debugLine="Dim ExtraSize As Int = 20";
Debug.ShouldStop(32768);
_extrasize = BA.numberCast(int.class, 20);Debug.locals.put("ExtraSize", _extrasize);Debug.locals.put("ExtraSize", _extrasize);
 BA.debugLineNum = 81;BA.debugLine="For i = Max(0, FirstIndex - ExtraSize) To Min(Las";
Debug.ShouldStop(65536);
{
final int step2 = 1;
final int limit2 = (int) (0 + lazyloadingpage.mostCurrent.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_lastindex,_extrasize}, "+",1, 1))),(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {lazyloadingpage.mostCurrent._clv1.runMethod(true,"_getsize"),RemoteObject.createImmutable(1)}, "-",1, 1)))).<Double>get().doubleValue());
_i = (int) (0 + lazyloadingpage.mostCurrent.__c.runMethod(true,"Max",(Object)(BA.numberCast(double.class, 0)),(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_firstindex,_extrasize}, "-",1, 1)))).<Double>get().doubleValue()) ;
for (;(step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2) ;_i = ((int)(0 + _i + step2))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 82;BA.debugLine="Dim p As B4XView = CLV1.GetPanel(i)";
Debug.ShouldStop(131072);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_p = lazyloadingpage.mostCurrent._clv1.runMethod(false,"_getpanel",(Object)(BA.numberCast(int.class, _i)));Debug.locals.put("p", _p);Debug.locals.put("p", _p);
 BA.debugLineNum = 83;BA.debugLine="If p.NumberOfViews = 0 Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",_p.runMethod(true,"getNumberOfViews"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 84;BA.debugLine="Dim cd As CardData = CLV1.GetValue(i)";
Debug.ShouldStop(524288);
_cd = (lazyloadingpage.mostCurrent._clv1.runMethod(false,"_getvalue",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("cd", _cd);Debug.locals.put("cd", _cd);
 BA.debugLineNum = 86;BA.debugLine="p.LoadLayout(\"Card1\")";
Debug.ShouldStop(2097152);
_p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("Card1")),lazyloadingpage.mostCurrent.activityBA);
 BA.debugLineNum = 87;BA.debugLine="lblTitle.Text = cd.Title";
Debug.ShouldStop(4194304);
lazyloadingpage.mostCurrent._lbltitle.runMethod(true,"setText",BA.ObjectToCharSequence(_cd.getField(true,"Title" /*RemoteObject*/ )));
 BA.debugLineNum = 88;BA.debugLine="lblContent.Text = cd.Content";
Debug.ShouldStop(8388608);
lazyloadingpage.mostCurrent._lblcontent.runMethod(true,"setText",BA.ObjectToCharSequence(_cd.getField(true,"Content" /*RemoteObject*/ )));
 BA.debugLineNum = 89;BA.debugLine="SetColorStateList(lblAction1, xui.Color_LightGr";
Debug.ShouldStop(16777216);
_setcolorstatelist(lazyloadingpage.mostCurrent._lblaction1,lazyloadingpage._xui.getField(true,"Color_LightGray"),lazyloadingpage.mostCurrent._lblaction1.runMethod(true,"getTextColor"));
 BA.debugLineNum = 90;BA.debugLine="SetColorStateList(lblAction2, xui.Color_LightGr";
Debug.ShouldStop(33554432);
_setcolorstatelist(lazyloadingpage.mostCurrent._lblaction2,lazyloadingpage._xui.getField(true,"Color_LightGray"),lazyloadingpage.mostCurrent._lblaction2.runMethod(true,"getTextColor"));
 BA.debugLineNum = 91;BA.debugLine="ImageView1.SetBitmap(xui.LoadBitmapResize(File.";
Debug.ShouldStop(67108864);
lazyloadingpage.mostCurrent._imageview1.runVoidMethod ("SetBitmap",(Object)((lazyloadingpage._xui.runMethod(false,"LoadBitmapResize",(Object)(lazyloadingpage.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(_cd.getField(true,"BitmapFile" /*RemoteObject*/ )),(Object)(lazyloadingpage.mostCurrent._imageview1.runMethod(true,"getWidth")),(Object)(lazyloadingpage.mostCurrent._imageview1.runMethod(true,"getHeight")),(Object)(lazyloadingpage.mostCurrent.__c.getField(true,"True"))).getObject())));
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _filllist2() throws Exception{
try {
		Debug.PushSubsStack("FillList2 (lazyloadingpage) ","lazyloadingpage",2,lazyloadingpage.mostCurrent.activityBA,lazyloadingpage.mostCurrent,58);
if (RapidSub.canDelegate("filllist2")) { return b4a.example.lazyloadingpage.remoteMe.runUserSub(false, "lazyloadingpage","filllist2");}
RemoteObject _bitmaps = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _n = RemoteObject.createImmutable(0L);
int _i = 0;
RemoteObject _content = RemoteObject.createImmutable("");
RemoteObject _cd = RemoteObject.declareNull("b4a.example.starter._carddata");
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
 BA.debugLineNum = 58;BA.debugLine="Sub FillList2";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 59;BA.debugLine="Dim bitmaps As List = Array(\"pexels-photo-446811.";
Debug.ShouldStop(67108864);
_bitmaps = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_bitmaps = lazyloadingpage.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {4},new Object[] {RemoteObject.createImmutable(("pexels-photo-446811.jpeg")),RemoteObject.createImmutable(("pexels-photo-571195.jpeg")),RemoteObject.createImmutable(("pexels-photo-736212.jpeg")),(RemoteObject.createImmutable("pexels-photo-592798.jpeg"))})));Debug.locals.put("bitmaps", _bitmaps);Debug.locals.put("bitmaps", _bitmaps);
 BA.debugLineNum = 61;BA.debugLine="Dim n As Long = DateTime.Now";
Debug.ShouldStop(268435456);
_n = lazyloadingpage.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow");Debug.locals.put("n", _n);Debug.locals.put("n", _n);
 BA.debugLineNum = 62;BA.debugLine="For i = 1 To 1000";
Debug.ShouldStop(536870912);
{
final int step3 = 1;
final int limit3 = 1000;
_i = 1 ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((int)(0 + _i + step3))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 63;BA.debugLine="Dim content As String = $\"Lorem ipsum dolor sit";
Debug.ShouldStop(1073741824);
_content = (RemoteObject.concat(RemoteObject.createImmutable("Lorem ipsum dolor sit amet,\n"),RemoteObject.createImmutable("			consectetur adipiscing elit,\n"),RemoteObject.createImmutable("			sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n"),RemoteObject.createImmutable("			Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.")));Debug.locals.put("content", _content);Debug.locals.put("content", _content);
 BA.debugLineNum = 67;BA.debugLine="Dim cd As CardData";
Debug.ShouldStop(4);
_cd = RemoteObject.createNew ("b4a.example.starter._carddata");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 68;BA.debugLine="cd.Initialize";
Debug.ShouldStop(8);
_cd.runVoidMethod ("Initialize");
 BA.debugLineNum = 69;BA.debugLine="cd.Title = $\"This is item #${i}\"$";
Debug.ShouldStop(16);
_cd.setField ("Title" /*RemoteObject*/ ,(RemoteObject.concat(RemoteObject.createImmutable("This is item #"),lazyloadingpage.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)(RemoteObject.createImmutable((_i)))),RemoteObject.createImmutable(""))));
 BA.debugLineNum = 70;BA.debugLine="cd.Content = content";
Debug.ShouldStop(32);
_cd.setField ("Content" /*RemoteObject*/ ,_content);
 BA.debugLineNum = 71;BA.debugLine="cd.BitmapFile = bitmaps.Get((i - 1) Mod bitmaps.";
Debug.ShouldStop(64);
_cd.setField ("BitmapFile" /*RemoteObject*/ ,BA.ObjectToString(_bitmaps.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "-",1, 1)),_bitmaps.runMethod(true,"getSize")}, "%",0, 1)))));
 BA.debugLineNum = 72;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
Debug.ShouldStop(128);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_p = lazyloadingpage._xui.runMethod(false,"CreatePanel",lazyloadingpage.processBA,(Object)(RemoteObject.createImmutable("")));Debug.locals.put("p", _p);Debug.locals.put("p", _p);
 BA.debugLineNum = 73;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, CLV1.AsView.Width,";
Debug.ShouldStop(256);
_p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(lazyloadingpage.mostCurrent._clv1.runMethod(false,"_asview").runMethod(true,"getWidth")),(Object)(lazyloadingpage.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 280)))));
 BA.debugLineNum = 74;BA.debugLine="CLV1.Add(p, cd)";
Debug.ShouldStop(512);
lazyloadingpage.mostCurrent._clv1.runVoidMethod ("_add",(Object)(_p),(Object)((_cd)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 76;BA.debugLine="Log(\"Loading cards took: \" & (DateTime.Now - n) &";
Debug.ShouldStop(2048);
lazyloadingpage.mostCurrent.__c.runVoidMethod ("LogImpl","21638418",RemoteObject.concat(RemoteObject.createImmutable("Loading cards took: "),(RemoteObject.solve(new RemoteObject[] {lazyloadingpage.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"),_n}, "-",1, 2)),RemoteObject.createImmutable("ms")),0);
 BA.debugLineNum = 77;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getnowdatecode() throws Exception{
try {
		Debug.PushSubsStack("getNowDateCode (lazyloadingpage) ","lazyloadingpage",2,lazyloadingpage.mostCurrent.activityBA,lazyloadingpage.mostCurrent,129);
if (RapidSub.canDelegate("getnowdatecode")) { return b4a.example.lazyloadingpage.remoteMe.runUserSub(false, "lazyloadingpage","getnowdatecode");}
RemoteObject _dtnow = RemoteObject.createImmutable(0L);
RemoteObject _df = RemoteObject.createImmutable("");
RemoteObject _daycode = RemoteObject.createImmutable("");
 BA.debugLineNum = 129;BA.debugLine="Private Sub getNowDateCode() As String";
Debug.ShouldStop(1);
 BA.debugLineNum = 130;BA.debugLine="Dim dtNow As Long = DateTime.Now";
Debug.ShouldStop(2);
_dtnow = lazyloadingpage.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow");Debug.locals.put("dtNow", _dtnow);Debug.locals.put("dtNow", _dtnow);
 BA.debugLineNum = 132;BA.debugLine="Dim df As String = DateTime.DateFormat";
Debug.ShouldStop(8);
_df = lazyloadingpage.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getDateFormat");Debug.locals.put("df", _df);Debug.locals.put("df", _df);
 BA.debugLineNum = 133;BA.debugLine="DateTime.DateFormat = \"yyyyMMdd\"";
Debug.ShouldStop(16);
lazyloadingpage.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("yyyyMMdd"));
 BA.debugLineNum = 134;BA.debugLine="Dim daycode As String";
Debug.ShouldStop(32);
_daycode = RemoteObject.createImmutable("");Debug.locals.put("daycode", _daycode);
 BA.debugLineNum = 135;BA.debugLine="Try";
Debug.ShouldStop(64);
try { BA.debugLineNum = 136;BA.debugLine="daycode = DateTime.Date(dtNow)";
Debug.ShouldStop(128);
_daycode = lazyloadingpage.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(_dtnow));Debug.locals.put("daycode", _daycode);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",lazyloadingpage.processBA, e8.toString()); BA.debugLineNum = 138;BA.debugLine="Log(LastException)";
Debug.ShouldStop(512);
lazyloadingpage.mostCurrent.__c.runVoidMethod ("LogImpl","22031625",BA.ObjectToString(lazyloadingpage.mostCurrent.__c.runMethod(false,"LastException",lazyloadingpage.mostCurrent.activityBA)),0);
 BA.debugLineNum = 139;BA.debugLine="daycode = \"\"";
Debug.ShouldStop(1024);
_daycode = BA.ObjectToString("");Debug.locals.put("daycode", _daycode);
 };
 BA.debugLineNum = 142;BA.debugLine="DateTime.DateFormat = df";
Debug.ShouldStop(8192);
lazyloadingpage.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",_df);
 BA.debugLineNum = 143;BA.debugLine="Return daycode";
Debug.ShouldStop(16384);
if (true) return _daycode;
 BA.debugLineNum = 144;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getqueryresponse(RemoteObject _mapres) throws Exception{
try {
		Debug.PushSubsStack("getQueryResponse (lazyloadingpage) ","lazyloadingpage",2,lazyloadingpage.mostCurrent.activityBA,lazyloadingpage.mostCurrent,46);
if (RapidSub.canDelegate("getqueryresponse")) { return b4a.example.lazyloadingpage.remoteMe.runUserSub(false, "lazyloadingpage","getqueryresponse", _mapres);}
Debug.locals.put("mapRes", _mapres);
 BA.debugLineNum = 46;BA.debugLine="Private Sub getQueryResponse(mapRes As Map)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 47;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(16384);
lazyloadingpage.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 48;BA.debugLine="If mapRes.IsInitialized = False Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_mapres.runMethod(true,"IsInitialized"),lazyloadingpage.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 49;BA.debugLine="Return";
Debug.ShouldStop(65536);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 51;BA.debugLine="If mapRes.Get(\"issuccess\").As(Boolean) = False Th";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",(BA.ObjectToBoolean(_mapres.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("issuccess")))))),lazyloadingpage.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 52;BA.debugLine="Msgbox2Async(mapRes.Get(\"errmsg\"), \"Query Error\"";
Debug.ShouldStop(524288);
lazyloadingpage.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence(_mapres.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("errmsg")))))),(Object)(BA.ObjectToCharSequence("Query Error")),(Object)(BA.ObjectToString("OK")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), lazyloadingpage.mostCurrent.__c.getField(false,"Null")),lazyloadingpage.processBA,(Object)(lazyloadingpage.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 53;BA.debugLine="Return";
Debug.ShouldStop(1048576);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 55;BA.debugLine="lstOfProduction = mapRes.Get(\"datalist\").As(List)";
Debug.ShouldStop(4194304);
lazyloadingpage.mostCurrent._lstofproduction = (RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), _mapres.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("datalist"))))));
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 17;BA.debugLine="Private CLV1 As CustomListView";
lazyloadingpage.mostCurrent._clv1 = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 18;BA.debugLine="Private ImageView1 As B4XView";
lazyloadingpage.mostCurrent._imageview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private lblTitle As B4XView";
lazyloadingpage.mostCurrent._lbltitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private lblContent As B4XView";
lazyloadingpage.mostCurrent._lblcontent = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private lblAction1 As Label";
lazyloadingpage.mostCurrent._lblaction1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private lblAction2 As Label";
lazyloadingpage.mostCurrent._lblaction2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private lstOfProduction As List";
lazyloadingpage.mostCurrent._lstofproduction = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lblaction1_click() throws Exception{
try {
		Debug.PushSubsStack("lblAction1_Click (lazyloadingpage) ","lazyloadingpage",2,lazyloadingpage.mostCurrent.activityBA,lazyloadingpage.mostCurrent,96);
if (RapidSub.canDelegate("lblaction1_click")) { return b4a.example.lazyloadingpage.remoteMe.runUserSub(false, "lazyloadingpage","lblaction1_click");}
RemoteObject _index = RemoteObject.createImmutable(0);
 BA.debugLineNum = 96;BA.debugLine="Sub lblAction1_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 97;BA.debugLine="Dim index As Int = CLV1.GetItemFromView(Sender)";
Debug.ShouldStop(1);
_index = lazyloadingpage.mostCurrent._clv1.runMethod(true,"_getitemfromview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), lazyloadingpage.mostCurrent.__c.runMethod(false,"Sender",lazyloadingpage.mostCurrent.activityBA)));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 98;BA.debugLine="Log($\"Action 1 clicked. Index: ${index}\"$)";
Debug.ShouldStop(2);
lazyloadingpage.mostCurrent.__c.runVoidMethod ("LogImpl","21769474",(RemoteObject.concat(RemoteObject.createImmutable("Action 1 clicked. Index: "),lazyloadingpage.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_index))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 99;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lblaction2_click() throws Exception{
try {
		Debug.PushSubsStack("lblAction2_Click (lazyloadingpage) ","lazyloadingpage",2,lazyloadingpage.mostCurrent.activityBA,lazyloadingpage.mostCurrent,101);
if (RapidSub.canDelegate("lblaction2_click")) { return b4a.example.lazyloadingpage.remoteMe.runUserSub(false, "lazyloadingpage","lblaction2_click");}
RemoteObject _index = RemoteObject.createImmutable(0);
 BA.debugLineNum = 101;BA.debugLine="Sub lblAction2_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 102;BA.debugLine="Dim index As Int = CLV1.GetItemFromView(Sender)";
Debug.ShouldStop(32);
_index = lazyloadingpage.mostCurrent._clv1.runMethod(true,"_getitemfromview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), lazyloadingpage.mostCurrent.__c.runMethod(false,"Sender",lazyloadingpage.mostCurrent.activityBA)));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 103;BA.debugLine="Log($\"Action 2 clicked. Index: ${index}\"$)";
Debug.ShouldStop(64);
lazyloadingpage.mostCurrent.__c.runVoidMethod ("LogImpl","21835010",(RemoteObject.concat(RemoteObject.createImmutable("Action 2 clicked. Index: "),lazyloadingpage.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_index))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 104;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
 //BA.debugLineNum = 10;BA.debugLine="Private xui As XUI";
lazyloadingpage._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _sendqueryintent(RemoteObject _datecode) throws Exception{
try {
		Debug.PushSubsStack("sendQueryIntent (lazyloadingpage) ","lazyloadingpage",2,lazyloadingpage.mostCurrent.activityBA,lazyloadingpage.mostCurrent,116);
if (RapidSub.canDelegate("sendqueryintent")) { return b4a.example.lazyloadingpage.remoteMe.runUserSub(false, "lazyloadingpage","sendqueryintent", _datecode);}
RemoteObject _inte = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
Debug.locals.put("datecode", _datecode);
 BA.debugLineNum = 116;BA.debugLine="Private Sub sendQueryIntent(datecode As String)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 117;BA.debugLine="If datecode = \"\" Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",_datecode,BA.ObjectToString(""))) { 
 BA.debugLineNum = 118;BA.debugLine="datecode = getNowDateCode";
Debug.ShouldStop(2097152);
_datecode = _getnowdatecode();Debug.locals.put("datecode", _datecode);
 };
 BA.debugLineNum = 120;BA.debugLine="Dim inte As Intent";
Debug.ShouldStop(8388608);
_inte = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("inte", _inte);
 BA.debugLineNum = 121;BA.debugLine="inte.Initialize(\"\", \"\")";
Debug.ShouldStop(16777216);
_inte.runVoidMethod ("Initialize",(Object)(BA.ObjectToString("")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 122;BA.debugLine="inte.SetComponent(Application.PackageName & \"/.sv";
Debug.ShouldStop(33554432);
_inte.runVoidMethod ("SetComponent",(Object)(RemoteObject.concat(lazyloadingpage.mostCurrent.__c.getField(false,"Application").runMethod(true,"getPackageName"),RemoteObject.createImmutable("/.svcproduction"))));
 BA.debugLineNum = 123;BA.debugLine="inte.PutExtra(\"sender\", \"LazyLoadingPage\")";
Debug.ShouldStop(67108864);
_inte.runVoidMethod ("PutExtra",(Object)(BA.ObjectToString("sender")),(Object)((RemoteObject.createImmutable("LazyLoadingPage"))));
 BA.debugLineNum = 124;BA.debugLine="inte.PutExtra(\"task\", \"query\")";
Debug.ShouldStop(134217728);
_inte.runVoidMethod ("PutExtra",(Object)(BA.ObjectToString("task")),(Object)((RemoteObject.createImmutable("query"))));
 BA.debugLineNum = 125;BA.debugLine="inte.PutExtra(\"param\", datecode)";
Debug.ShouldStop(268435456);
_inte.runVoidMethod ("PutExtra",(Object)(BA.ObjectToString("param")),(Object)((_datecode)));
 BA.debugLineNum = 126;BA.debugLine="StartService(inte)";
Debug.ShouldStop(536870912);
lazyloadingpage.mostCurrent.__c.runVoidMethod ("StartService",lazyloadingpage.processBA,(Object)((_inte.getObject())));
 BA.debugLineNum = 127;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setcolorstatelist(RemoteObject _btn,RemoteObject _pressed,RemoteObject _enabled) throws Exception{
try {
		Debug.PushSubsStack("SetColorStateList (lazyloadingpage) ","lazyloadingpage",2,lazyloadingpage.mostCurrent.activityBA,lazyloadingpage.mostCurrent,106);
if (RapidSub.canDelegate("setcolorstatelist")) { return b4a.example.lazyloadingpage.remoteMe.runUserSub(false, "lazyloadingpage","setcolorstatelist", _btn, _pressed, _enabled);}
RemoteObject _states = null;
RemoteObject _csl = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _b1 = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("Btn", _btn);
Debug.locals.put("Pressed", _pressed);
Debug.locals.put("Enabled", _enabled);
 BA.debugLineNum = 106;BA.debugLine="Sub SetColorStateList(Btn As Label,Pressed As Int,";
Debug.ShouldStop(512);
 BA.debugLineNum = 107;BA.debugLine="Dim States(2,1) As Int";
Debug.ShouldStop(1024);
_states = RemoteObject.createNewArray ("int", new int[] {2,1}, new Object[]{});Debug.locals.put("States", _states);
 BA.debugLineNum = 108;BA.debugLine="States(0,0) = 16842919    'Pressed";
Debug.ShouldStop(2048);
_states.setArrayElement (BA.numberCast(int.class, 16842919),BA.numberCast(int.class, 0),BA.numberCast(int.class, 0));
 BA.debugLineNum = 109;BA.debugLine="States(1,0) = 16842910    'Enabled";
Debug.ShouldStop(4096);
_states.setArrayElement (BA.numberCast(int.class, 16842910),BA.numberCast(int.class, 1),BA.numberCast(int.class, 0));
 BA.debugLineNum = 110;BA.debugLine="Dim CSL As JavaObject";
Debug.ShouldStop(8192);
_csl = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("CSL", _csl);
 BA.debugLineNum = 111;BA.debugLine="CSL.InitializeNewInstance(\"android.content.res.Co";
Debug.ShouldStop(16384);
_csl.runVoidMethod ("InitializeNewInstance",(Object)(BA.ObjectToString("android.content.res.ColorStateList")),(Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(_states),(RemoteObject.createNewArray("int",new int[] {2},new Object[] {_pressed,_enabled}))})));
 BA.debugLineNum = 112;BA.debugLine="Dim B1 As JavaObject = Btn";
Debug.ShouldStop(32768);
_b1 = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_b1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), _btn.getObject());Debug.locals.put("B1", _b1);Debug.locals.put("B1", _b1);
 BA.debugLineNum = 113;BA.debugLine="B1.RunMethod(\"setTextColor\",Array As Object(CSL))";
Debug.ShouldStop(65536);
_b1.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setTextColor")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_csl.getObject())})));
 BA.debugLineNum = 114;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}