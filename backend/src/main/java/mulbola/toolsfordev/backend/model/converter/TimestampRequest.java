package mulbola.toolsfordev.backend.model.converter;

import lombok.Data;

@Data
public class TimestampRequest {
    private String value;
    private String operation; // "toDate" 또는 "toTimestamp"
}
