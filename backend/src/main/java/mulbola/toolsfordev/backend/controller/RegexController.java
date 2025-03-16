package mulbola.toolsfordev.backend.controller;

import mulbola.toolsfordev.backend.model.regex.RegexRequest;
import mulbola.toolsfordev.backend.model.regex.RegexResponse;
import mulbola.toolsfordev.backend.service.RegexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/regex")
public class RegexController {

    private final RegexService regexService;

    @Autowired
    public RegexController(RegexService regexService) {
        this.regexService = regexService;
    }

    @PostMapping("/test")
    public ResponseEntity<RegexResponse> testRegex(@RequestBody RegexRequest request) {
        return ResponseEntity.ok(regexService.testRegex(request));
    }
}