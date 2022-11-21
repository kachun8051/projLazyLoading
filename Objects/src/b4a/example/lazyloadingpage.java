package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class lazyloadingpage extends Activity implements B4AActivity{
	public static lazyloadingpage mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.lazyloadingpage");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (lazyloadingpage).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.lazyloadingpage");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.lazyloadingpage", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (lazyloadingpage) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (lazyloadingpage) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return lazyloadingpage.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (lazyloadingpage) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (lazyloadingpage) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            lazyloadingpage mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (lazyloadingpage) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public b4a.example3.customlistview _clv1 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _imageview1 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lbltitle = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lblcontent = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblaction1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblaction2 = null;
public anywheresoftware.b4a.objects.collections.List _lstofproduction = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.svcproduction _svcproduction = null;
public b4a.example.modcommon _modcommon = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="lazyloadingpage";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="Activity.LoadLayout(\"1\")";
mostCurrent._activity.LoadLayout("1",mostCurrent.activityBA);
RDebugUtils.currentLine=1376260;
 //BA.debugLineNum = 1376260;BA.debugLine="Activity.Title = \"Production Data\"";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence("Production Data"));
RDebugUtils.currentLine=1376261;
 //BA.debugLineNum = 1376261;BA.debugLine="If lstOfProduction.IsInitialized = False Then";
if (mostCurrent._lstofproduction.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=1376262;
 //BA.debugLineNum = 1376262;BA.debugLine="ProgressDialogShow2(\"Production data loading...\"";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow2(mostCurrent.activityBA,BA.ObjectToCharSequence("Production data loading..."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1376263;
 //BA.debugLineNum = 1376263;BA.debugLine="sendQueryIntent(\"\")";
_sendqueryintent("");
 };
RDebugUtils.currentLine=1376266;
 //BA.debugLineNum = 1376266;BA.debugLine="End Sub";
return "";
}
public static String  _sendqueryintent(String _datecode) throws Exception{
RDebugUtils.currentModule="lazyloadingpage";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sendqueryintent", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sendqueryintent", new Object[] {_datecode}));}
anywheresoftware.b4a.objects.IntentWrapper _inte = null;
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Private Sub sendQueryIntent(datecode As String)";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="If datecode = \"\" Then";
if ((_datecode).equals("")) { 
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="datecode = getNowDateCode";
_datecode = _getnowdatecode();
 };
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="Dim inte As Intent";
_inte = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=1966085;
 //BA.debugLineNum = 1966085;BA.debugLine="inte.Initialize(\"\", \"\")";
_inte.Initialize("","");
RDebugUtils.currentLine=1966086;
 //BA.debugLineNum = 1966086;BA.debugLine="inte.SetComponent(Application.PackageName & \"/.sv";
_inte.SetComponent(anywheresoftware.b4a.keywords.Common.Application.getPackageName()+"/.svcproduction");
RDebugUtils.currentLine=1966087;
 //BA.debugLineNum = 1966087;BA.debugLine="inte.PutExtra(\"sender\", \"LazyLoadingPage\")";
_inte.PutExtra("sender",(Object)("LazyLoadingPage"));
RDebugUtils.currentLine=1966088;
 //BA.debugLineNum = 1966088;BA.debugLine="inte.PutExtra(\"task\", \"query\")";
_inte.PutExtra("task",(Object)("query"));
RDebugUtils.currentLine=1966089;
 //BA.debugLineNum = 1966089;BA.debugLine="inte.PutExtra(\"param\", datecode)";
_inte.PutExtra("param",(Object)(_datecode));
RDebugUtils.currentLine=1966090;
 //BA.debugLineNum = 1966090;BA.debugLine="StartService(inte)";
anywheresoftware.b4a.keywords.Common.StartService(processBA,(Object)(_inte.getObject()));
RDebugUtils.currentLine=1966091;
 //BA.debugLineNum = 1966091;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="lazyloadingpage";
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="lazyloadingpage";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="End Sub";
return "";
}
public static String  _clv1_visiblerangechanged(int _firstindex,int _lastindex) throws Exception{
RDebugUtils.currentModule="lazyloadingpage";
if (Debug.shouldDelegate(mostCurrent.activityBA, "clv1_visiblerangechanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "clv1_visiblerangechanged", new Object[] {_firstindex,_lastindex}));}
int _extrasize = 0;
int _i = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
b4a.example.starter._carddata _cd = null;
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Sub CLV1_VisibleRangeChanged (FirstIndex As Int, L";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="Dim ExtraSize As Int = 20";
_extrasize = (int) (20);
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="For i = Max(0, FirstIndex - ExtraSize) To Min(Las";
{
final int step2 = 1;
final int limit2 = (int) (anywheresoftware.b4a.keywords.Common.Min(_lastindex+_extrasize,mostCurrent._clv1._getsize()-1));
_i = (int) (anywheresoftware.b4a.keywords.Common.Max(0,_firstindex-_extrasize)) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=1703939;
 //BA.debugLineNum = 1703939;BA.debugLine="Dim p As B4XView = CLV1.GetPanel(i)";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = mostCurrent._clv1._getpanel(_i);
RDebugUtils.currentLine=1703940;
 //BA.debugLineNum = 1703940;BA.debugLine="If p.NumberOfViews = 0 Then";
if (_p.getNumberOfViews()==0) { 
RDebugUtils.currentLine=1703941;
 //BA.debugLineNum = 1703941;BA.debugLine="Dim cd As CardData = CLV1.GetValue(i)";
_cd = (b4a.example.starter._carddata)(mostCurrent._clv1._getvalue(_i));
RDebugUtils.currentLine=1703943;
 //BA.debugLineNum = 1703943;BA.debugLine="p.LoadLayout(\"Card1\")";
_p.LoadLayout("Card1",mostCurrent.activityBA);
RDebugUtils.currentLine=1703944;
 //BA.debugLineNum = 1703944;BA.debugLine="lblTitle.Text = cd.Title";
mostCurrent._lbltitle.setText(BA.ObjectToCharSequence(_cd.Title /*String*/ ));
RDebugUtils.currentLine=1703945;
 //BA.debugLineNum = 1703945;BA.debugLine="lblContent.Text = cd.Content";
mostCurrent._lblcontent.setText(BA.ObjectToCharSequence(_cd.Content /*String*/ ));
RDebugUtils.currentLine=1703946;
 //BA.debugLineNum = 1703946;BA.debugLine="SetColorStateList(lblAction1, xui.Color_LightGr";
_setcolorstatelist(mostCurrent._lblaction1,_xui.Color_LightGray,mostCurrent._lblaction1.getTextColor());
RDebugUtils.currentLine=1703947;
 //BA.debugLineNum = 1703947;BA.debugLine="SetColorStateList(lblAction2, xui.Color_LightGr";
_setcolorstatelist(mostCurrent._lblaction2,_xui.Color_LightGray,mostCurrent._lblaction2.getTextColor());
RDebugUtils.currentLine=1703948;
 //BA.debugLineNum = 1703948;BA.debugLine="ImageView1.SetBitmap(xui.LoadBitmapResize(File.";
mostCurrent._imageview1.SetBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_cd.BitmapFile /*String*/ ,mostCurrent._imageview1.getWidth(),mostCurrent._imageview1.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 };
 }
};
RDebugUtils.currentLine=1703951;
 //BA.debugLineNum = 1703951;BA.debugLine="End Sub";
return "";
}
public static String  _setcolorstatelist(anywheresoftware.b4a.objects.LabelWrapper _btn,int _pressed,int _enabled) throws Exception{
RDebugUtils.currentModule="lazyloadingpage";
if (Debug.shouldDelegate(mostCurrent.activityBA, "setcolorstatelist", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "setcolorstatelist", new Object[] {_btn,_pressed,_enabled}));}
int[][] _states = null;
anywheresoftware.b4j.object.JavaObject _csl = null;
anywheresoftware.b4j.object.JavaObject _b1 = null;
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Sub SetColorStateList(Btn As Label,Pressed As Int,";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="Dim States(2,1) As Int";
_states = new int[(int) (2)][];
{
int d0 = _states.length;
int d1 = (int) (1);
for (int i0 = 0;i0 < d0;i0++) {
_states[i0] = new int[d1];
}
}
;
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="States(0,0) = 16842919    'Pressed";
_states[(int) (0)][(int) (0)] = (int) (16842919);
RDebugUtils.currentLine=1900547;
 //BA.debugLineNum = 1900547;BA.debugLine="States(1,0) = 16842910    'Enabled";
_states[(int) (1)][(int) (0)] = (int) (16842910);
RDebugUtils.currentLine=1900548;
 //BA.debugLineNum = 1900548;BA.debugLine="Dim CSL As JavaObject";
_csl = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=1900549;
 //BA.debugLineNum = 1900549;BA.debugLine="CSL.InitializeNewInstance(\"android.content.res.Co";
_csl.InitializeNewInstance("android.content.res.ColorStateList",new Object[]{(Object)(_states),(Object)(new int[]{_pressed,_enabled})});
RDebugUtils.currentLine=1900550;
 //BA.debugLineNum = 1900550;BA.debugLine="Dim B1 As JavaObject = Btn";
_b1 = new anywheresoftware.b4j.object.JavaObject();
_b1 = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_btn.getObject()));
RDebugUtils.currentLine=1900551;
 //BA.debugLineNum = 1900551;BA.debugLine="B1.RunMethod(\"setTextColor\",Array As Object(CSL))";
_b1.RunMethod("setTextColor",new Object[]{(Object)(_csl.getObject())});
RDebugUtils.currentLine=1900552;
 //BA.debugLineNum = 1900552;BA.debugLine="End Sub";
return "";
}
public static String  _filllist2() throws Exception{
RDebugUtils.currentModule="lazyloadingpage";
if (Debug.shouldDelegate(mostCurrent.activityBA, "filllist2", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "filllist2", null));}
anywheresoftware.b4a.objects.collections.List _bitmaps = null;
long _n = 0L;
int _i = 0;
String _content = "";
b4a.example.starter._carddata _cd = null;
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Sub FillList2";
RDebugUtils.currentLine=1638401;
 //BA.debugLineNum = 1638401;BA.debugLine="Dim bitmaps As List = Array(\"pexels-photo-446811.";
_bitmaps = new anywheresoftware.b4a.objects.collections.List();
_bitmaps = anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("pexels-photo-446811.jpeg"),(Object)("pexels-photo-571195.jpeg"),(Object)("pexels-photo-736212.jpeg"),(Object)("pexels-photo-592798.jpeg")});
RDebugUtils.currentLine=1638403;
 //BA.debugLineNum = 1638403;BA.debugLine="Dim n As Long = DateTime.Now";
_n = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
RDebugUtils.currentLine=1638404;
 //BA.debugLineNum = 1638404;BA.debugLine="For i = 1 To 1000";
{
final int step3 = 1;
final int limit3 = (int) (1000);
_i = (int) (1) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
RDebugUtils.currentLine=1638405;
 //BA.debugLineNum = 1638405;BA.debugLine="Dim content As String = $\"Lorem ipsum dolor sit";
_content = ("Lorem ipsum dolor sit amet,\n"+"			consectetur adipiscing elit,\n"+"			sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n"+"			Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
RDebugUtils.currentLine=1638409;
 //BA.debugLineNum = 1638409;BA.debugLine="Dim cd As CardData";
_cd = new b4a.example.starter._carddata();
RDebugUtils.currentLine=1638410;
 //BA.debugLineNum = 1638410;BA.debugLine="cd.Initialize";
_cd.Initialize();
RDebugUtils.currentLine=1638411;
 //BA.debugLineNum = 1638411;BA.debugLine="cd.Title = $\"This is item #${i}\"$";
_cd.Title /*String*/  = ("This is item #"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_i))+"");
RDebugUtils.currentLine=1638412;
 //BA.debugLineNum = 1638412;BA.debugLine="cd.Content = content";
_cd.Content /*String*/  = _content;
RDebugUtils.currentLine=1638413;
 //BA.debugLineNum = 1638413;BA.debugLine="cd.BitmapFile = bitmaps.Get((i - 1) Mod bitmaps.";
_cd.BitmapFile /*String*/  = BA.ObjectToString(_bitmaps.Get((int) ((_i-1)%_bitmaps.getSize())));
RDebugUtils.currentLine=1638414;
 //BA.debugLineNum = 1638414;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _xui.CreatePanel(processBA,"");
RDebugUtils.currentLine=1638415;
 //BA.debugLineNum = 1638415;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, CLV1.AsView.Width,";
_p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),mostCurrent._clv1._asview().getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (280)));
RDebugUtils.currentLine=1638416;
 //BA.debugLineNum = 1638416;BA.debugLine="CLV1.Add(p, cd)";
mostCurrent._clv1._add(_p,(Object)(_cd));
 }
};
RDebugUtils.currentLine=1638418;
 //BA.debugLineNum = 1638418;BA.debugLine="Log(\"Loading cards took: \" & (DateTime.Now - n) &";
anywheresoftware.b4a.keywords.Common.LogImpl("21638418","Loading cards took: "+BA.NumberToString((anywheresoftware.b4a.keywords.Common.DateTime.getNow()-_n))+"ms",0);
RDebugUtils.currentLine=1638419;
 //BA.debugLineNum = 1638419;BA.debugLine="End Sub";
return "";
}
public static String  _getnowdatecode() throws Exception{
RDebugUtils.currentModule="lazyloadingpage";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getnowdatecode", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "getnowdatecode", null));}
long _dtnow = 0L;
String _df = "";
String _daycode = "";
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Private Sub getNowDateCode() As String";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="Dim dtNow As Long = DateTime.Now";
_dtnow = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="Dim df As String = DateTime.DateFormat";
_df = anywheresoftware.b4a.keywords.Common.DateTime.getDateFormat();
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="DateTime.DateFormat = \"yyyyMMdd\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("yyyyMMdd");
RDebugUtils.currentLine=2031621;
 //BA.debugLineNum = 2031621;BA.debugLine="Dim daycode As String";
_daycode = "";
RDebugUtils.currentLine=2031622;
 //BA.debugLineNum = 2031622;BA.debugLine="Try";
try {RDebugUtils.currentLine=2031623;
 //BA.debugLineNum = 2031623;BA.debugLine="daycode = DateTime.Date(dtNow)";
_daycode = anywheresoftware.b4a.keywords.Common.DateTime.Date(_dtnow);
 } 
       catch (Exception e8) {
			processBA.setLastException(e8);RDebugUtils.currentLine=2031625;
 //BA.debugLineNum = 2031625;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("22031625",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
RDebugUtils.currentLine=2031626;
 //BA.debugLineNum = 2031626;BA.debugLine="daycode = \"\"";
_daycode = "";
 };
RDebugUtils.currentLine=2031629;
 //BA.debugLineNum = 2031629;BA.debugLine="DateTime.DateFormat = df";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat(_df);
RDebugUtils.currentLine=2031630;
 //BA.debugLineNum = 2031630;BA.debugLine="Return daycode";
if (true) return _daycode;
RDebugUtils.currentLine=2031631;
 //BA.debugLineNum = 2031631;BA.debugLine="End Sub";
return "";
}
public static String  _getqueryresponse(anywheresoftware.b4a.objects.collections.Map _mapres) throws Exception{
RDebugUtils.currentModule="lazyloadingpage";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getqueryresponse", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "getqueryresponse", new Object[] {_mapres}));}
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Private Sub getQueryResponse(mapRes As Map)";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="If mapRes.IsInitialized = False Then";
if (_mapres.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1572869;
 //BA.debugLineNum = 1572869;BA.debugLine="If mapRes.Get(\"issuccess\").As(Boolean) = False Th";
if ((BA.ObjectToBoolean(_mapres.Get((Object)("issuccess"))))==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=1572870;
 //BA.debugLineNum = 1572870;BA.debugLine="Msgbox2Async(mapRes.Get(\"errmsg\"), \"Query Error\"";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence(_mapres.Get((Object)("errmsg"))),BA.ObjectToCharSequence("Query Error"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1572871;
 //BA.debugLineNum = 1572871;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1572873;
 //BA.debugLineNum = 1572873;BA.debugLine="lstOfProduction = mapRes.Get(\"datalist\").As(List)";
mostCurrent._lstofproduction = ((anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_mapres.Get((Object)("datalist")))));
RDebugUtils.currentLine=1572874;
 //BA.debugLineNum = 1572874;BA.debugLine="End Sub";
return "";
}
public static String  _lblaction1_click() throws Exception{
RDebugUtils.currentModule="lazyloadingpage";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblaction1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblaction1_click", null));}
int _index = 0;
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Sub lblAction1_Click";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="Dim index As Int = CLV1.GetItemFromView(Sender)";
_index = mostCurrent._clv1._getitemfromview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA))));
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="Log($\"Action 1 clicked. Index: ${index}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("21769474",("Action 1 clicked. Index: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_index))+""),0);
RDebugUtils.currentLine=1769475;
 //BA.debugLineNum = 1769475;BA.debugLine="End Sub";
return "";
}
public static String  _lblaction2_click() throws Exception{
RDebugUtils.currentModule="lazyloadingpage";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblaction2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblaction2_click", null));}
int _index = 0;
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Sub lblAction2_Click";
RDebugUtils.currentLine=1835009;
 //BA.debugLineNum = 1835009;BA.debugLine="Dim index As Int = CLV1.GetItemFromView(Sender)";
_index = mostCurrent._clv1._getitemfromview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA))));
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="Log($\"Action 2 clicked. Index: ${index}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("21835010",("Action 2 clicked. Index: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_index))+""),0);
RDebugUtils.currentLine=1835011;
 //BA.debugLineNum = 1835011;BA.debugLine="End Sub";
return "";
}
}