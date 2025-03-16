package mulbola.toolsfordev.backend.model.regex;

import lombok.Data;

import java.util.List;

@Data
public class RegexResponse {
    private boolean success;
    private boolean matches;
    private List<String> matchResults;
    private String error;
}
