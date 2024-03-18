package net.kdigital.hackathon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import net.kdigital.hackathon.domain.Data1;
import net.kdigital.hackathon.domain.Data2;
import net.kdigital.hackathon.mapper.DragMapper;

@Service
@Slf4j
public class DragService {

   @Autowired
   DragMapper mapper;

   @Autowired
   RestTemplate restTemplate;

   @Autowired
   ObjectMapper objectMapper;

   public Data1 api1(String targetTime) {
      Data1 data = null;

      String apiUrl = "http://www.khoa.go.kr/api/oceangrid/tidalBu/search.do"
            + "?ServiceKey=MMXtXVokHH93lyqaQCQ54w==" // 인증키
            + "&ObsCode=TW_0062"  // 해운대
            + "&Date=20230628"     // 날짜
            + "&ResultType=json"; // 결과물 타입

      ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
      if (response.getStatusCode().is2xxSuccessful()) {
         String body = response.getBody();

         try {
            JsonNode root = objectMapper.readTree(body).get("result").get("data");

            // 원하는 값을 가진 배열 추출
            JsonNode result = null;

            for (JsonNode node : root) {
               String obsTime = node.get("obs_time").asText();
               if (targetTime.equals(obsTime)) {
                  result = node;
                  break;
               }

            }

            if (result != null) {
               String obs_time = result.get("obs_time").asText();
               String current_speed = result.get("current_speed").asText();
               String current_direct = result.get("current_direct").asText();
   
               data = new Data1(obs_time, current_speed, current_direct); 
            }
            
            else {
               data = new Data1("-", "-", "-");
            }
         } 

         catch (JsonMappingException e) {
            e.printStackTrace();
         } 
         catch (JsonProcessingException e) {
            e.printStackTrace();
         }

      }

      return data;
   }
   
   public Data2 api2(String targetTime) {
      Data2 data = null;

      String apiUrl = "http://www.khoa.go.kr/api/oceangrid/tidalBuWind/search.do"
            + "?ServiceKey=MMXtXVokHH93lyqaQCQ54w==" // 인증키
            + "&ObsCode=TW_0062"  // 관측치 번호
            + "&Date=20230628"    // 날짜
            + "&ResultType=json"; // 결과 리턴타입
      
      ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
      if (response.getStatusCode().is2xxSuccessful()) {
         String body = response.getBody();

         try {
            JsonNode root = objectMapper.readTree(body).get("result").get("data");

            // 원하는 값을 가진 배열 추출
            JsonNode result = null;

            for (JsonNode node : root) {
               String record_time = node.get("record_time").asText();
               if (targetTime.equals(record_time)) {
                  result = node;
                  break;
               }

            }
            
            if(result != null) {
               String record_time = result.get("record_time").asText();
               String wind_dir = result.get("wind_dir").asText();
               String wind_speed = result.get("wind_speed").asText();
   
               data = new Data2(record_time, wind_dir, wind_speed);
            }
            else {
               data = new Data2("-", "-", "-");
            }

         } 

         catch (JsonMappingException e) {
            e.printStackTrace();
         } 
         catch (JsonProcessingException e) {
            e.printStackTrace();
         }

      }

      return data;
   }

}