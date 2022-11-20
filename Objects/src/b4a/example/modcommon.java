package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class modcommon {
private static modcommon mostCurrent = new modcommon();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 
public anywheresoftware.b4a.keywords.Common __c = null;
public static String _appid = "";
public static String _apikey = "";
public static String _masterkey = "";
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.lazyloadingpage _lazyloadingpage = null;
public b4a.example.svcproduction _svcproduction = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _initparams(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="modcommon";
if (Debug.shouldDelegate(null, "initparams", false))
	 {return ((String) Debug.delegate(null, "initparams", new Object[] {_ba}));}
RDebugUtils.currentLine=4653056;
 //BA.debugLineNum = 4653056;BA.debugLine="Public Sub initParams()";
RDebugUtils.currentLine=4653057;
 //BA.debugLineNum = 4653057;BA.debugLine="appid = \"5vUD5SzypdFDZfa7Sxjya1yLliHMAJ52ML3sqBf6";
_appid = "5vUD5SzypdFDZfa7Sxjya1yLliHMAJ52ML3sqBf6";
RDebugUtils.currentLine=4653058;
 //BA.debugLineNum = 4653058;BA.debugLine="apikey = \"sgyDDR9YYlvTfkZv1datnUu75nhnnjqejm2yMFN";
_apikey = "sgyDDR9YYlvTfkZv1datnUu75nhnnjqejm2yMFNL";
RDebugUtils.currentLine=4653059;
 //BA.debugLineNum = 4653059;BA.debugLine="masterkey = \"xFPWpeqIXuGXBek7CljLVsRH72TjvQen5Rd9";
_masterkey = "xFPWpeqIXuGXBek7CljLVsRH72TjvQen5Rd9XxiF";
RDebugUtils.currentLine=4653060;
 //BA.debugLineNum = 4653060;BA.debugLine="End Sub";
return "";
}
}