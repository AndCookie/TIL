package net.kdigital.spring7.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;
import net.kdigital.spring7.domain.Iris;

@Service
@Slf4j
public class PredictService {

	@Value("${iris.predict.server}")
	// application.properties의 paging 페이징 value값 받아올 때 사용한 적 있음
	String url;
	// application.properties의 iris.predict.server의 값을 url에 넣으라는 의미
	
	@Autowired
	RestTemplateBuilder restTemplateBuilder;
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> predict(Iris iris) {
		log.info("Spring ===> Iris정보: {}", iris.toString() );
	      log.info("FastAPI 서버 URL: {}", url );
	      
	      Map<String, Object> result = null;
	      Map<String, Object> map = null;
		
		try {
			Map<String, Double> param = new HashMap<>();
			
			// 서버로 보낼 쿼리스트링 작성
			param.put("petalLength", iris.getPetalLength());
	        param.put("petalWidth",  iris.getPetalWidth());
	        param.put("sepalLength", iris.getSepalLength());
	        param.put("sepalWidth",  iris.getSepalWidth());

			
			// 직접 헤더 만들 준비하기
			HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

			
			RestTemplate restTemplate = new RestTemplate();
			
			// 웹서버가 Client 역할을 하는 것이다보니 위의 복잡한 과정을 거치는 것
			
			// POST 방식으로 데이터 전송하기
			// RestTemplate의 postForEntity() 메소드를 사용
			ResponseEntity<String> response = restTemplate.postForEntity(url, param, String.class);
			// (1 : 요청 url / 2 :내가 보내려는 데이터 param / 3. 응답 받을 방식 String.class)
			
			// GSON
			GsonBuilder builder = new GsonBuilder();
	         builder.setPrettyPrinting();
	         Gson gson = builder.create();
	         
	         map = gson.fromJson(response.getBody(), Map.class);
			// getBody로 데이터를 꺼낸 후 Map 형태로 반환하려고 하는데,
			// spring 입장에서는 안될 수도 있다고 생각하므로 노란색줄의 오류를 띄운다
			// ==> SuppressWarning
			
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			result.put("statusCode", e.getRawStatusCode()); // 오류 코드
			result.put("body", e.getStatusText());			// 오류에 대한 설명 텍스트
			log.info("{}", result);
			return result; // 오류
		} catch (Exception e) {
	         result.put("status", "999"); // 오류 코드
	         result.put("body", "Exception이 발생했습니다."); // 오류 코드
	         log.info("{}", result);
	         return result; // 오류
	      }
		
		return map; // 정상
	}
}
