package kutaverse.manager.domain.login.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetUsersResponse {
    // 유저 id
    private Long userId;

    // 이메일
    private String email;

    // 상태(ADMIN, GENERAL)
    private String role;

    // 관리
    private String accountStatus;
}
