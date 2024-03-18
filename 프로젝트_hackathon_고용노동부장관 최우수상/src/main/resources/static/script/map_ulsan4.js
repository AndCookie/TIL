/**
 * 
 */
var areas = [
    {
        name : 'M1',
        path : [
            new kakao.maps.LatLng(35.500222, 129.394167),
            new kakao.maps.LatLng(35.495583, 129.394778),
            new kakao.maps.LatLng(35.495583, 129.404611),
            new kakao.maps.LatLng(35.498556, 129.402194)
        ]
    }, {
        name : 'M2',
        path : [
            new kakao.maps.LatLng(35.495583, 129.394778),
            new kakao.maps.LatLng(35.492694, 129.395139),
            new kakao.maps.LatLng(35.491861, 129.395278),
            new kakao.maps.LatLng(35.491861, 129.400361),
            new kakao.maps.LatLng(35.495583, 129.399889)
        ]
    }, {
        name : 'M3',
        path : [
            new kakao.maps.LatLng(35.491861, 129.405722),
            new kakao.maps.LatLng(35.493167, 129.406556),
            new kakao.maps.LatLng(35.495583, 129.404611),
            new kakao.maps.LatLng(35.495583, 129.399889),
            new kakao.maps.LatLng(35.491861, 129.400361)
        ]
    }, {
        name : 'M4',
        path : [
            new kakao.maps.LatLng(35.491861, 129.395278),
            new kakao.maps.LatLng(35.488056, 129.395917),
            new kakao.maps.LatLng(35.488056, 129.403333),
            new kakao.maps.LatLng(35.491861, 129.405722)
        ]
    }, {
        name : 'M5',
        path : [
            new kakao.maps.LatLng(35.488056, 129.395917),
            new kakao.maps.LatLng(35.484250, 129.396583),
            new kakao.maps.LatLng(35.484250, 129.402639),
            new kakao.maps.LatLng(35.486889, 129.402611),
            new kakao.maps.LatLng(35.488056, 129.403333)
        ]
    }, {
        name : 'M6',
        path : [
            new kakao.maps.LatLng(35.484250, 129.396583),
            new kakao.maps.LatLng(35.480444, 129.397222),
            new kakao.maps.LatLng(35.480444, 129.402639),
            new kakao.maps.LatLng(35.484250, 129.402639)
        ]
    }, {
        name : 'M7',
        path : [
            new kakao.maps.LatLng(35.480444, 129.397222),
            new kakao.maps.LatLng(35.476417, 129.397917),
            new kakao.maps.LatLng(35.476417, 129.402639),
            new kakao.maps.LatLng(35.480444, 129.402639)
        ]
    }, {
        name : 'E1',
        path : [
            new kakao.maps.LatLng(35.466389, 129.414278),
            new kakao.maps.LatLng(35.466389, 129.426306),
            new kakao.maps.LatLng(35.446306, 129.463694),
            new kakao.maps.LatLng(35.437111, 129.410972),
            new kakao.maps.LatLng(35.462056, 129.401306)
        ]
    }, {
        name : 'E2',
        path : [
            new kakao.maps.LatLng(35.437111, 129.410972),
            new kakao.maps.LatLng(35.446306, 129.463694),
            new kakao.maps.LatLng(35.424944, 129.473861),
            new kakao.maps.LatLng(35.420194, 129.417528)
        ]
    }, {
        name : 'E3',
        path : [
            new kakao.maps.LatLng(35.420194, 129.417528),
            new kakao.maps.LatLng(35.424944, 129.473861),
            new kakao.maps.LatLng(35.384028, 129.457333),
            new kakao.maps.LatLng(35.403056, 129.424167)
        ]
    }
    
];

var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(35.45575823276814,129.51978312963755), //지도의 중심좌표.
	level: 8 //지도의 레벨(확대, 축소 정도)
};

//지도 생성 및 객체 리턴
var map = new kakao.maps.Map(container, options),
	customOverlay = new kakao.maps.CustomOverlay({}); 

// 폴리곤 표시
var m1 = new kakao.maps.Polygon({
    map: map,
    path: areas[0].path,
    strokeWeight: 2,
    strokeColor: '#004c80',
    strokeOpacity: 0.8,
    fillColor: '#fff',
    fillOpacity: 0.7 
});

var m2 = new kakao.maps.Polygon({
    map: map,
    path: areas[1].path,
    strokeWeight: 2,
    strokeColor: '#004c80',
    strokeOpacity: 0.8,
    fillColor: '#fff',
    fillOpacity: 0.7 
});

var m3 = new kakao.maps.Polygon({
    map: map,
    path: areas[2].path,
    strokeWeight: 2,
    strokeColor: '#004c80',
    strokeOpacity: 0.8,
    fillColor: '#fff',
    fillOpacity: 0.7 
});

var m4 = new kakao.maps.Polygon({
    map: map,
    path: areas[3].path,
    strokeWeight: 2,
    strokeColor: '#004c80',
    strokeOpacity: 0.8,
    fillColor: '#fff',
    fillOpacity: 0.7 
});

var m5 = new kakao.maps.Polygon({
    map: map,
    path: areas[4].path,
    strokeWeight: 2,
    strokeColor: '#004c80',
    strokeOpacity: 0.8,
    fillColor: '#fff',
    fillOpacity: 0.7 
});

var m6 = new kakao.maps.Polygon({
    map: map,
    path: areas[5].path,
    strokeWeight: 2,
    strokeColor: '#004c80',
    strokeOpacity: 0.8,
    fillColor: '#fff',
    fillOpacity: 0.7 
});

var m7 = new kakao.maps.Polygon({
    map: map,
    path: areas[6].path,
    strokeWeight: 2,
    strokeColor: '#004c80',
    strokeOpacity: 0.8,
    fillColor: '#fff',
    fillOpacity: 0.7 
});

var e1 = new kakao.maps.Polygon({
    map: map,
    path: areas[7].path,
    strokeWeight: 2,
    strokeColor: '#004c80',
    strokeOpacity: 0.8,
    fillColor: '#fff',
    fillOpacity: 0.7 
});

var e1 = new kakao.maps.Polygon({
    map: map,
    path: areas[7].path,
    strokeWeight: 2,
    strokeColor: '#004c80',
    strokeOpacity: 0.8,
    fillColor: '#fff',
    fillOpacity: 0.7 
});

var e2 = new kakao.maps.Polygon({
    map: map,
    path: areas[8].path,
    strokeWeight: 2,
    strokeColor: '#004c80',
    strokeOpacity: 0.8,
    fillColor: '#fff',
    fillOpacity: 0.7 
});

var e3 = new kakao.maps.Polygon({
    map: map,
    path: areas[9].path,
    strokeWeight: 2,
    strokeColor: '#004c80',
    strokeOpacity: 0.8,
    fillColor: '#fff',
    fillOpacity: 0.7 
});

// 지도에 표시할 원을 생성합니다
var w1 = new kakao.maps.Circle({
    center : new kakao.maps.LatLng(35.454722, 129.389722),  // 원의 중심좌표 입니다 
    radius: 400, // 미터 단위의 원의 반지름입니다 
    strokeWeight: 2,
    strokeColor: '#004c80',
    strokeOpacity: 0.8,
    fillColor: '#fff',
    fillOpacity: 0.7 
});  

var t1 = new kakao.maps.Circle({
    center : new kakao.maps.LatLng(35.510361, 129.454917),
    radius: 300, // 미터 단위의 원의 반지름입니다 
    strokeWeight: 2,
    strokeColor: '#004c80',
    strokeOpacity: 0.8,
    fillColor: '#fff',
    fillOpacity: 0.7 
}); 

var t2 = new kakao.maps.Circle({
    center : new kakao.maps.LatLng(35.515833, 129.454917), 
    radius: 300, 
    strokeWeight: 2,
    strokeColor: '#004c80',
    strokeOpacity: 0.8,
    fillColor: '#fff',
    fillOpacity: 0.7 
}); 

var t3 = new kakao.maps.Circle({
    center : new kakao.maps.LatLng(35.527833, 129.459444), 
    radius: 250,
    strokeWeight: 2,
    strokeColor: '#004c80',
    strokeOpacity: 0.8,
    fillColor: '#fff',
    fillOpacity: 0.7 
}); 


w1.setMap(map);
t1.setMap(map); 
t2.setMap(map); 
t3.setMap(map); 

//이벤트 등록
kakao.maps.event.addListener(m1, 'click', function() {
	m1.setOptions({fillColor: 'blue'});
	m2.setOptions({fillColor: '#fff'});
	m3.setOptions({fillColor: '#fff'});
	m4.setOptions({fillColor: '#fff'});
	m5.setOptions({fillColor: '#fff'});
	m6.setOptions({fillColor: '#fff'});
	m7.setOptions({fillColor: '#fff'});
	
	e1.setOptions({fillColor: '#fff'});
	e2.setOptions({fillColor: '#fff'});
	e3.setOptions({fillColor: '#fff'});
	
	w1.setOptions({fillColor: '#fff'});
	t1.setOptions({fillColor: '#fff'});
	t2.setOptions({fillColor: '#fff'});
	t3.setOptions({fillColor: '#fff'});
	
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
				  '			<span class="iBody"><b>29%</b></span>'+
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
                  
    var position = new kakao.maps.LatLng(35.383, 129.576)
    var removeable = true;

	var infowindow = new kakao.maps.InfoWindow({
	    map: map,
	    position : position, 
	    content : content,
	    removable : removeable
	})
    
});

kakao.maps.event.addListener(m2, 'click', function() {
	m1.setOptions({fillColor: '#fff'});
	m2.setOptions({fillColor: 'blue'});
	m3.setOptions({fillColor: '#fff'});
	m4.setOptions({fillColor: '#fff'});
	m5.setOptions({fillColor: '#fff'});
	m6.setOptions({fillColor: '#fff'});
	m7.setOptions({fillColor: '#fff'});
	
	e1.setOptions({fillColor: '#fff'});
	e2.setOptions({fillColor: '#fff'});
	e3.setOptions({fillColor: '#fff'});
	
	w1.setOptions({fillColor: '#fff'});
	t1.setOptions({fillColor: '#fff'});
	t2.setOptions({fillColor: '#fff'});
	t3.setOptions({fillColor: '#fff'});
	
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
				  '				<th style="background-color: blue; color:white; border: 1px solid #ccc;"><span class="danger">&nbsp; 안전 &nbsp;</span></th>'+			
				  '				<th style="border: 1px solid #ccc;"><span class="danger" id="result">&nbsp; 주의 &nbsp;</span></th>'+
				  '				<th style="border: 1px solid #ccc;"><span class="danger">&nbsp; 위험 &nbsp;</span></th>'+
				  '			</tr>'+
				  '		</table>'+
                  '		</li>'+
                  '		<li>'+
                  '   		<span class="iTitle">확률</span>'+
				  '			<span class="iBody"><b>30%</b></span>'+
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
                  
    var position = new kakao.maps.LatLng(35.383, 129.576)
    var removeable = true;

	var infowindow = new kakao.maps.InfoWindow({
	    map: map,
	    position : position, 
	    content : content,
	    removable : removeable
	})
});

kakao.maps.event.addListener(m3, 'click', function() {
	m1.setOptions({fillColor: '#fff'});
	m2.setOptions({fillColor: '#fff'});
	m3.setOptions({fillColor: 'blue'});
	m4.setOptions({fillColor: '#fff'});
	m5.setOptions({fillColor: '#fff'});
	m6.setOptions({fillColor: '#fff'});
	m7.setOptions({fillColor: '#fff'});
	
	e1.setOptions({fillColor: '#fff'});
	e2.setOptions({fillColor: '#fff'});
	e3.setOptions({fillColor: '#fff'});
	
	w1.setOptions({fillColor: '#fff'});
	t1.setOptions({fillColor: '#fff'});
	t2.setOptions({fillColor: '#fff'});
	t3.setOptions({fillColor: '#fff'});
	
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
				  '			<span class="iBody"><b>31%</b></span>'+
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
                  
    var position = new kakao.maps.LatLng(35.383, 129.576)
    var removeable = true;

	var infowindow = new kakao.maps.InfoWindow({
	    map: map,
	    position : position, 
	    content : content,
	    removable : removeable
	})
});

kakao.maps.event.addListener(m4, 'click', function() {
	m1.setOptions({fillColor: '#fff'});
	m2.setOptions({fillColor: '#fff'});
	m3.setOptions({fillColor: '#fff'});
	m4.setOptions({fillColor: 'blue'});
	m5.setOptions({fillColor: '#fff'});
	m6.setOptions({fillColor: '#fff'});
	m7.setOptions({fillColor: '#fff'});
	
	e1.setOptions({fillColor: '#fff'});
	e2.setOptions({fillColor: '#fff'});
	e3.setOptions({fillColor: '#fff'});
	
	w1.setOptions({fillColor: '#fff'});
	t1.setOptions({fillColor: '#fff'});
	t2.setOptions({fillColor: '#fff'});
	t3.setOptions({fillColor: '#fff'});
	
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
				  '				<th style="border: 1px solid #ccc;"><span class="danger">&nbsp; 안전 &nbsp;</span></th>'+			
				  '				<th style="background-color: yellow; border: 1px solid #ccc;"><span class="danger" id="result">&nbsp; 주의 &nbsp;</span></th>'+
				  '				<th style="border: 1px solid #ccc;"><span class="danger">&nbsp; 위험 &nbsp;</span></th>'+
				  '			</tr>'+
				  '		</table>'+
                  '		</li>'+
                  '		<li>'+
                  '   		<span class="iTitle">확률</span>'+
				  '			<span class="iBody"><b>34%</b></span>'+
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
                  
    var position = new kakao.maps.LatLng(35.383, 129.576)
    var removeable = true;

	var infowindow = new kakao.maps.InfoWindow({
	    map: map,
	    position : position, 
	    content : content,
	    removable : removeable
	})
});

kakao.maps.event.addListener(m5, 'click', function() {
	m1.setOptions({fillColor: '#fff'});
	m2.setOptions({fillColor: '#fff'});
	m3.setOptions({fillColor: '#fff'});
	m4.setOptions({fillColor: '#fff'});
	m5.setOptions({fillColor: 'blue'});
	m6.setOptions({fillColor: '#fff'});
	m7.setOptions({fillColor: '#fff'});
	
	e1.setOptions({fillColor: '#fff'});
	e2.setOptions({fillColor: '#fff'});
	e3.setOptions({fillColor: '#fff'});
	
	w1.setOptions({fillColor: '#fff'});
	t1.setOptions({fillColor: '#fff'});
	t2.setOptions({fillColor: '#fff'});
	t3.setOptions({fillColor: '#fff'});
	
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
                  
    var position = new kakao.maps.LatLng(35.383, 129.576)
    var removeable = true;

	var infowindow = new kakao.maps.InfoWindow({
	    map: map,
	    position : position, 
	    content : content,
	    removable : removeable
	})
});

kakao.maps.event.addListener(m6, 'click', function() {
	m1.setOptions({fillColor: '#fff'});
	m2.setOptions({fillColor: '#fff'});
	m3.setOptions({fillColor: '#fff'});
	m4.setOptions({fillColor: '#fff'});
	m5.setOptions({fillColor: '#fff'});
	m6.setOptions({fillColor: 'blue'});
	m7.setOptions({fillColor: '#fff'});
	
	e1.setOptions({fillColor: '#fff'});
	e2.setOptions({fillColor: '#fff'});
	e3.setOptions({fillColor: '#fff'});
	
	w1.setOptions({fillColor: '#fff'});
	t1.setOptions({fillColor: '#fff'});
	t2.setOptions({fillColor: '#fff'});
	t3.setOptions({fillColor: '#fff'});
	
    var content = '<div class="info">' + 
                  '  <ul>'+
                  '		<li>'+
                  '   		<span class="iTitle">정박지 이름</span>'+
                  '   		<span class="iBody">' + areas[5].name + '</span>' +
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
				  '			<span class="iBody"><b>35%</b></span>'+
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
                  
    var position = new kakao.maps.LatLng(35.383, 129.576)
    var removeable = true;

	var infowindow = new kakao.maps.InfoWindow({
	    map: map,
	    position : position, 
	    content : content,
	    removable : removeable
	})
});

kakao.maps.event.addListener(m7, 'click', function() {
	m1.setOptions({fillColor: '#fff'});
	m2.setOptions({fillColor: '#fff'});
	m3.setOptions({fillColor: '#fff'});
	m4.setOptions({fillColor: '#fff'});
	m5.setOptions({fillColor: '#fff'});
	m6.setOptions({fillColor: '#fff'});
	m7.setOptions({fillColor: 'blue'});
	
	e1.setOptions({fillColor: '#fff'});
	e2.setOptions({fillColor: '#fff'});
	e3.setOptions({fillColor: '#fff'});
	
	w1.setOptions({fillColor: '#fff'});
	t1.setOptions({fillColor: '#fff'});
	t2.setOptions({fillColor: '#fff'});
	t3.setOptions({fillColor: '#fff'});
	
    var content = '<div class="info">' + 
                  '  <ul>'+
                  '		<li>'+
                  '   		<span class="iTitle">정박지 이름</span>'+
                  '   		<span class="iBody">M7</span>' +
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
				  '			<span class="iBody"><b>29%</b></span>'+
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
                  
    var position = new kakao.maps.LatLng(35.383, 129.576)
    var removeable = true;

	var infowindow = new kakao.maps.InfoWindow({
	    map: map,
	    position : position, 
	    content : content,
	    removable : removeable
	})
});

kakao.maps.event.addListener(e1, 'click', function() {
	m1.setOptions({fillColor: '#fff'});
	m2.setOptions({fillColor: '#fff'});
	m3.setOptions({fillColor: '#fff'});
	m4.setOptions({fillColor: '#fff'});
	m5.setOptions({fillColor: '#fff'});
	m6.setOptions({fillColor: '#fff'});
	m7.setOptions({fillColor: '#fff'});
	
	e1.setOptions({fillColor: 'blue'});
	e2.setOptions({fillColor: '#fff'});
	e3.setOptions({fillColor: '#fff'});
	
	w1.setOptions({fillColor: '#fff'});
	t1.setOptions({fillColor: '#fff'});
	t2.setOptions({fillColor: '#fff'});
	t3.setOptions({fillColor: '#fff'});
	
    var content = '<div class="info">' + 
                  '  <ul>'+
                  '		<li>'+
                  '   		<span class="iTitle">정박지 이름</span>'+
                  '   		<span class="iBody">E1</span>' +
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
                  
    var position = new kakao.maps.LatLng(35.383, 129.576)
    var removeable = true;

	var infowindow = new kakao.maps.InfoWindow({
	    map: map,
	    position : position, 
	    content : content,
	    removable : removeable
	})
});

kakao.maps.event.addListener(e2, 'click', function() {
	m1.setOptions({fillColor: '#fff'});
	m2.setOptions({fillColor: '#fff'});
	m3.setOptions({fillColor: '#fff'});
	m4.setOptions({fillColor: '#fff'});
	m5.setOptions({fillColor: '#fff'});
	m6.setOptions({fillColor: '#fff'});
	m7.setOptions({fillColor: '#fff'});
	
	e1.setOptions({fillColor: '#fff'});
	e2.setOptions({fillColor: 'blue'});
	e3.setOptions({fillColor: '#fff'});
	
	w1.setOptions({fillColor: '#fff'});
	t1.setOptions({fillColor: '#fff'});
	t2.setOptions({fillColor: '#fff'});
	t3.setOptions({fillColor: '#fff'});
	
    var content = '<div class="info">' + 
                  '  <ul>'+
                  '		<li>'+
                  '   		<span class="iTitle">정박지 이름</span>'+
                  '   		<span class="iBody">E2</span>' +
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
				  '			<span class="iBody"><b>18%</b></span>'+
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
                  
    var position = new kakao.maps.LatLng(35.383, 129.576)
    var removeable = true;

	var infowindow = new kakao.maps.InfoWindow({
	    map: map,
	    position : position, 
	    content : content,
	    removable : removeable
	})
});

kakao.maps.event.addListener(e3, 'click', function() {
	m1.setOptions({fillColor: '#fff'});
	m2.setOptions({fillColor: '#fff'});
	m3.setOptions({fillColor: '#fff'});
	m4.setOptions({fillColor: '#fff'});
	m5.setOptions({fillColor: '#fff'});
	m6.setOptions({fillColor: '#fff'});
	m7.setOptions({fillColor: '#fff'});
	
	e1.setOptions({fillColor: '#fff'});
	e2.setOptions({fillColor: '#fff'});
	e3.setOptions({fillColor: 'blue'});
	
	w1.setOptions({fillColor: '#fff'});
	t1.setOptions({fillColor: '#fff'});
	t2.setOptions({fillColor: '#fff'});
	t3.setOptions({fillColor: '#fff'});
	
    var content = '<div class="info">' + 
                  '  <ul>'+
                  '		<li>'+
                  '   		<span class="iTitle">정박지 이름</span>'+
                  '   		<span class="iBody">E3</span>' +
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
				  '			<span class="iBody"><b>16%</b></span>'+
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
                  
    var position = new kakao.maps.LatLng(35.383, 129.576)
    var removeable = true;

	var infowindow = new kakao.maps.InfoWindow({
	    map: map,
	    position : position, 
	    content : content,
	    removable : removeable
	})
});

kakao.maps.event.addListener(w1, 'click', function() {
	m1.setOptions({fillColor: '#fff'});
	m2.setOptions({fillColor: '#fff'});
	m3.setOptions({fillColor: '#fff'});
	m4.setOptions({fillColor: '#fff'});
	m5.setOptions({fillColor: '#fff'});
	m6.setOptions({fillColor: '#fff'});
	m7.setOptions({fillColor: '#fff'});
	
	e1.setOptions({fillColor: '#fff'});
	e2.setOptions({fillColor: '#fff'});
	e3.setOptions({fillColor: '#fff'});
	
	w1.setOptions({fillColor: 'blue'});
	t1.setOptions({fillColor: '#fff'});
	t2.setOptions({fillColor: '#fff'});
	t3.setOptions({fillColor: '#fff'});
	
    var content = '<div class="info">' + 
                  '  <ul>'+
                  '		<li>'+
                  '   		<span class="iTitle">정박지 이름</span>'+
                  '   		<span class="iBody">W1</span>' +
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
				  '			<span class="iBody"><b>31%</b></span>'+
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
                  
    var position = new kakao.maps.LatLng(35.383, 129.576)
    var removeable = true;

	var infowindow = new kakao.maps.InfoWindow({
	    map: map,
	    position : position, 
	    content : content,
	    removable : removeable
	})
});

kakao.maps.event.addListener(t1, 'click', function() {
	m1.setOptions({fillColor: '#fff'});
	m2.setOptions({fillColor: '#fff'});
	m3.setOptions({fillColor: '#fff'});
	m4.setOptions({fillColor: '#fff'});
	m5.setOptions({fillColor: '#fff'});
	m6.setOptions({fillColor: '#fff'});
	m7.setOptions({fillColor: '#fff'});
	
	e1.setOptions({fillColor: '#fff'});
	e2.setOptions({fillColor: '#fff'});
	e3.setOptions({fillColor: '#fff'});
	
	w1.setOptions({fillColor: '#fff'});
	t1.setOptions({fillColor: 'blue'});
	t2.setOptions({fillColor: '#fff'});
	t3.setOptions({fillColor: '#fff'});
	
    var content = '<div class="info">' + 
                  '  <ul>'+
                  '		<li>'+
                  '   		<span class="iTitle">정박지 이름</span>'+
                  '   		<span class="iBody">T1</span>' +
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
				  '			<span class="iBody"><b>34%</b></span>'+
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
                  
    var position = new kakao.maps.LatLng(35.383, 129.576)
    var removeable = true;

	var infowindow = new kakao.maps.InfoWindow({
	    map: map,
	    position : position, 
	    content : content,
	    removable : removeable
	})
});

kakao.maps.event.addListener(t2, 'click', function() {
	m1.setOptions({fillColor: '#fff'});
	m2.setOptions({fillColor: '#fff'});
	m3.setOptions({fillColor: '#fff'});
	m4.setOptions({fillColor: '#fff'});
	m5.setOptions({fillColor: '#fff'});
	m6.setOptions({fillColor: '#fff'});
	m7.setOptions({fillColor: '#fff'});
	
	e1.setOptions({fillColor: '#fff'});
	e2.setOptions({fillColor: '#fff'});
	e3.setOptions({fillColor: '#fff'});
	
	w1.setOptions({fillColor: '#fff'});
	t1.setOptions({fillColor: '#fff'});
	t2.setOptions({fillColor: 'blue'});
	t3.setOptions({fillColor: '#fff'});
	
    var content = '<div class="info">' + 
                  '  <ul>'+
                  '		<li>'+
                  '   		<span class="iTitle">정박지 이름</span>'+
                  '   		<span class="iBody">T2</span>' +
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
				  '			<span class="iBody"><b>29%</b></span>'+
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
                  
    var position = new kakao.maps.LatLng(35.383, 129.576)
    var removeable = true;

	var infowindow = new kakao.maps.InfoWindow({
	    map: map,
	    position : position, 
	    content : content,
	    removable : removeable
	})
});

kakao.maps.event.addListener(t3, 'click', function() {
	m1.setOptions({fillColor: '#fff'});
	m2.setOptions({fillColor: '#fff'});
	m3.setOptions({fillColor: '#fff'});
	m4.setOptions({fillColor: '#fff'});
	m5.setOptions({fillColor: '#fff'});
	m6.setOptions({fillColor: '#fff'});
	m7.setOptions({fillColor: '#fff'});
	
	e1.setOptions({fillColor: '#fff'});
	e2.setOptions({fillColor: '#fff'});
	e3.setOptions({fillColor: '#fff'});
	
	w1.setOptions({fillColor: '#fff'});
	t1.setOptions({fillColor: '#fff'});
	t2.setOptions({fillColor: '#fff'});
	t3.setOptions({fillColor: 'blue'});
	
    var content = '<div class="info">' + 
                  '  <ul>'+
                  '		<li>'+
                  '   		<span class="iTitle">정박지 이름</span>'+
                  '   		<span class="iBody">T3</span>' +
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
				  '			<span class="iBody"><b>25%</b></span>'+
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
                  
    var position = new kakao.maps.LatLng(35.383, 129.576)
    var removeable = true;

	var infowindow = new kakao.maps.InfoWindow({
	    map: map,
	    position : position, 
	    content : content,
	    removable : removeable
	})
});																

