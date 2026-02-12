package io.github.atsin6.blueprintai.agent.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgentController {

    @PostMapping("/agent/run")
    public String runAgent() {
        return "TODO";
    }
}
