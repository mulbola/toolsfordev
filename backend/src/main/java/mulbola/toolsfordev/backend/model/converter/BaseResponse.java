package mulbola.toolsfordev.backend.model.converter;

import lombok.Data;

@Data
public class BaseResponse {
    private boolean success;
    private String result;
    private String error;
}
