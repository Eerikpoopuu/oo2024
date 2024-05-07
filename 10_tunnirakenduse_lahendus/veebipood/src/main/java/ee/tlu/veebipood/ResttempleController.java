package ee.tlu.veebipood;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ResttempleController {
    @GetMapping("hankija-tooted/{reiting}")
    public List<Product> hankijaTooted(@PathVariable double reiting) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Product[]> response = restTemplate.exchange("https://fakestoreapi.com/products",
                HttpMethod.GET, null, Product[].class);


        List<Product> sobilikud = new ArrayList<>();
        for (Product p : response.getBody()) {
            if (p.rating.rate > reiting) {
                sobilikud.add(p);
            }
        }
        return sobilikud;
    }
}
