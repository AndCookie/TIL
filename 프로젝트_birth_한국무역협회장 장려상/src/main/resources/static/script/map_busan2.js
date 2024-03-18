/**
 * 
 */
var areas = [
    {
        name : 'N1',
        path : [
            new kakao.maps.LatLng(35.07641667, 129.0333333),
            new kakao.maps.LatLng(35.07641667, 129.0393056),
            new kakao.maps.LatLng(35.06713889, 129.0530833),
            new kakao.maps.LatLng(35.06713889, 129.0344167)
        ]
    }, {
        name : 'N2',
        path : [
            new kakao.maps.LatLng(35.07644444, 129.0265278),
            new kakao.maps.LatLng(35.07644444, 129.0315),
            new kakao.maps.LatLng(35.053, 129.0312222),
            new kakao.maps.LatLng(35.05294444, 129.0172778),
            new kakao.maps.LatLng(35.06147222, 129.0249167),
            new kakao.maps.LatLng(35.07413889, 129.0249167)
        ]
    }, {
        name : 'N3',
        path : [
            new kakao.maps.LatLng(35.06713889, 129.0344167),
            new kakao.maps.LatLng(35.06713889, 129.0530833),
            new kakao.maps.LatLng(35.04886111, 129.0800556),
            new kakao.maps.LatLng(35.04430556, 129.0370833)
        ]
    }, {
        name : 'N4',
        path : [
            new kakao.maps.LatLng(35.04430556, 129.0370833),
            new kakao.maps.LatLng(35.04886111, 129.0800556),
            new kakao.maps.LatLng(35.036, 129.0899167),
            new kakao.maps.LatLng(35.02686111, 129.0439167)
        ]
    }, {
        name : 'N5',
        path : [
            new kakao.maps.LatLng(35.02686111, 129.0439167),
            new kakao.maps.LatLng(35.036, 129.0899167),
            new kakao.maps.LatLng(35.00313889, 129.0800278),
            new kakao.maps.LatLng(35.00319444, 129.0439167)
        ]
    }
];

var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(35.039778240155435, 129.13984993578597), //지도의 중심좌표.
	draggable: false,
	level: 8 //지도의 레벨(확대, 축소 정도)
};

//지도 생성 및 객체 리턴
var map = new kakao.maps.Map(container, options),
	customOverlay = new kakao.maps.CustomOverlay({}); 

// 폴리곤 표시
var n1 = new kakao.maps.Polygon({
    map: map,
    path: areas[0].path,
    strokeWeight: 2,
    strokeColor: '#004c80',
    strokeOpacity: 0.8,
    fillColor: '#fff',
    fillOpacity: 0.7 
});

var n2 = new kakao.maps.Polygon({
    map: map,
    path: areas[1].path,
    strokeWeight: 2,
    strokeColor: '#004c80',
    strokeOpacity: 0.8,
    fillColor: '#fff',
    fillOpacity: 0.7 
});

var n3 = new kakao.maps.Polygon({
    map: map,
    path: areas[2].path,
    strokeWeight: 2,
    strokeColor: '#004c80',
    strokeOpacity: 0.8,
    fillColor: '#fff',
    fillOpacity: 0.7 
});

var n4 = new kakao.maps.Polygon({
    map: map,
    path: areas[3].path,
    strokeWeight: 2,
    strokeColor: '#004c80',
    strokeOpacity: 0.8,
    fillColor: '#fff',
    fillOpacity: 0.7 
});

var n5 = new kakao.maps.Polygon({
    map: map,
    path: areas[4].path,
    strokeWeight: 2,
    strokeColor: '#004c80',
    strokeOpacity: 0.8,
    fillColor: '#fff',
    fillOpacity: 0.7 
});


//이벤트 등록
kakao.maps.event.addListener(n1, 'click', function() {
	n1.setOptions({fillColor: 'blue'});
	n2.setOptions({fillColor: '#fff'});
	n3.setOptions({fillColor: '#fff'});
	n4.setOptions({fillColor: '#fff'});
	n5.setOptions({fillColor: '#fff'});
	
    var content = '<div class="info">' + 
                  '  <ul>'+
                  '		<li>'+
                  '   		<span class="iTitle">정박지 이름</span>'+
                  '   		<span class="iBody">' + areas[0].name + '</span>' +
                  '		</li>'+
                  '		<li>'+
            	  '		<span class="iTitle">주묘 위험</span>' +
				  '			<table class="risk">' +
				  '			<tr>'+
				  '				<th style="background-color: blue; color:white; border: 1px solid #ccc;"><span class="danger">&nbsp; 안전 &nbsp;</span></th>'+			
				  '				<th style="border: 1px solid #ccc;"><span class="danger" id="result">&nbsp; 주의 &nbsp;</span></th>'+
				  '				<th style="border: 1px solid #ccc;"><span class="danger">&nbsp; 위험 &nbsp;</span></th>'+
				  '			</tr>'+
				  '		</table>'+
                  '		</li>'+
                  '		<li>'+
                  '   		<span class="iTitle">확률</span>'+
				  '			<span class="iBody"><b>32%</b></span>'+
                  '		</li>'+
                  '		<li>'+
	  			  '			<span class="iTitle">행동요령</span>'+
                  '		</li>'+
	       		  '   </ul>' +
	       		  
				  '	<ol>'+
				  '		<li>주변 환경을 주의 깊게 살피세요. 해상 조건, 바닥 지형, 해류, 바람의 강도 등을 평가합니다.</li>'+
				  '		<li>필요한 경우, 추가적인 정찰 또는 정보 수집을 위해 다른 선원과 협력하세요.</li>'+
				  '		<li>닻 고정 시설물을 신중하게 선택하고, 테스트 및 점검하여 안전한 곳에 닻을 끌어 넣으세요.</li>'+
				  '	</ol>'+
                  '	</div>';
    var position = new kakao.maps.LatLng(34.985, 129.2017)
    var removeable = true;

	var infowindow = new kakao.maps.InfoWindow({
	    map: map,
	    position : position, 
	    content : content,
	    removable : removeable
	})

})

kakao.maps.event.addListener(n2, 'click', function() {
	n1.setOptions({fillColor: '#fff'});
	n2.setOptions({fillColor: 'yellow'});
	n3.setOptions({fillColor: '#fff'});
	n4.setOptions({fillColor: '#fff'});
	n5.setOptions({fillColor: '#fff'});
	
    var content = '<div class="info">' + 
                  '  <ul>'+
                  '		<li>'+
                  '   		<span class="iTitle">정박지 이름</span>'+
                  '   		<span class="iBody">' + areas[1].name + '</span>' +
                  '		</li>'+
                  '		<li>'+
            	  '		<span class="iTitle">주묘 위험</span>' +
				  '			<table class="risk">' +
				  '			<tr>'+
				  '				<th style="border: 1px solid #ccc;"><span class="danger">&nbsp; 안전 &nbsp;</span></th>'+			
				  '				<th style="background-color: yellow; border: 1px solid #ccc;"><span class="danger" id="result">&nbsp; 주의 &nbsp;</span></th>'+
				  '				<th style="border: 1px solid #ccc;"><span class="danger">&nbsp; 위험 &nbsp;</span></th>'+
				  '			</tr>'+
				  '		</table>'+
                  '		</li>'+
                  '		<li>'+
                  '   		<span class="iTitle">확률</span>'+
				  '			<span class="iBody"><b>57%</b></span>'+
                  '		</li>'+
                  '		<li>'+
	  			  '			<span class="iTitle">행동요령</span>'+
                  '		</li>'+
	       		  '   </ul>' +
	       		  
				  '	<ol>'+
				  '		<li>날씨 변화 및 기상 조건에 대한 예측과 모니터링을 강화하세요. 지속적인 날씨 업데이트를 확인하세요.</li>'+
				  '		<li>선박의 위치와 닻의 고정 상태를 주기적으로 확인하고, 필요한 경우 추가적인 앵커를 사용하여 안정성을 강화하세요.</li>'+
				  '		<li>닻 끌림 가능성이 높아질 경우, 조기에 대비하고 비상 대책을 마련하세요. 필요한 경우 더욱 견고한 앵커 시스템을 마련하고 전문가의 도움을 받으세요.</li>'+
				  '	</ol>'+
                  '	</div>';

    var position = new kakao.maps.LatLng(34.985, 129.2017)
    var removeable = true;

	var infowindow = new kakao.maps.InfoWindow({
	    map: map,
	    position : position, 
	    content : content,
	    removable : removeable
	})

})

kakao.maps.event.addListener(n3, 'click', function() {
	n1.setOptions({fillColor: '#fff'});
	n2.setOptions({fillColor: '#fff'});
	n3.setOptions({fillColor: 'blue'});
	n4.setOptions({fillColor: '#fff'});
	n5.setOptions({fillColor: '#fff'});
    
    var content = '<div class="info">' + 
                  '  <ul>'+
                  '		<li>'+
                  '   		<span class="iTitle">정박지 이름</span>'+
                  '   		<span class="iBody">' + areas[2].name + '</span>' +
                  '		</li>'+
                  '		<li>'+
            	  '		<span class="iTitle">주묘 위험</span>' +
				  '			<table class="risk">' +
				  '			<tr>'+
				  '				<th style="background-color: blue; color:white; border: 1px solid #ccc;"><span class="danger">&nbsp; 안전 &nbsp;</span></th>'+			
				  '				<th style="border: 1px solid #ccc;"><span class="danger" id="result">&nbsp; 주의 &nbsp;</span></th>'+
				  '				<th style="border: 1px solid #ccc;"><span class="danger">&nbsp; 위험 &nbsp;</span></th>'+
				  '			</tr>'+
				  '		</table>'+
                  '		</li>'+
                  '		<li>'+
                  '   		<span class="iTitle">확률</span>'+
				  '			<span class="iBody"><b>17%</b></span>'+
                  '		</li>'+
                  '		<li>'+
	  			  '			<span class="iTitle">행동요령</span>'+
                  '		</li>'+
	       		  '   </ul>' +
	       		  
				  '	<ol>'+
				  '		<li>주변 환경을 주의 깊게 살피세요. 해상 조건, 바닥 지형, 해류, 바람의 강도 등을 평가합니다.</li>'+
				  '		<li>필요한 경우, 추가적인 정찰 또는 정보 수집을 위해 다른 선원과 협력하세요.</li>'+
				  '		<li>닻 고정 시설물을 신중하게 선택하고, 테스트 및 점검하여 안전한 곳에 닻을 끌어 넣으세요.</li>'+
				  '	</ol>'+
                  '	</div>';

    var position = new kakao.maps.LatLng(34.985, 129.2017)
    var removeable = true;

	var infowindow = new kakao.maps.InfoWindow({
	    map: map,
	    position : position, 
	    content : content,
	    removable : removeable
	})
})

kakao.maps.event.addListener(n4, 'click', function() {
	n1.setOptions({fillColor: '#fff'});
	n2.setOptions({fillColor: '#fff'});
	n3.setOptions({fillColor: '#fff'});
	n4.setOptions({fillColor: 'blue'});
	n5.setOptions({fillColor: '#fff'});
	
    var content = '<div class="info">' + 
                  '  <ul>'+
                  '		<li>'+
                  '   		<span class="iTitle">정박지 이름</span>'+
                  '   		<span class="iBody">' + areas[3].name + '</span>' +
                  '		</li>'+
                  '		<li>'+
            	  '		<span class="iTitle">주묘 위험</span>' +
				  '			<table class="risk">' +
				  '			<tr>'+
				  '				<th style="background-color: blue; color:white; border: 1px solid #ccc;"><span class="danger">&nbsp; 안전 &nbsp;</span></th>'+			
				  '				<th style="border: 1px solid #ccc;"><span class="danger" id="result">&nbsp; 주의 &nbsp;</span></th>'+
				  '				<th style="border: 1px solid #ccc;"><span class="danger">&nbsp; 위험 &nbsp;</span></th>'+
				  '			</tr>'+
				  '		</table>'+
                  '		</li>'+
                  '		<li>'+
                  '   		<span class="iTitle">확률</span>'+
				  '			<span class="iBody"><b>11%</b></span>'+
                  '		</li>'+
                  '		<li>'+
	  			  '			<span class="iTitle">행동요령</span>'+
                  '		</li>'+
	       		  '   </ul>' +
	       		  
				  '	<ol>'+
		  		  '		<li>주변 환경을 주의 깊게 살피세요. 해상 조건, 바닥 지형, 해류, 바람의 강도 등을 평가합니다.</li>'+
				  '		<li>필요한 경우, 추가적인 정찰 또는 정보 수집을 위해 다른 선원과 협력하세요.</li>'+
				  '		<li>닻 고정 시설물을 신중하게 선택하고, 테스트 및 점검하여 안전한 곳에 닻을 끌어 넣으세요.</li>'+
				  '	</ol>'+
                  '	</div>';

    var position = new kakao.maps.LatLng(34.985, 129.2017)
    var removeable = true;

	var infowindow = new kakao.maps.InfoWindow({
	    map: map,
	    position : position, 
	    content : content,
	    removable : removeable
	})
})

kakao.maps.event.addListener(n5, 'click', function() {
	n1.setOptions({fillColor: '#fff'});
	n2.setOptions({fillColor: '#fff'});
	n3.setOptions({fillColor: '#fff'});
	n4.setOptions({fillColor: '#fff'});
	n5.setOptions({fillColor: 'blue'});
	
    var content = '<div class="info">' + 
                  '  <ul>'+
                  '		<li>'+
                  '   		<span class="iTitle">정박지 이름</span>'+
                  '   		<span class="iBody">' + areas[4].name + '</span>' +
                  '		</li>'+
                  '		<li>'+
            	  '		<span class="iTitle">주묘 위험</span>' +
				  '			<table class="risk">' +
				  '			<tr>'+
				  '				<th style="background-color: blue; color:white; border: 1px solid #ccc;"><span class="danger">&nbsp; 안전 &nbsp;</span></th>'+			
				  '				<th style="border: 1px solid #ccc;"><span class="danger" id="result">&nbsp; 주의 &nbsp;</span></th>'+
				  '				<th style="border: 1px solid #ccc;"><span class="danger">&nbsp; 위험 &nbsp;</span></th>'+
				  '			</tr>'+
				  '		</table>'+
                  '		</li>'+
                  '		<li>'+
                  '   		<span class="iTitle">확률</span>'+
				  '			<span class="iBody"><b>8%</b></span>'+
                  '		</li>'+
                  '		<li>'+
	  			  '			<span class="iTitle">행동요령</span>'+
                  '		</li>'+
	       		  '   </ul>' +
	       		  
				  '	<ol>'+
				  '		<li>주변 환경을 주의 깊게 살피세요. 해상 조건, 바닥 지형, 해류, 바람의 강도 등을 평가합니다.</li>'+
				  '		<li>필요한 경우, 추가적인 정찰 또는 정보 수집을 위해 다른 선원과 협력하세요.</li>'+
				  '		<li>닻 고정 시설물을 신중하게 선택하고, 테스트 및 점검하여 안전한 곳에 닻을 끌어 넣으세요.</li>'+
				  '	</ol>'+
                  '	</div>';

    var position = new kakao.maps.LatLng(34.985, 129.2017)
    var removeable = true;

	var infowindow = new kakao.maps.InfoWindow({
	    map: map,
	    position : position, 
	    content : content,
	    removable : removeable

	})
})				