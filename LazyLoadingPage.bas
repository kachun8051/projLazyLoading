B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=11.8
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	
	Private xui As XUI
	Private strDate As String
	Private lstOfProduction As List
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	
	Private CLV1 As CustomListView	
	#Region RowCardUI
	Private lblItemNo As Label
	Private lblName As Label
	Private lblName2 As Label
	Private lblSellingPrice As Label
	Private lblWeight As Label
	Private lblDt As Label
	#End Region
	Private btnDate As Button
	Private lblDate As Label	
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.LoadLayout("2.bal")
	Activity.Title = "Production Data"
End Sub

Sub Activity_Resume
	If lblDate.Text = "" Then
		If strDate = "" Then
			' when page initialize
			strDate = getNow
		End If		
		lblDate.Text = strDate
	End If
	If CLV1.IsInitialized = False Then
		Return
	End If
	If CLV1.Size = 0 Then
		If lstOfProduction.IsInitialized = False Then
			' when page initialize
			ProgressDialogShow2("Production data loading...", True)
			sendQueryIntent(strDate.Replace("/", ""))
			Return
		End If
		FillTheList
	End If
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Private Sub getQueryResponse(mapRes As Map)
	ProgressDialogHide
	If mapRes.IsInitialized = False Then
		Return
	End If
	If mapRes.Get("issuccess").As(Boolean) = False Then
		Msgbox2Async(mapRes.Get("errmsg"), "Query Error", "OK", "", "", Null, True)
		Return
	End If
	lstOfProduction = mapRes.Get("datalist").As(List)
	FillTheList
End Sub

Private Sub FillTheList() As Boolean
	If lstOfProduction.IsInitialized = False Then
		Return False
	End If
	For Each mapEntry As Map In lstOfProduction
		Dim p As B4XView = xui.CreatePanel("")
		p.SetLayoutAnimated(0, 0, 0, CLV1.AsView.Width, 180dip)
		CLV1.Add(p, mapEntry)
	Next
	Return True
End Sub

Sub CLV1_VisibleRangeChanged (FirstIndex As Int, LastIndex As Int)
	Dim ExtraSize As Int = 20
	For i = Max(0, FirstIndex - ExtraSize) To Min(LastIndex + ExtraSize, CLV1.Size - 1)
		Dim p As B4XView = CLV1.GetPanel(i)
		If p.NumberOfViews = 0 Then
			Dim map_1 As Map = CLV1.GetValue(i)
			'**************** this code is similar to the code in CreateItem from the original example
			p.LoadLayout("RowLayout.bal")
			lblItemNo.Text = map_1.Get("itemnum")
			lblName.Text = map_1.Get("itemname")
			lblName2.Text = map_1.Get("itemname2")
			lblSellingPrice.Text = "HK$" & map_1.Get("sellingprice")
			lblWeight.Text = map_1.Get("weightingram") & " gram"
			lblDt.Text = map_1.Get("packingdt").As(String).SubString2(0, 19)
		End If
	Next
End Sub

Private Sub sendQueryIntent(datecode As String)
	If datecode = "" Then
		datecode = getNowDateCode
	End If
	Dim inte As Intent
	inte.Initialize("", "")
	inte.SetComponent(Application.PackageName & "/.svcproduction")
	inte.PutExtra("sender", "LazyLoadingPage")
	inte.PutExtra("task", "query")
	inte.PutExtra("param", datecode)
	StartService(inte)
End Sub

Private Sub getNowDateCode() As String
	Dim dtNow As Long = DateTime.Now
	' original date format
	Dim df As String = DateTime.DateFormat
	DateTime.DateFormat = "yyyyMMdd"
	Dim daycode As String
	Try
		daycode = DateTime.Date(dtNow)		
	Catch
		Log(LastException)
		daycode = ""
	End Try
	' Restore original date format
	DateTime.DateFormat = df
	Return daycode	
End Sub

Private Sub btnDate_Click
	Dim dd As DateDialog
	dd.DateTicks = DateTime.Now
	Dim sf As Object = dd.ShowAsync("Choose Production date", "Which date?", "OK", "Cancel", "", Null, False)
	Wait For (sf) Dialog_Result(Result As Int)
	If Result = DialogResponse.POSITIVE Then
		Dim df As String = DateTime.DateFormat
		DateTime.DateFormat = "yyyy/MM/dd"
		strDate = DateTime.Date(dd.DateTicks)		
		lblDate.Text = strDate
		Log(DateTime.Date(dd.DateTicks))
		DateTime.DateFormat = df
		sendQueryIntent(strDate.Replace("/", ""))
	End If
End Sub

Private Sub getNow() As String
	Dim dtNow As String = ""
	Dim df As String = DateTime.DateFormat
	DateTime.DateFormat = "yyyy/MM/dd"
	dtNow = DateTime.Date(DateTime.Now)	
	DateTime.DateFormat = df
	Return dtNow
End Sub