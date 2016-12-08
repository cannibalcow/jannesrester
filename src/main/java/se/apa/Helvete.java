package se.apa;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
public class Helvete  {

    @RequestMapping(value = "/fa/{uuid}")
    public String  getfa(@PathVariable("uuid") String uuid) {
        MuppData md = new MuppData();
        ResponseEntity<String> result;
        try {
            result = r().getForEntity("http://localhost:8080/Forandringsarende/".concat(uuid).concat("/result"), String.class);
        } catch(HttpClientErrorException e) {
            md.add("status", e.getStatusCode());
            md.add("body", null);
            return null;
//            return md;
        }
        md.add("body", result.getBody());
        md.add("status", result.getStatusCode().value());
//        return md;
        return result.getBody();
    }

    public RestTemplate r() {
        return new RestTemplateBuilder().basicAuthorization("sfr", "sfr").build();
    }
}
