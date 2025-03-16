package mulbola.toolsfordev.backend.model.converter;

import lombok.Data;

@Data
public class Base64Request {
    private String value;
    private String operation; // "encode" 또는 "decode"
}
