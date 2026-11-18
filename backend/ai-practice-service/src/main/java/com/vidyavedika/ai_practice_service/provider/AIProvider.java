package com.vidyavedika.ai_practice_service.provider; import java.util.*; public interface AIProvider { Map<String,Object> generate(String prompt); String name(); }
