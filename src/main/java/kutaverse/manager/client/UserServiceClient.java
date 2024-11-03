package kutaverse.manager.client;

import kutaverse.manager.domain.login.dto.request.LoginRequest;
import kutaverse.manager.domain.login.dto.response.FindAllCharactersResponse;
import kutaverse.manager.domain.login.dto.response.GetUsersResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="user-service")
public interface UserServiceClient {
    @PostMapping("/login")
    ResponseEntity<String> authLogin(@RequestBody LoginRequest loginRequest);

    // 유저 정보 가져오기(유저 ID, 유저 이름, 정지 상태)
    @GetMapping("/users")
    ResponseEntity<List<GetUsersResponse>> getUsersList();

    // 유저 정지 또는 해제
    @PostMapping("/user/ban/{userId}")
    ResponseEntity<String> banUser(@PathVariable Long userId);

    // 캐릭터 정보 가져오기(위의 유저 ID를 기준으로)
    @GetMapping("/characterList")
    ResponseEntity<List<FindAllCharactersResponse>> getCharacters();
}
