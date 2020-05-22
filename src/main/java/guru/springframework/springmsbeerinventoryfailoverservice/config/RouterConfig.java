package guru.springframework.springmsbeerinventoryfailoverservice.config;

import guru.springframework.springmsbeerinventoryfailoverservice.web.InventoryHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;


/**
 * @author kas
 */
@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction inventoryRoute(InventoryHandler inventoryHandler) {
        return route(GET("inventory-failover").and(accept(MediaType.APPLICATION_JSON)),
                inventoryHandler::listInventory);
    }
}
