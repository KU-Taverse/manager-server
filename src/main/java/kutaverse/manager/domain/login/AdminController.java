package kutaverse.manager.domain.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AdminController {
    @GetMapping("/admin/login")
    public String loginPage() {
        return "login"; // 로그인 페이지 반환
    }

}
