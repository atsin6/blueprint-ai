package io.github.atsin6.blueprintai.agent.validation;

import org.springframework.stereotype.Component;

@Component
public class CodeValidator {

    public boolean isValid(String generatedCode) {
        return generatedCode != null;
    }

    public String validate(String generatedCode) {
        return generatedCode;
    }
}
