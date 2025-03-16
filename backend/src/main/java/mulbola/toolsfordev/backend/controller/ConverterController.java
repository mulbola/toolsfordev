package mulbola.toolsfordev.backend.controller;


import mulbola.toolsfordev.backend.model.converter.*;
import mulbola.toolsfordev.backend.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/converter")
public class ConverterController {

    private final ConverterService converterService;

    @Autowired
    public ConverterController(ConverterService converterService) {
        this.converterService = converterService;
    }

    @PostMapping("/base")
    public ResponseEntity<BaseResponse> convertBase(@RequestBody BaseRequest request) {
        return ResponseEntity.ok(converterService.convertBase(request));
    }

    @PostMapping("/base64")
    public ResponseEntity<Base64Response> convertBase64(@RequestBody Base64Request request) {
        return ResponseEntity.ok(converterService.convertBase64(request));
    }

    @PostMapping("/timestamp")
    public ResponseEntity<TimestampResponse> convertTimestamp(@RequestBody TimestampRequest request) {
        return ResponseEntity.ok(converterService.convertTimestamp(request));
    }

}
