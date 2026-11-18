package com.vidyavedika.ai_practice_service.provider;
import org.springframework.beans.factory.annotation.Value; import org.springframework.http.*; import org.springframework.stereotype.Component; import org.springframework.web.client.RestTemplate; import java.util.*;
@Component public class OllamaAIProvider implements AIProvider {
 @Value("${ai.base-url:http://localhost:11434}") String baseUrl; @Value("${ai.model:llama3.2}") String model; private final RestTemplate http=new RestTemplate();
 public Map<String,Object> generate(String prompt){try{Map<String,Object> body=Map.of("model",model,"prompt",prompt,"stream",false); ResponseEntity<Map> r=http.postForEntity(baseUrl+"/api/generate",body,Map.class); Object resp=r.getBody()==null?null:r.getBody().get("response"); return Map.of("provider","ollama","reply",String.valueOf(resp==null?"":resp));}catch(Exception e){throw new IllegalStateException("AI provider unavailable");}}
 public String name(){return "ollama";}
}
