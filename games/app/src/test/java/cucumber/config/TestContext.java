package cucumber.config;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;

@Component
@Profile("cucumber")

public class TestContext {
    @Getter
    @Setter
    private ResponseEntity<String> response;
}
