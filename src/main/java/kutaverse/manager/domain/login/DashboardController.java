package kutaverse.manager.domain.login;

import kutaverse.manager.client.UserServiceClient;
import kutaverse.manager.domain.login.dto.response.GetUsersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class DashboardController {
    private final UserServiceClient userServiceClient;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        try{
            ResponseEntity<List<GetUsersResponse>> response = userServiceClient.getUsersList(); // 사용자를 리스트로 받아오는 메서드 호출
            List<GetUsersResponse> userList = response.getBody();

            // 받은 사용자 목록을 모델에 추가
            if (userList != null) {
                model.addAttribute("userList", userList);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "dashboard"; // 대시보드 템플릿
    }


    @GetMapping("/character-inventory")
    public String characterInventory(Model model){

        return "character-inventory";
    }
}
