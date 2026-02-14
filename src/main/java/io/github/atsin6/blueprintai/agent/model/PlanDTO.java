package io.github.atsin6.blueprintai.agent.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlanDTO {

    private String version;
    private LayoutDTO layout;
    private List<ComponentNodeDTO> components = new ArrayList<>();
    private Map<String, Object> metadata = Map.of();
}
