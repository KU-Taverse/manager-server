package kutaverse.manager.domain.login.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
@Setter
@Getter
public class LoginRequest {
    @NotNull
    private String email;

    @NotNull
    private String password;
}
