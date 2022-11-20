B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=11.8
@EndOfDesignText@
'Code module
'Subs in this code module will be accessible from all modules.
Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Public appid, apikey As String
	Public masterkey As String
End Sub

Public Sub initParams()
	appid = "5vUD5SzypdFDZfa7Sxjya1yLliHMAJ52ML3sqBf6"
	apikey = "sgyDDR9YYlvTfkZv1datnUu75nhnnjqejm2yMFNL"
	masterkey = "xFPWpeqIXuGXBek7CljLVsRH72TjvQen5Rd9XxiF"
End Sub