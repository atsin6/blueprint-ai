package io.github.atsin6.blueprintai.agent.validation;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ComponentRegistry {

    private static final Map<String, ComponentDefinition> COMPONENTS;

    static {
        Map<String, ComponentDefinition> components = new HashMap<>();
        components.put("Button", new ComponentDefinition(
            "Button",
            Set.of("label", "variant", "size", "disabled", "onClick"),
            false
        ));
        components.put("Card", new ComponentDefinition(
            "Card",
            Set.of("title", "elevation", "padding", "bordered"),
            true
        ));
        components.put("Input", new ComponentDefinition(
            "Input",
            Set.of("label", "placeholder", "value", "type", "disabled", "required"),
            false
        ));
        components.put("Table", new ComponentDefinition(
            "Table",
            Set.of("columns", "rows", "striped", "bordered"),
            true
        ));
        components.put("Modal", new ComponentDefinition(
            "Modal",
            Set.of("title", "open", "size", "dismissible"),
            true
        ));
        components.put("Stack", new ComponentDefinition(
            "Stack",
            Set.of("direction", "spacing", "align", "justify", "wrap"),
            true
        ));
        COMPONENTS = Collections.unmodifiableMap(components);
    }

    private ComponentRegistry() {
    }

    public static ComponentDefinition getComponent(String name) {
        return COMPONENTS.get(name);
    }

    public static boolean isAllowed(String name) {
        return COMPONENTS.containsKey(name);
    }

    public static Set<String> getAllowedProps(String name) {
        ComponentDefinition definition = COMPONENTS.get(name);
        if (definition == null) {
            return Set.of();
        }
        return definition.getAllowedProps();
    }
}
