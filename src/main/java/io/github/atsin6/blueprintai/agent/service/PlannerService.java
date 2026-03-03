package io.github.atsin6.blueprintai.agent.service;

import io.github.atsin6.blueprintai.agent.model.AgentRequestDTO;
import io.github.atsin6.blueprintai.agent.model.PlanDTO;
import org.springframework.stereotype.Service;

@Service
public class PlannerService {

    public PlanDTO plan(AgentRequestDTO request) {
        return new PlanDTO();
    }
}
