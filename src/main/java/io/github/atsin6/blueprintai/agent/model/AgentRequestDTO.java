package io.github.atsin6.blueprintai.agent.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AgentRequestDTO {

    private String userIntent;
    private PlanDTO previousPlan;
    private String existingCode;
}
