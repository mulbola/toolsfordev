package mulbola.toolsfordev.backend.model.converter;

import lombok.Data;

@Data
public class BaseRequest {
    private String value;
    private int fromBase;
    private int toBase;
}
