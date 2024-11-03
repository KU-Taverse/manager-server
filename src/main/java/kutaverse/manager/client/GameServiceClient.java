package kutaverse.manager.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="game-service")
public interface GameServiceClient {
}
