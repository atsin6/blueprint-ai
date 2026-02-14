package io.github.atsin6.blueprintai.agent.validation;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComponentDefinition {

    private String name;
    private Set<String> allowedProps;
    private boolean childrenAllowed;

}
