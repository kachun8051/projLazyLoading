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

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
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
		return main.class;
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
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
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
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
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
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (lazyloadingpage.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
 {
            Activity __a = null;
            if (lazyloadingpage.previousOne != null) {
				__a = lazyloadingpage.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(lazyloadingpage.mostCurrent == null ? null : lazyloadingpage.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, svcproduction.class));
BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, httputils2service.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public b4a.example3.customlistview _clv1 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _imageview1 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lbltitle = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lblcontent = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblaction1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblaction2 = null;
public b4a.example.starter _starter = null;
public b4a.example.lazyloadingpage _lazyloadingpage = null;
public b4a.example.svcproduction _svcproduction = null;
public b4a.example.modcommon _modcommon = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="Activity.LoadLayout(\"1\")";
mostCurrent._activity.LoadLayout("1",mostCurrent.activityBA);
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="Activity.AddMenuItem3(\"\", \"refresh\", xui.LoadBitm";
mostCurrent._activity.AddMenuItem3(BA.ObjectToCharSequence(""),"refresh",(android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_cached_white_24dp.png",anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)),anywheresoftware.b4a.keywords.Common.True).getObject()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="Activity.AddMenuItem3(\"\", \"done\", xui.LoadBitmapR";
mostCurrent._activity.AddMenuItem3(BA.ObjectToCharSequence(""),"done",(android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_done_white_24dp.png",anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)),anywheresoftware.b4a.keywords.Common.True).getObject()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="Activity.AddMenuItem(\"Next\", \"Next\")";
mostCurrent._activity.AddMenuItem(BA.ObjectToCharSequence("Next"),"Next");
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="If CLV1.IsInitialized = False Then";
if (mostCurrent._clv1.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=196612;
 //BA.debugLineNum = 196612;BA.debugLine="If CLV1.Size =  0 Then";
if (mostCurrent._clv1._getsize()==0) { 
RDebugUtils.currentLine=196613;
 //BA.debugLineNum = 196613;BA.debugLine="fillTheData";
_fillthedata();
 };
RDebugUtils.currentLine=196615;
 //BA.debugLineNum = 196615;BA.debugLine="End Sub";
return "";
}
public static String  _fillthedata() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fillthedata", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fillthedata", null));}
anywheresoftware.b4a.objects.collections.List _bitmaps = null;
int _i = 0;
String _content = "";
int _idx = 0;
b4a.example.starter._carddata _cd = null;
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub fillTheData()";
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="Dim bitmaps As List = Array(\"pexels-photo-446811.";
_bitmaps = new anywheresoftware.b4a.objects.collections.List();
_bitmaps = anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("pexels-photo-446811.jpeg"),(Object)("pexels-photo-571195.jpeg"),(Object)("pexels-photo-736212.jpeg"),(Object)("pexels-photo-592798.jpeg")});
RDebugUtils.currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="For i = 0 To 100";
{
final int step2 = 1;
final int limit2 = (int) (100);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=327685;
 //BA.debugLineNum = 327685;BA.debugLine="Dim content As String = $\"Lorem ipsum dolor sit";
_content = ("Lorem ipsum dolor sit amet,\n"+"			consectetur adipiscing elit, \n"+"			sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \n"+"			Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
RDebugUtils.currentLine=327689;
 //BA.debugLineNum = 327689;BA.debugLine="Dim idx As Int = i Mod bitmaps.Size";
_idx = (int) (_i%_bitmaps.getSize());
RDebugUtils.currentLine=327690;
 //BA.debugLineNum = 327690;BA.debugLine="Dim cd As CardData";
_cd = new b4a.example.starter._carddata();
RDebugUtils.currentLine=327691;
 //BA.debugLineNum = 327691;BA.debugLine="cd.Initialize";
_cd.Initialize();
RDebugUtils.currentLine=327692;
 //BA.debugLineNum = 327692;BA.debugLine="cd.Title = $\"This is item #${i}\"$";
_cd.Title /*String*/  = ("This is item #"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_i))+"");
RDebugUtils.currentLine=327693;
 //BA.debugLineNum = 327693;BA.debugLine="cd.Content = content";
_cd.Content /*String*/  = _content;
RDebugUtils.currentLine=327694;
 //BA.debugLineNum = 327694;BA.debugLine="cd.BitmapFile = bitmaps.Get(idx)";
_cd.BitmapFile /*String*/  = BA.ObjectToString(_bitmaps.Get(_idx));
RDebugUtils.currentLine=327695;
 //BA.debugLineNum = 327695;BA.debugLine="CLV1.Add(CreateItem(CLV1.AsView.Width, $\"This is";
mostCurrent._clv1._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_createitem(mostCurrent._clv1._asview().getWidth(),("This is item #"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_i))+""),BA.ObjectToString(_bitmaps.Get(_idx)),_content).getObject())),(Object)(_cd));
 }
};
RDebugUtils.currentLine=327697;
 //BA.debugLineNum = 327697;BA.debugLine="End Sub";
return "";
}
public static String  _button1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button1_click", null));}
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub Button1_Click";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="xui.MsgboxAsync(\"Hello world!\", \"B4X\")";
_xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("Hello world!"),BA.ObjectToCharSequence("B4X"));
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="End Sub";
return "";
}
public static String  _clv1_visiblerangechanged(int _firstindex,int _lastindex) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "clv1_visiblerangechanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "clv1_visiblerangechanged", new Object[] {_firstindex,_lastindex}));}
int _extrasize = 0;
int _i = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
b4a.example.starter._carddata _cd = null;
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub CLV1_VisibleRangeChanged (FirstIndex As Int, L";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="Dim ExtraSize As Int = 20";
_extrasize = (int) (20);
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="For i = 0 To CLV1.Size - 1";
{
final int step2 = 1;
final int limit2 = (int) (mostCurrent._clv1._getsize()-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="Dim p As B4XView = CLV1.GetPanel(i)";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = mostCurrent._clv1._getpanel(_i);
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="If i > FirstIndex - ExtraSize And i < LastIndex";
if (_i>_firstindex-_extrasize && _i<_lastindex+_extrasize) { 
RDebugUtils.currentLine=589830;
 //BA.debugLineNum = 589830;BA.debugLine="If p.NumberOfViews = 0 Then";
if (_p.getNumberOfViews()==0) { 
RDebugUtils.currentLine=589831;
 //BA.debugLineNum = 589831;BA.debugLine="Dim cd As CardData = CLV1.GetValue(i)";
_cd = (b4a.example.starter._carddata)(mostCurrent._clv1._getvalue(_i));
RDebugUtils.currentLine=589832;
 //BA.debugLineNum = 589832;BA.debugLine="p.LoadLayout(\"Card1\")";
_p.LoadLayout("Card1",mostCurrent.activityBA);
RDebugUtils.currentLine=589833;
 //BA.debugLineNum = 589833;BA.debugLine="lblTitle.Text = cd.Title";
mostCurrent._lbltitle.setText(BA.ObjectToCharSequence(_cd.Title /*String*/ ));
RDebugUtils.currentLine=589834;
 //BA.debugLineNum = 589834;BA.debugLine="lblContent.Text = cd.Content";
mostCurrent._lblcontent.setText(BA.ObjectToCharSequence(_cd.Content /*String*/ ));
RDebugUtils.currentLine=589835;
 //BA.debugLineNum = 589835;BA.debugLine="SetColorStateList(lblAction1, xui.Color_LightG";
_setcolorstatelist(mostCurrent._lblaction1,_xui.Color_LightGray,mostCurrent._lblaction1.getTextColor());
RDebugUtils.currentLine=589836;
 //BA.debugLineNum = 589836;BA.debugLine="SetColorStateList(lblAction2, xui.Color_LightG";
_setcolorstatelist(mostCurrent._lblaction2,_xui.Color_LightGray,mostCurrent._lblaction2.getTextColor());
RDebugUtils.currentLine=589837;
 //BA.debugLineNum = 589837;BA.debugLine="ImageView1.SetBitmap(xui.LoadBitmapResize(File";
mostCurrent._imageview1.SetBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_cd.BitmapFile /*String*/ ,mostCurrent._imageview1.getWidth(),mostCurrent._imageview1.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 };
 }else {
RDebugUtils.currentLine=589841;
 //BA.debugLineNum = 589841;BA.debugLine="If p.NumberOfViews > 0 Then";
if (_p.getNumberOfViews()>0) { 
RDebugUtils.currentLine=589842;
 //BA.debugLineNum = 589842;BA.debugLine="p.RemoveAllViews '<--- remove the layout";
_p.RemoveAllViews();
 };
 };
 }
};
RDebugUtils.currentLine=589846;
 //BA.debugLineNum = 589846;BA.debugLine="End Sub";
return "";
}
public static String  _setcolorstatelist(anywheresoftware.b4a.objects.LabelWrapper _btn,int _pressed,int _enabled) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "setcolorstatelist", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "setcolorstatelist", new Object[] {_btn,_pressed,_enabled}));}
int[][] _states = null;
anywheresoftware.b4j.object.JavaObject _csl = null;
anywheresoftware.b4j.object.JavaObject _b1 = null;
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub SetColorStateList(Btn As Label,Pressed As Int,";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="Dim States(2,1) As Int";
_states = new int[(int) (2)][];
{
int d0 = _states.length;
int d1 = (int) (1);
for (int i0 = 0;i0 < d0;i0++) {
_states[i0] = new int[d1];
}
}
;
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="States(0,0) = 16842919    'Pressed";
_states[(int) (0)][(int) (0)] = (int) (16842919);
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="States(1,0) = 16842910    'Enabled";
_states[(int) (1)][(int) (0)] = (int) (16842910);
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="Dim CSL As JavaObject";
_csl = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="CSL.InitializeNewInstance(\"android.content.res.Co";
_csl.InitializeNewInstance("android.content.res.ColorStateList",new Object[]{(Object)(_states),(Object)(new int[]{_pressed,_enabled})});
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="Dim B1 As JavaObject = Btn";
_b1 = new anywheresoftware.b4j.object.JavaObject();
_b1 = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_btn.getObject()));
RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="B1.RunMethod(\"setTextColor\",Array As Object(CSL))";
_b1.RunMethod("setTextColor",new Object[]{(Object)(_csl.getObject())});
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.PanelWrapper  _createitem(int _width,String _title,String _image,String _content) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "createitem", false))
	 {return ((anywheresoftware.b4a.objects.PanelWrapper) Debug.delegate(mostCurrent.activityBA, "createitem", new Object[] {_width,_title,_image,_content}));}
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
int _height = 0;
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Private Sub CreateItem(Width As Int, Title As Stri";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _xui.CreatePanel(processBA,"");
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="Dim height As Int = 280dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (280));
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="If GetDeviceLayoutValues.ApproximateScreenSize <";
if (anywheresoftware.b4a.keywords.Common.GetDeviceLayoutValues(mostCurrent.activityBA).getApproximateScreenSize()<4.5) { 
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (310));};
RDebugUtils.currentLine=524292;
 //BA.debugLineNum = 524292;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, Width, height)";
_p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),_width,_height);
RDebugUtils.currentLine=524293;
 //BA.debugLineNum = 524293;BA.debugLine="p.LoadLayout(\"Card1\")";
_p.LoadLayout("Card1",mostCurrent.activityBA);
RDebugUtils.currentLine=524295;
 //BA.debugLineNum = 524295;BA.debugLine="lblTitle.Text = Title";
mostCurrent._lbltitle.setText(BA.ObjectToCharSequence(_title));
RDebugUtils.currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="lblContent.Text = Content";
mostCurrent._lblcontent.setText(BA.ObjectToCharSequence(_content));
RDebugUtils.currentLine=524297;
 //BA.debugLineNum = 524297;BA.debugLine="SetColorStateList(lblAction1, xui.Color_LightGray";
_setcolorstatelist(mostCurrent._lblaction1,_xui.Color_LightGray,mostCurrent._lblaction1.getTextColor());
RDebugUtils.currentLine=524298;
 //BA.debugLineNum = 524298;BA.debugLine="SetColorStateList(lblAction2, xui.Color_LightGray";
_setcolorstatelist(mostCurrent._lblaction2,_xui.Color_LightGray,mostCurrent._lblaction2.getTextColor());
RDebugUtils.currentLine=524299;
 //BA.debugLineNum = 524299;BA.debugLine="ImageView1.SetBitmap(xui.LoadBitmapResize(File.Di";
mostCurrent._imageview1.SetBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_image,mostCurrent._imageview1.getWidth(),mostCurrent._imageview1.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=524300;
 //BA.debugLineNum = 524300;BA.debugLine="Return p";
if (true) return (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_p.getObject()));
RDebugUtils.currentLine=524301;
 //BA.debugLineNum = 524301;BA.debugLine="End Sub";
return null;
}
public static String  _lblaction1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblaction1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblaction1_click", null));}
int _index = 0;
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub lblAction1_Click";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="Dim index As Int = CLV1.GetItemFromView(Sender)";
_index = mostCurrent._clv1._getitemfromview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA))));
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="Log($\"Action 1 clicked. Index: ${index}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("2655362",("Action 1 clicked. Index: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_index))+""),0);
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="End Sub";
return "";
}
public static String  _lblaction2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblaction2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblaction2_click", null));}
int _index = 0;
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub lblAction2_Click";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Dim index As Int = CLV1.GetItemFromView(Sender)";
_index = mostCurrent._clv1._getitemfromview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA))));
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="Log($\"Action 2 clicked. Index: ${index}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("2720898",("Action 2 clicked. Index: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_index))+""),0);
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="End Sub";
return "";
}
public static String  _next_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "next_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "next_click", null));}
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub Next_Click";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="StartActivity(LazyLoadingPage)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._lazyloadingpage.getObject()));
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="End Sub";
return "";
}
}