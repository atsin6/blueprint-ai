package io.github.atsin6.blueprintai.agent.validation;

import io.github.atsin6.blueprintai.agent.model.PlanDTO;
import org.springframework.stereotype.Component;

@Component
public class PlanValidator {

    public boolean isValid(PlanDTO plannerResult) {
        return plannerResult != null;
    }

    public PlanDTO validate(PlanDTO plannerResult) {
        return plannerResult;
    }
}
