package mulbola.toolsfordev.backend.service;

import mulbola.toolsfordev.backend.model.converter.*;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

@Service
public class ConverterService {

    public BaseResponse convertBase(BaseRequest request) {
        BaseResponse response = new BaseResponse();

        try {
            int value = Integer.parseInt(request.getValue(), request.getFromBase());
            String result = Integer.toString(value, request.getToBase());
            response.setResult(result);
            response.setSuccess(true);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setError("변환 중 오류 발생: " + e.getMessage());
        }

        return response;
    }

    public Base64Response convertBase64(Base64Request request) {
        Base64Response response = new Base64Response();

        try {
            String result;
            if (request.getOperation().equals("encode")) {
                result = Base64.getEncoder().encodeToString(
                        request.getValue().getBytes(StandardCharsets.UTF_8));
            } else {
                byte[] decodedBytes = Base64.getDecoder().decode(request.getValue());
                result = new String(decodedBytes, StandardCharsets.UTF_8);
            }
            response.setResult(result);
            response.setSuccess(true);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setError("변환 중 오류 발생: " + e.getMessage());
        }

        return response;
    }

    public TimestampResponse convertTimestamp(TimestampRequest request) {
        TimestampResponse response = new TimestampResponse();

        try {
            if (request.getOperation().equals("toDate")) {
                long timestamp = Long.parseLong(request.getValue());
                LocalDateTime dateTime = LocalDateTime.ofInstant(
                        Instant.ofEpochSecond(timestamp),
                        ZoneId.systemDefault());
                response.setResult(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            } else {
                LocalDateTime dateTime = LocalDateTime.parse(
                        request.getValue(),
                        DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                long timestamp = dateTime.atZone(ZoneId.systemDefault()).toEpochSecond();
                response.setResult(String.valueOf(timestamp));
            }
            response.setSuccess(true);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setError("변환 중 오류 발생: " + e.getMessage());
        }

        return response;
    }
}
