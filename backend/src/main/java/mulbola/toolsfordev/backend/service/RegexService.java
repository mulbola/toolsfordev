package mulbola.toolsfordev.backend.service;

import mulbola.toolsfordev.backend.model.regex.RegexRequest;
import mulbola.toolsfordev.backend.model.regex.RegexResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@Service
public class RegexService {

    public RegexResponse testRegex(RegexRequest request) {
        RegexResponse response = new RegexResponse();

        try {
            Pattern pattern = Pattern.compile(request.getRegex());
            Matcher matcher = pattern.matcher(request.getText());

            boolean matches = matcher.find();
            response.setMatches(matches);

            if (matches) {
                List<String> matchResults = new ArrayList<>();
                matcher.reset();

                while (matcher.find()) {
                    matchResults.add(matcher.group());
                }

                response.setMatchResults(matchResults);
            }

            response.setSuccess(true);
        } catch (PatternSyntaxException e) {
            response.setSuccess(false);
            response.setError("정규식 구문 오류: " + e.getMessage());
        } catch (Exception e) {
            response.setSuccess(false);
            response.setError("처리 중 오류 발생: " + e.getMessage());
        }

        return response;
    }
}