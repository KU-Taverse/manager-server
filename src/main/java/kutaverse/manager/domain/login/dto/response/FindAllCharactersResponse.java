package kutaverse.manager.domain.login.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class FindAllCharactersResponse {
    String nickname;
    String characterType;
    Long userId;
    int currentMoney;
    List<Long> useItemList;
}
