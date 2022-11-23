B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=11.8
@EndOfDesignText@
Sub Class_Globals
	
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize
	
End Sub
' Change map of finished product from production record to string
Public Sub mapToString(i_map As Map) As String
	
	If i_map.IsInitialized = False Then
		Return ""
	End If
'	{
'		"objectId": "n0yBVvsvNx",
'		"itemnum": "120016",
'		"itemname": "Japan Wagyu Dice",
'		"itemname2": "日本和牛粒",
'		"itemuom": "100g",
'		"itemuom2": 100,
'		"itemstandardweight": 200,
'		"itemprice": 38,
'		"weightingram": 102.2,
'		"sellingprice": 38.8,
'		"barcode": "012001600388010224",
'		"packingdt": "21/11/2022 07:55:24 GMT+08:00",
'		"createdAt": "2022-11-20T23:55:24.506Z",
'		"updatedAt": "2022-11-20T23:55:24.506Z"
'	}
	Dim objSb As StringBuilder
	objSb.Initialize
	If i_map.ContainsKey("objectId") Then objSb.Append("Object Id: ").Append(i_map.Get("objectId")).Append(CRLF)
	If i_map.ContainsKey("itemnum") Then objSb.Append("Item No: ").Append(i_map.Get("itemnum")).Append(CRLF)
	If i_map.ContainsKey("itemname") Then objSb.Append("Item Name: ").Append(i_map.Get("itemname")).Append(CRLF)
	If i_map.ContainsKey("itemname2") Then objSb.Append("Item Name2: ").Append(i_map.Get("itemname2")).Append(CRLF)
	If i_map.ContainsKey("itemuom") Then objSb.Append("Item Unit: ").Append(i_map.Get("itemuom")).Append(CRLF)
	If i_map.ContainsKey("itemstandardweight") Then objSb.Append("Std Weight: ").Append(i_map.Get("itemstandardweight")).Append("g").Append(CRLF)
	If i_map.ContainsKey("itemprice") Then objSb.Append("Price per ").Append("itemnum").Append(": $").Append(i_map.Get("itemprice")).Append(CRLF)
	If i_map.ContainsKey("weightingram") Then objSb.Append("Weight: ").Append(i_map.Get("weightingram")).Append("g").Append(CRLF)
	If i_map.ContainsKey("sellingprice") Then objSb.Append("Selling Price: $").Append(i_map.Get("sellingprice")).Append(CRLF)
	If i_map.ContainsKey("barcode") Then objSb.Append("Barcode: ").Append(i_map.Get("barcode")).Append(CRLF)
	If i_map.ContainsKey("packingdt") Then objSb.Append("Packing Date: ").Append(i_map.Get("packingdt").As(String).SubString2(0, 19))
	Return objSb.ToString
End Sub