package io.github.atsin6.blueprintai.agent.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.ObjectMapper;

class PlanDtoDeserializationTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void plannerJsonDeserializesIntoPlanDtoTree() throws Exception {
        String json = """
            {
              "version": "1",
              "layout": {
                "layoutType": "grid",
                "columns": 2,
                "alignment": "center"
              },
              "components": [
                {
                  "id": "card-1",
                  "type": "Card",
                  "props": { "title": "Welcome" },
                  "children": [
                    {
                      "id": "button-1",
                      "type": "Button",
                      "props": { "label": "Continue", "disabled": false }
                    }
                  ]
                },
                {
                  "id": "input-1",
                  "type": "Input",
                  "props": { "label": "Email", "required": true }
                }
              ],
              "metadata": { "source": "planner" }
            }
            """;

        PlanDTO plan = objectMapper.readValue(json, PlanDTO.class);

        assertNotNull(plan);
        assertEquals("1", plan.getVersion());
        assertNotNull(plan.getLayout());
        assertEquals("grid", plan.getLayout().getLayoutType());
        assertEquals(2, plan.getLayout().getColumns());
        assertEquals("center", plan.getLayout().getAlignment());

        assertNotNull(plan.getComponents());
        assertEquals(2, plan.getComponents().size());

        ComponentNodeDTO card = plan.getComponents().get(0);
        assertEquals("card-1", card.getId());
        assertEquals("Card", card.getType());
        assertEquals("Welcome", card.getProps().get("title"));
        assertEquals(1, card.getChildren().size());

        ComponentNodeDTO button = card.getChildren().get(0);
        assertEquals("button-1", button.getId());
        assertEquals("Button", button.getType());
        assertEquals("Continue", button.getProps().get("label"));
        assertEquals(false, button.getProps().get("disabled"));
        assertNotNull(button.getChildren());
        assertTrue(button.getChildren().isEmpty());

        ComponentNodeDTO input = plan.getComponents().get(1);
        assertEquals("input-1", input.getId());
        assertEquals("Input", input.getType());
        assertEquals("Email", input.getProps().get("label"));
        assertEquals(true, input.getProps().get("required"));

        assertNotNull(plan.getMetadata());
        assertEquals("planner", plan.getMetadata().get("source"));
    }
}
