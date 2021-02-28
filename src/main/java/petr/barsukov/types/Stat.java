package petr.barsukov.types;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stat {
    private String version;
    private String artifactId;
}
