package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,31);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 34;BA.debugLine="Activity.LoadLayout(\"1\")";
Debug.ShouldStop(2);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("1")),main.mostCurrent.activityBA);
 BA.debugLineNum = 35;BA.debugLine="Activity.AddMenuItem3(\"\", \"refresh\", xui.LoadBitm";
Debug.ShouldStop(4);
main.mostCurrent._activity.runVoidMethod ("AddMenuItem3",(Object)(BA.ObjectToCharSequence("")),(Object)(BA.ObjectToString("refresh")),(Object)((main._xui.runMethod(false,"LoadBitmapResize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("ic_cached_white_24dp.png")),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 32)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 32)))),(Object)(main.mostCurrent.__c.getField(true,"True"))).getObject())),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 36;BA.debugLine="Activity.AddMenuItem3(\"\", \"done\", xui.LoadBitmapR";
Debug.ShouldStop(8);
main.mostCurrent._activity.runVoidMethod ("AddMenuItem3",(Object)(BA.ObjectToCharSequence("")),(Object)(BA.ObjectToString("done")),(Object)((main._xui.runMethod(false,"LoadBitmapResize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("ic_done_white_24dp.png")),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 32)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 32)))),(Object)(main.mostCurrent.__c.getField(true,"True"))).getObject())),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 37;BA.debugLine="Activity.AddMenuItem(\"Next\", \"Next\")";
Debug.ShouldStop(16);
main.mostCurrent._activity.runVoidMethod ("AddMenuItem",(Object)(BA.ObjectToCharSequence("Next")),(Object)(RemoteObject.createImmutable("Next")));
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,50);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 50;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 52;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,41);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 41;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(256);
 BA.debugLineNum = 42;BA.debugLine="If CLV1.IsInitialized = False Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",main.mostCurrent._clv1.runMethod(true,"IsInitialized"),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 43;BA.debugLine="Return";
Debug.ShouldStop(1024);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 45;BA.debugLine="If CLV1.Size =  0 Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",main.mostCurrent._clv1.runMethod(true,"_getsize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 46;BA.debugLine="fillTheData";
Debug.ShouldStop(8192);
_fillthedata();
 };
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button1_click() throws Exception{
try {
		Debug.PushSubsStack("Button1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,73);
if (RapidSub.canDelegate("button1_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button1_click");}
 BA.debugLineNum = 73;BA.debugLine="Sub Button1_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 74;BA.debugLine="xui.MsgboxAsync(\"Hello world!\", \"B4X\")";
Debug.ShouldStop(512);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("Hello world!")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("B4X"))));
 BA.debugLineNum = 75;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("CLV1_VisibleRangeChanged (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,96);
if (RapidSub.canDelegate("clv1_visiblerangechanged")) { return b4a.example.main.remoteMe.runUserSub(false, "main","clv1_visiblerangechanged", _firstindex, _lastindex);}
RemoteObject _extrasize = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _cd = RemoteObject.declareNull("b4a.example.starter._carddata");
Debug.locals.put("FirstIndex", _firstindex);
Debug.locals.put("LastIndex", _lastindex);
 BA.debugLineNum = 96;BA.debugLine="Sub CLV1_VisibleRangeChanged (FirstIndex As Int, L";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 97;BA.debugLine="Dim ExtraSize As Int = 20";
Debug.ShouldStop(1);
_extrasize = BA.numberCast(int.class, 20);Debug.locals.put("ExtraSize", _extrasize);Debug.locals.put("ExtraSize", _extrasize);
 BA.debugLineNum = 98;BA.debugLine="For i = 0 To CLV1.Size - 1";
Debug.ShouldStop(2);
{
final int step2 = 1;
final int limit2 = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._clv1.runMethod(true,"_getsize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2) ;_i = ((int)(0 + _i + step2))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 99;BA.debugLine="Dim p As B4XView = CLV1.GetPanel(i)";
Debug.ShouldStop(4);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_p = main.mostCurrent._clv1.runMethod(false,"_getpanel",(Object)(BA.numberCast(int.class, _i)));Debug.locals.put("p", _p);Debug.locals.put("p", _p);
 BA.debugLineNum = 100;BA.debugLine="If i > FirstIndex - ExtraSize And i < LastIndex";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean(">",RemoteObject.createImmutable(_i),BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_firstindex,_extrasize}, "-",1, 1))) && RemoteObject.solveBoolean("<",RemoteObject.createImmutable(_i),BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_lastindex,_extrasize}, "+",1, 1)))) { 
 BA.debugLineNum = 102;BA.debugLine="If p.NumberOfViews = 0 Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_p.runMethod(true,"getNumberOfViews"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 103;BA.debugLine="Dim cd As CardData = CLV1.GetValue(i)";
Debug.ShouldStop(64);
_cd = (main.mostCurrent._clv1.runMethod(false,"_getvalue",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("cd", _cd);Debug.locals.put("cd", _cd);
 BA.debugLineNum = 104;BA.debugLine="p.LoadLayout(\"Card1\")";
Debug.ShouldStop(128);
_p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("Card1")),main.mostCurrent.activityBA);
 BA.debugLineNum = 105;BA.debugLine="lblTitle.Text = cd.Title";
Debug.ShouldStop(256);
main.mostCurrent._lbltitle.runMethod(true,"setText",BA.ObjectToCharSequence(_cd.getField(true,"Title" /*RemoteObject*/ )));
 BA.debugLineNum = 106;BA.debugLine="lblContent.Text = cd.Content";
Debug.ShouldStop(512);
main.mostCurrent._lblcontent.runMethod(true,"setText",BA.ObjectToCharSequence(_cd.getField(true,"Content" /*RemoteObject*/ )));
 BA.debugLineNum = 107;BA.debugLine="SetColorStateList(lblAction1, xui.Color_LightG";
Debug.ShouldStop(1024);
_setcolorstatelist(main.mostCurrent._lblaction1,main._xui.getField(true,"Color_LightGray"),main.mostCurrent._lblaction1.runMethod(true,"getTextColor"));
 BA.debugLineNum = 108;BA.debugLine="SetColorStateList(lblAction2, xui.Color_LightG";
Debug.ShouldStop(2048);
_setcolorstatelist(main.mostCurrent._lblaction2,main._xui.getField(true,"Color_LightGray"),main.mostCurrent._lblaction2.runMethod(true,"getTextColor"));
 BA.debugLineNum = 109;BA.debugLine="ImageView1.SetBitmap(xui.LoadBitmapResize(File";
Debug.ShouldStop(4096);
main.mostCurrent._imageview1.runVoidMethod ("SetBitmap",(Object)((main._xui.runMethod(false,"LoadBitmapResize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(_cd.getField(true,"BitmapFile" /*RemoteObject*/ )),(Object)(main.mostCurrent._imageview1.runMethod(true,"getWidth")),(Object)(main.mostCurrent._imageview1.runMethod(true,"getHeight")),(Object)(main.mostCurrent.__c.getField(true,"True"))).getObject())));
 };
 }else {
 BA.debugLineNum = 113;BA.debugLine="If p.NumberOfViews > 0 Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean(">",_p.runMethod(true,"getNumberOfViews"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 114;BA.debugLine="p.RemoveAllViews '<--- remove the layout";
Debug.ShouldStop(131072);
_p.runVoidMethod ("RemoveAllViews");
 };
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 118;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createitem(RemoteObject _width,RemoteObject _title,RemoteObject _image,RemoteObject _content) throws Exception{
try {
		Debug.PushSubsStack("CreateItem (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,81);
if (RapidSub.canDelegate("createitem")) { return b4a.example.main.remoteMe.runUserSub(false, "main","createitem", _width, _title, _image, _content);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _height = RemoteObject.createImmutable(0);
Debug.locals.put("Width", _width);
Debug.locals.put("Title", _title);
Debug.locals.put("Image", _image);
Debug.locals.put("Content", _content);
 BA.debugLineNum = 81;BA.debugLine="Private Sub CreateItem(Width As Int, Title As Stri";
Debug.ShouldStop(65536);
 BA.debugLineNum = 82;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
Debug.ShouldStop(131072);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_p = main._xui.runMethod(false,"CreatePanel",main.processBA,(Object)(RemoteObject.createImmutable("")));Debug.locals.put("p", _p);Debug.locals.put("p", _p);
 BA.debugLineNum = 83;BA.debugLine="Dim height As Int = 280dip";
Debug.ShouldStop(262144);
_height = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 280)));Debug.locals.put("height", _height);Debug.locals.put("height", _height);
 BA.debugLineNum = 84;BA.debugLine="If GetDeviceLayoutValues.ApproximateScreenSize <";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("<",main.mostCurrent.__c.runMethod(false,"GetDeviceLayoutValues",main.mostCurrent.activityBA).runMethod(true,"getApproximateScreenSize"),BA.numberCast(double.class, 4.5))) { 
_height = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 310)));Debug.locals.put("height", _height);};
 BA.debugLineNum = 85;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, Width, height)";
Debug.ShouldStop(1048576);
_p.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_width),(Object)(_height));
 BA.debugLineNum = 86;BA.debugLine="p.LoadLayout(\"Card1\")";
Debug.ShouldStop(2097152);
_p.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("Card1")),main.mostCurrent.activityBA);
 BA.debugLineNum = 88;BA.debugLine="lblTitle.Text = Title";
Debug.ShouldStop(8388608);
main.mostCurrent._lbltitle.runMethod(true,"setText",BA.ObjectToCharSequence(_title));
 BA.debugLineNum = 89;BA.debugLine="lblContent.Text = Content";
Debug.ShouldStop(16777216);
main.mostCurrent._lblcontent.runMethod(true,"setText",BA.ObjectToCharSequence(_content));
 BA.debugLineNum = 90;BA.debugLine="SetColorStateList(lblAction1, xui.Color_LightGray";
Debug.ShouldStop(33554432);
_setcolorstatelist(main.mostCurrent._lblaction1,main._xui.getField(true,"Color_LightGray"),main.mostCurrent._lblaction1.runMethod(true,"getTextColor"));
 BA.debugLineNum = 91;BA.debugLine="SetColorStateList(lblAction2, xui.Color_LightGray";
Debug.ShouldStop(67108864);
_setcolorstatelist(main.mostCurrent._lblaction2,main._xui.getField(true,"Color_LightGray"),main.mostCurrent._lblaction2.runMethod(true,"getTextColor"));
 BA.debugLineNum = 92;BA.debugLine="ImageView1.SetBitmap(xui.LoadBitmapResize(File.Di";
Debug.ShouldStop(134217728);
main.mostCurrent._imageview1.runVoidMethod ("SetBitmap",(Object)((main._xui.runMethod(false,"LoadBitmapResize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(_image),(Object)(main.mostCurrent._imageview1.runMethod(true,"getWidth")),(Object)(main.mostCurrent._imageview1.runMethod(true,"getHeight")),(Object)(main.mostCurrent.__c.getField(true,"True"))).getObject())));
 BA.debugLineNum = 93;BA.debugLine="Return p";
Debug.ShouldStop(268435456);
if (true) return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), _p.getObject());
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _fillthedata() throws Exception{
try {
		Debug.PushSubsStack("fillTheData (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,54);
if (RapidSub.canDelegate("fillthedata")) { return b4a.example.main.remoteMe.runUserSub(false, "main","fillthedata");}
RemoteObject _bitmaps = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
RemoteObject _content = RemoteObject.createImmutable("");
RemoteObject _idx = RemoteObject.createImmutable(0);
RemoteObject _cd = RemoteObject.declareNull("b4a.example.starter._carddata");
 BA.debugLineNum = 54;BA.debugLine="Sub fillTheData()";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 56;BA.debugLine="Dim bitmaps As List = Array(\"pexels-photo-446811.";
Debug.ShouldStop(8388608);
_bitmaps = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_bitmaps = main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {4},new Object[] {RemoteObject.createImmutable(("pexels-photo-446811.jpeg")),RemoteObject.createImmutable(("pexels-photo-571195.jpeg")),RemoteObject.createImmutable(("pexels-photo-736212.jpeg")),(RemoteObject.createImmutable("pexels-photo-592798.jpeg"))})));Debug.locals.put("bitmaps", _bitmaps);Debug.locals.put("bitmaps", _bitmaps);
 BA.debugLineNum = 58;BA.debugLine="For i = 0 To 100";
Debug.ShouldStop(33554432);
{
final int step2 = 1;
final int limit2 = 100;
_i = 0 ;
for (;(step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2) ;_i = ((int)(0 + _i + step2))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 59;BA.debugLine="Dim content As String = $\"Lorem ipsum dolor sit";
Debug.ShouldStop(67108864);
_content = (RemoteObject.concat(RemoteObject.createImmutable("Lorem ipsum dolor sit amet,\n"),RemoteObject.createImmutable("			consectetur adipiscing elit, \n"),RemoteObject.createImmutable("			sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \n"),RemoteObject.createImmutable("			Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.")));Debug.locals.put("content", _content);Debug.locals.put("content", _content);
 BA.debugLineNum = 63;BA.debugLine="Dim idx As Int = i Mod bitmaps.Size";
Debug.ShouldStop(1073741824);
_idx = RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),_bitmaps.runMethod(true,"getSize")}, "%",0, 1);Debug.locals.put("idx", _idx);Debug.locals.put("idx", _idx);
 BA.debugLineNum = 64;BA.debugLine="Dim cd As CardData";
Debug.ShouldStop(-2147483648);
_cd = RemoteObject.createNew ("b4a.example.starter._carddata");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 65;BA.debugLine="cd.Initialize";
Debug.ShouldStop(1);
_cd.runVoidMethod ("Initialize");
 BA.debugLineNum = 66;BA.debugLine="cd.Title = $\"This is item #${i}\"$";
Debug.ShouldStop(2);
_cd.setField ("Title" /*RemoteObject*/ ,(RemoteObject.concat(RemoteObject.createImmutable("This is item #"),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)(RemoteObject.createImmutable((_i)))),RemoteObject.createImmutable(""))));
 BA.debugLineNum = 67;BA.debugLine="cd.Content = content";
Debug.ShouldStop(4);
_cd.setField ("Content" /*RemoteObject*/ ,_content);
 BA.debugLineNum = 68;BA.debugLine="cd.BitmapFile = bitmaps.Get(idx)";
Debug.ShouldStop(8);
_cd.setField ("BitmapFile" /*RemoteObject*/ ,BA.ObjectToString(_bitmaps.runMethod(false,"Get",(Object)(_idx))));
 BA.debugLineNum = 69;BA.debugLine="CLV1.Add(CreateItem(CLV1.AsView.Width, $\"This is";
Debug.ShouldStop(16);
main.mostCurrent._clv1.runVoidMethod ("_add",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _createitem(main.mostCurrent._clv1.runMethod(false,"_asview").runMethod(true,"getWidth"),(RemoteObject.concat(RemoteObject.createImmutable("This is item #"),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)(RemoteObject.createImmutable((_i)))),RemoteObject.createImmutable(""))),BA.ObjectToString(_bitmaps.runMethod(false,"Get",(Object)(_idx))),_content).getObject()),(Object)((_cd)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 71;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 23;BA.debugLine="Private CLV1 As CustomListView";
main.mostCurrent._clv1 = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 24;BA.debugLine="Private ImageView1 As B4XView";
main.mostCurrent._imageview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private lblTitle As B4XView";
main.mostCurrent._lbltitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private lblContent As B4XView";
main.mostCurrent._lblcontent = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private lblAction1 As Label";
main.mostCurrent._lblaction1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private lblAction2 As Label";
main.mostCurrent._lblaction2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lblaction1_click() throws Exception{
try {
		Debug.PushSubsStack("lblAction1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,120);
if (RapidSub.canDelegate("lblaction1_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","lblaction1_click");}
RemoteObject _index = RemoteObject.createImmutable(0);
 BA.debugLineNum = 120;BA.debugLine="Sub lblAction1_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 121;BA.debugLine="Dim index As Int = CLV1.GetItemFromView(Sender)";
Debug.ShouldStop(16777216);
_index = main.mostCurrent._clv1.runMethod(true,"_getitemfromview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA)));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 122;BA.debugLine="Log($\"Action 1 clicked. Index: ${index}\"$)";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2655362",(RemoteObject.concat(RemoteObject.createImmutable("Action 1 clicked. Index: "),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_index))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 123;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("lblAction2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,125);
if (RapidSub.canDelegate("lblaction2_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","lblaction2_click");}
RemoteObject _index = RemoteObject.createImmutable(0);
 BA.debugLineNum = 125;BA.debugLine="Sub lblAction2_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 126;BA.debugLine="Dim index As Int = CLV1.GetItemFromView(Sender)";
Debug.ShouldStop(536870912);
_index = main.mostCurrent._clv1.runMethod(true,"_getitemfromview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA)));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 127;BA.debugLine="Log($\"Action 2 clicked. Index: ${index}\"$)";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2720898",(RemoteObject.concat(RemoteObject.createImmutable("Action 2 clicked. Index: "),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_index))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 128;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _next_click() throws Exception{
try {
		Debug.PushSubsStack("Next_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,77);
if (RapidSub.canDelegate("next_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","next_click");}
 BA.debugLineNum = 77;BA.debugLine="Sub Next_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 78;BA.debugLine="StartActivity(LazyLoadingPage)";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._lazyloadingpage.getObject())));
 BA.debugLineNum = 79;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
lazyloadingpage_subs_0._process_globals();
svcproduction_subs_0._process_globals();
modcommon_subs_0._process_globals();
httputils2service_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
lazyloadingpage.myClass = BA.getDeviceClass ("b4a.example.lazyloadingpage");
svcproduction.myClass = BA.getDeviceClass ("b4a.example.svcproduction");
modcommon.myClass = BA.getDeviceClass ("b4a.example.modcommon");
httputils2service.myClass = BA.getDeviceClass ("b4a.example.httputils2service");
httpjob.myClass = BA.getDeviceClass ("b4a.example.httpjob");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _setcolorstatelist(RemoteObject _btn,RemoteObject _pressed,RemoteObject _enabled) throws Exception{
try {
		Debug.PushSubsStack("SetColorStateList (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,130);
if (RapidSub.canDelegate("setcolorstatelist")) { return b4a.example.main.remoteMe.runUserSub(false, "main","setcolorstatelist", _btn, _pressed, _enabled);}
RemoteObject _states = null;
RemoteObject _csl = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _b1 = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("Btn", _btn);
Debug.locals.put("Pressed", _pressed);
Debug.locals.put("Enabled", _enabled);
 BA.debugLineNum = 130;BA.debugLine="Sub SetColorStateList(Btn As Label,Pressed As Int,";
Debug.ShouldStop(2);
 BA.debugLineNum = 131;BA.debugLine="Dim States(2,1) As Int";
Debug.ShouldStop(4);
_states = RemoteObject.createNewArray ("int", new int[] {2,1}, new Object[]{});Debug.locals.put("States", _states);
 BA.debugLineNum = 132;BA.debugLine="States(0,0) = 16842919    'Pressed";
Debug.ShouldStop(8);
_states.setArrayElement (BA.numberCast(int.class, 16842919),BA.numberCast(int.class, 0),BA.numberCast(int.class, 0));
 BA.debugLineNum = 133;BA.debugLine="States(1,0) = 16842910    'Enabled";
Debug.ShouldStop(16);
_states.setArrayElement (BA.numberCast(int.class, 16842910),BA.numberCast(int.class, 1),BA.numberCast(int.class, 0));
 BA.debugLineNum = 134;BA.debugLine="Dim CSL As JavaObject";
Debug.ShouldStop(32);
_csl = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("CSL", _csl);
 BA.debugLineNum = 135;BA.debugLine="CSL.InitializeNewInstance(\"android.content.res.Co";
Debug.ShouldStop(64);
_csl.runVoidMethod ("InitializeNewInstance",(Object)(BA.ObjectToString("android.content.res.ColorStateList")),(Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(_states),(RemoteObject.createNewArray("int",new int[] {2},new Object[] {_pressed,_enabled}))})));
 BA.debugLineNum = 136;BA.debugLine="Dim B1 As JavaObject = Btn";
Debug.ShouldStop(128);
_b1 = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_b1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), _btn.getObject());Debug.locals.put("B1", _b1);Debug.locals.put("B1", _b1);
 BA.debugLineNum = 137;BA.debugLine="B1.RunMethod(\"setTextColor\",Array As Object(CSL))";
Debug.ShouldStop(256);
_b1.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setTextColor")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_csl.getObject())})));
 BA.debugLineNum = 138;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}