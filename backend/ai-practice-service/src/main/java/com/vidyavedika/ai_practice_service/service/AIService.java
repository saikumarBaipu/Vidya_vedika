package com.vidyavedika.ai_practice_service.service;
import com.vidyavedika.ai_practice_service.provider.*; import org.springframework.beans.factory.annotation.Value; import org.springframework.stereotype.Service; import java.util.*;
@Service public class AIService {
 private final OllamaAIProvider ollama; private final FallbackAIProvider fallback; @Value("${ai.provider:fallback}") String configured;
 public AIService(OllamaAIProvider o,FallbackAIProvider f){ollama=o;fallback=f;}
 public Map<String,Object> practice(Map<String,Object> req){String p="Act as a patient language tutor. Ask one question at a time. Language="+req.getOrDefault("language","English")+" Level="+req.getOrDefault("level","Beginner")+" User="+req.getOrDefault("message",""); return call(p);}
 public Map<String,Object> correct(String sentence){if(sentence==null||sentence.isBlank())throw new IllegalArgumentException("sentence is required"); return call("Correct this learner sentence. Return corrected sentence, explanation, natural version and one example: "+sentence);}
 private Map<String,Object> call(String prompt){if("ollama".equalsIgnoreCase(configured)){try{return ollama.generate(prompt);}catch(Exception ignored){}} return fallback.generate(prompt);}
}
