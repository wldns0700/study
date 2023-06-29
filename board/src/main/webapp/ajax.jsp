<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<script>
$(function() {
	  $.ajax({
	    url: "https://cors-anywhere.herokuapp.com/http://ws.bus.go.kr/api/rest/arrive/getArrInfoByRouteAll",
	    data: {
	      serviceKey: "qpUd12T1/D7jrYvoAMBNZowmsKD9WqffEjj+0lRdUe4meLLnMFPBobj/MhHXXAqwRtLTh52POqkT9tR7vd5Hbw==",
	      busRouteId: "100100118",
	      resultType: "json"
	    },
	    success: function(data) {
	      console.log(data); 
	      const itemList = data.msgBody.itemList;
	      let resultString = "";

	      for (let i = 0; i < itemList.length; i++) {
	        const item = itemList[i];
	        const fullPath = item.rtNm + " " + item.busRouteAbrv + " - " + item.stNm;
	        resultString += fullPath + "<br>";
	      }
	      
	      $("div").html(resultString);
	      
	      // Get the busRouteId from the response and update the parameter
	      const busRouteId = data.msgBody.itemList[0].busRouteId; // Assuming the busRouteId is the same for all items
	      updateBusRouteId(busRouteId);
	    }
	  });

	});


</script>
<div></div>
