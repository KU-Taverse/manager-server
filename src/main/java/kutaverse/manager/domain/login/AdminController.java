package kutaverse.manager.domain.login;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import kutaverse.manager.client.UserServiceClient;
import kutaverse.manager.domain.login.dto.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final UserServiceClient userServiceClient;

    @GetMapping("/admin/login")
    public String loginPage() {
        return "login"; // 로그인 페이지 반환
    }

    @PostMapping("/admin/login")
    public String login(@ModelAttribute LoginRequest loginRequest, Model model, HttpServletResponse response){
        try{
            // 로그인 요청
            ResponseEntity<String> loginResponse = userServiceClient.authLogin(loginRequest);

            // 응답의 헤더 확인
            HttpHeaders headers = loginResponse.getHeaders();

            if (!headers.containsKey("admin")) {
                model.addAttribute("error", "관리자 권한이 필요합니다.");
                return "login"; // 로그인 페이지로 다시 이동
            }

            Cookie cookie = new Cookie("jwtToken", loginResponse.getHeaders().getFirst("token"));
            cookie.setHttpOnly(true); // JavaScript에서 접근할 수 없도록 설정
            cookie.setPath("/"); // 전체 경로에서 접근 가능
            cookie.setMaxAge(60 * 60); // 쿠키 유효 기간 (1시간)
            response.addCookie(cookie);
            return "redirect:http://localhost:9000/manager-service/dashboard";  // 대시보드 페이지로 리다이렉트

        }catch (Exception e){
            model.addAttribute("error", "로그인 중 오류가 발생했습니다.");
            return "login"; // 오류 시 로그인 페이지로 돌아감
        }
    }

}
