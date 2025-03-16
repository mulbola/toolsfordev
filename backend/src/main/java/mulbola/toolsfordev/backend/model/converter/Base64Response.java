package mulbola.toolsfordev.backend.model.converter;

import lombok.Data;

@Data
public class Base64Response {
    private boolean success;
    private String result;
    private String error;
}
