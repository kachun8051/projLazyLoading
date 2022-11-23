B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=11.8
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False
	
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Private Job As HttpJob
	Private lstOfProduction As List
	Private mySender As String
End Sub

Sub Service_Create
	lstOfProduction.Initialize
	modCommon.initParams
End Sub

Sub Service_Start (StartingIntent As Intent)
	Service.StopAutomaticForeground 'Call this when the background task completes (if there is one)
	If StartingIntent.HasExtra("sender") = False Then
		Return
	End If
	If StartingIntent.HasExtra("task") = False Then
		Return
	End If
	mySender = StartingIntent.GetExtra("sender")
	Dim myTask As String = StartingIntent.GetExtra("task")
	Dim myParam As String
	If StartingIntent.HasExtra("param") Then
		myParam = StartingIntent.GetExtra("param")
	Else
		myParam = ""
	End If
	Select myTask
		Case "query"
			' myParam here is date in format yyyyMMdd
			Dim url As String = getUrlFromOneDate(myParam)
			sendBack4AppReq(url)
		Case "delete"
			' myParam here is the objectId
			Dim url_2 As String = "https://parseapi.back4app.com/classes/Production/" & myParam
			sendBack4AppDelete(url_2)
			
	End Select
End Sub

Sub Service_Destroy

End Sub

Private Sub sendBack4AppReq(url As String)
	Job.initialize("query", Me)
	Job.Download(url)
	Job.GetRequest.SetHeader("X-Parse-Application-Id", modCommon.appid)
	Job.GetRequest.SetHeader("X-Parse-REST-API-Key", modCommon.apikey)
	Job.GetRequest.SetHeader("X-Parse-Master-Key", modCommon.masterkey)
End Sub

Private Sub sendBack4AppDelete(url As String)
	Job.Initialize("delete", Me)
	Job.Delete(url)
	Job.GetRequest.SetHeader("X-Parse-Application-Id", modCommon.appid)
	Job.GetRequest.SetHeader("X-Parse-REST-API-Key", modCommon.apikey)
End Sub

Private Sub JobDone(j As HttpJob)
	If j.JobName = "delete" Then
		jobdoneForDelete(j)
	End If
	If j.JobName = "query" Then
		jobdoneForQuery(j)
	End If	
	j.Release
End Sub

Private Sub jobdoneForDelete(j As HttpJob)
	If j.Success Then
		Dim jResponse As String = j.GetString
		Log(jResponse)
		Try
			CallSubDelayed2(mySender, "getDeletedResponse", True)
		Catch
			Log(LastException)
			CallSubDelayed2(mySender, "getDeletedResponse", False)
		End Try
	Else
		CallSubDelayed2(mySender, "getDeletedResponse", False)
	End If
End Sub

Private Sub jobdoneForQuery(j As HttpJob)
	If j.Success Then
		Dim jResponse As String = j.GetString
		Log(jResponse)
		Try
			Dim jparser As JSONParser
			jparser.Initialize(jResponse)
			Dim map1 As Map = jparser.Nextobject
			lstOfProduction = map1.Get("results")
			CallSubDelayed2(mySender, "getQueryResponse", CreateMap("issuccess": True, "datalist": lstOfProduction))
		Catch
			Log(LastException)
			CallSubDelayed2(mySender, "getQueryResponse", CreateMap("issuccess": False, "errmsg": LastException.Message))
		End Try
	Else
		CallSubDelayed2(mySender, "getQueryResponse", CreateMap("issuccess": False, "errmsg": "Network access error"))
	End If
End Sub

' datecode must be in format yyyyMMdd
Private Sub getUrlFromOneDate(datecode As String) As String
	
	If IsNumber(datecode) = False Or datecode.Length <> 8 Then
		Return ""
	End If	
	' dd/MM/yyyy 00:00:00+8:00
	Dim dt1 As String = getThisDay(datecode)
	' 10/10/2022 01:41:00+08:00
	Dim dt2 As String = getAddOneDay(datecode)
	Dim url As String = "https://parseapi.back4app.com/classes/Production?" & _
		$"where={"packingdt":{"${Chr(36)}gt":"${dt1}","${Chr(36)}lt":"${dt2}"}}"$ & _
		$"&order=itemnum"$
	Log(url)
	Return url
End Sub

Private Sub getThisDay(datecode As String) As String
	If IsNumber(datecode) = False Or datecode.Length <> 8 Then
		Return ""
	End If
	Return datecode.SubString(6) & "/" & datecode.SubString2(4, 6) & "/" & datecode.SubString2(0, 4) & " 00:00:00+8:00"
End Sub

' datecode must be in format yyyyMMdd
Private Sub getAddOneDay(datecode As String) As String
	If IsNumber(datecode) = False Or datecode.Length <> 8 Then
		Return ""
	End If
	Dim OneDayAdded As String = ""
	' original date format
	Dim df As String = DateTime.DateFormat
	DateTime.DateFormat = "yyyyMMdd"
	Try
		Dim dt1 As Long = DateTime.DateParse(datecode)
		Dim dt2 As Long = DateTime.Add(dt1, 0, 0, 1)
		DateTime.DateFormat = "dd/MM/yyyy"
		Dim date1 As String = DateTime.Date(dt2)
		OneDayAdded = date1 & " 00:00:00+8:00"
	Catch
		Log(LastException)
		OneDayAdded = ""
	End Try
	' Restore the original date format
	DateTime.DateFormat = df
	Return OneDayAdded
	
End Sub
