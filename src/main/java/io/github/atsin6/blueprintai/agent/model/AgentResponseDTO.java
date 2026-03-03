package io.github.atsin6.blueprintai.agent.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AgentResponseDTO {

    private PlanDTO plan;
    private String generatedCode;
    private String explanation;
}
