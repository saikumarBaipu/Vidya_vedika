package com.vidyavedika.admin_service.service; import com.vidyavedika.admin_service.entity.*; import com.vidyavedika.admin_service.repository.*; import org.springframework.stereotype.Service; import java.util.*;
@Service public class AdminService {private final AuditLogRepository audit; public AdminService(AuditLogRepository a){audit=a;}
 public Map<String,Object> dashboard(){return Map.of("auditEvents",audit.count(),"generatedAt",java.time.Instant.now(),"status","OPERATIONAL");}
 public AuditLog audit(Long actor,String action,String resource,String detail){AuditLog a=new AuditLog();a.setActorUserId(actor);a.setAction(action);a.setResource(resource);a.setDetail(detail);return audit.save(a);}
 public List<AuditLog> logs(){return audit.findTop100ByOrderByCreatedAtDesc();}
}
