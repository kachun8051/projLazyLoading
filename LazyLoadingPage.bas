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
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	
	Private CLV1 As CustomListView
	Private ImageView1 As B4XView
	Private lblTitle As B4XView
	Private lblContent As B4XView
	Private lblAction1 As Label
	Private lblAction2 As Label
	Private lstOfProduction As List
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.LoadLayout("1")
	Activity.Title = "Production Data"
	If lstOfProduction.IsInitialized = False Then
		ProgressDialogShow2("Production data loading...", True)
		sendQueryIntent("")		
	End If
	' FillList2
End Sub

Sub Activity_Resume
	
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
End Sub

Sub FillList2
	Dim bitmaps As List = Array("pexels-photo-446811.jpeg", "pexels-photo-571195.jpeg", _
       "pexels-photo-736212.jpeg", "pexels-photo-592798.jpeg")
	Dim n As Long = DateTime.Now
	For i = 1 To 1000
		Dim content As String = $"Lorem ipsum dolor sit amet,
			consectetur adipiscing elit,
			sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
			Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."$
		Dim cd As CardData
		cd.Initialize
		cd.Title = $"This is item #${i}"$
		cd.Content = content
		cd.BitmapFile = bitmaps.Get((i - 1) Mod bitmaps.Size)
		Dim p As B4XView = xui.CreatePanel("")
		p.SetLayoutAnimated(0, 0, 0, CLV1.AsView.Width, 280dip)
		CLV1.Add(p, cd)
	Next
	Log("Loading cards took: " & (DateTime.Now - n) & "ms")
End Sub

Sub CLV1_VisibleRangeChanged (FirstIndex As Int, LastIndex As Int)
	Dim ExtraSize As Int = 20
	For i = Max(0, FirstIndex - ExtraSize) To Min(LastIndex + ExtraSize, CLV1.Size - 1)
		Dim p As B4XView = CLV1.GetPanel(i)
		If p.NumberOfViews = 0 Then
			Dim cd As CardData = CLV1.GetValue(i)
			'**************** this code is similar to the code in CreateItem from the original example
			p.LoadLayout("Card1")
			lblTitle.Text = cd.Title
			lblContent.Text = cd.Content
			SetColorStateList(lblAction1, xui.Color_LightGray, lblAction1.TextColor)
			SetColorStateList(lblAction2, xui.Color_LightGray, lblAction2.TextColor)
			ImageView1.SetBitmap(xui.LoadBitmapResize(File.DirAssets, cd.BitmapFile, ImageView1.Width, ImageView1.Height, True))
		End If
	Next
End Sub

Sub lblAction1_Click
	Dim index As Int = CLV1.GetItemFromView(Sender)
	Log($"Action 1 clicked. Index: ${index}"$)
End Sub

Sub lblAction2_Click
	Dim index As Int = CLV1.GetItemFromView(Sender)
	Log($"Action 2 clicked. Index: ${index}"$)
End Sub

Sub SetColorStateList(Btn As Label,Pressed As Int,Enabled As Int)
	Dim States(2,1) As Int
	States(0,0) = 16842919    'Pressed
	States(1,0) = 16842910    'Enabled
	Dim CSL As JavaObject
	CSL.InitializeNewInstance("android.content.res.ColorStateList",Array(States,Array As Int(Pressed, Enabled)))
	Dim B1 As JavaObject = Btn
	B1.RunMethod("setTextColor",Array As Object(CSL))
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