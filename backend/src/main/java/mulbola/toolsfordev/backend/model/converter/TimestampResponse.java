package mulbola.toolsfordev.backend.model.converter;

import lombok.Data;

@Data
public class TimestampResponse {
    private boolean success;
    private String result;
    private String error;
}
