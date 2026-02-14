package io.github.atsin6.blueprintai.agent.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import org.junit.jupiter.api.Test;

class ComponentRegistryTest {

    @Test
    void registryLoadsAndAllowsKnownComponents() {
        assertTrue(ComponentRegistry.isAllowed("Button"));
        assertTrue(ComponentRegistry.isAllowed("Card"));
        assertTrue(ComponentRegistry.isAllowed("Input"));
        assertTrue(ComponentRegistry.isAllowed("Table"));
        assertTrue(ComponentRegistry.isAllowed("Modal"));
        assertTrue(ComponentRegistry.isAllowed("Stack"));
    }

    @Test
    void registryRejectsUnknownComponent() {
        assertFalse(ComponentRegistry.isAllowed("Unknown"));
    }

    @Test
    void lookupReturnsDefinitionAndProps() {
        ComponentDefinition definition = ComponentRegistry.getComponent("Button");
        assertNotNull(definition);
        assertEquals("Button", definition.getName());
        assertEquals(Set.of("label", "variant", "size", "disabled", "onClick"),
            ComponentRegistry.getAllowedProps("Button"));
    }
}
