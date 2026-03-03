package io.github.atsin6.blueprintai.agent.controller;

import io.github.atsin6.blueprintai.agent.model.AgentRequestDTO;
import io.github.atsin6.blueprintai.agent.model.AgentResponseDTO;
import io.github.atsin6.blueprintai.agent.model.PlanDTO;
import io.github.atsin6.blueprintai.agent.service.ExplainerService;
import io.github.atsin6.blueprintai.agent.service.GeneratorService;
import io.github.atsin6.blueprintai.agent.service.PlannerService;
import io.github.atsin6.blueprintai.agent.validation.CodeValidator;
import io.github.atsin6.blueprintai.agent.validation.PlanValidator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgentController {

    private final PlannerService plannerService;
    private final GeneratorService generatorService;
    private final ExplainerService explainerService;
    private final PlanValidator planValidator;
    private final CodeValidator codeValidator;

    public AgentController(
        PlannerService plannerService,
        GeneratorService generatorService,
        ExplainerService explainerService,
        PlanValidator planValidator,
        CodeValidator codeValidator
    ) {
        this.plannerService = plannerService;
        this.generatorService = generatorService;
        this.explainerService = explainerService;
        this.planValidator = planValidator;
        this.codeValidator = codeValidator;
    }

    @PostMapping("/agent/run")
    public AgentResponseDTO runAgent(@RequestBody AgentRequestDTO request) {
        PlanDTO plannerResult = plannerService.plan(request);
        if (!planValidator.isValid(plannerResult)) {
            throw new IllegalArgumentException("Plan validation failed");
        }
        PlanDTO validatedPlan = planValidator.validate(plannerResult);

        String generatedCode = generatorService.generate(validatedPlan);
        if (!codeValidator.isValid(generatedCode)) {
            throw new IllegalArgumentException("Code validation failed");
        }
        String validatedCode = codeValidator.validate(generatedCode);

        String explanation = explainerService.explain(validatedPlan, validatedCode);

        AgentResponseDTO response = new AgentResponseDTO();
        response.setPlan(validatedPlan);
        response.setGeneratedCode(validatedCode);
        response.setExplanation(explanation);
        return response;
    }
}
