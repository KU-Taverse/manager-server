package kutaverse.manager.client;

import kutaverse.manager.domain.login.dto.request.LoginRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="user-service")
public interface UserServiceClient {
    @PostMapping("/login")
    ResponseEntity<String> authLogin(@RequestBody LoginRequest loginRequest);
}
