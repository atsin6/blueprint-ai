package io.github.atsin6.blueprintai.agent.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ComponentNodeDTO {

    private String id;
    private String type;
    private Map<String, Object> props;
    private List<ComponentNodeDTO> children = new ArrayList<>();
}
