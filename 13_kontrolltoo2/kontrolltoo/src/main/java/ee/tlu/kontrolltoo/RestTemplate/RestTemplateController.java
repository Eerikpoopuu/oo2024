package ee.tlu.kontrolltoo.RestTemplate;

import ee.tlu.kontrolltoo.RestTemplate.AutoInfo;
import ee.tlu.kontrolltoo.RestTemplate.AutoKeskmine;
import ee.tlu.kontrolltoo.RestTemplate.AutodResult;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RestTemplateController {
    @GetMapping("saa-autod")
    public List<AutoInfo> getAutod() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://public.opendatasoft.com/api/explore/v2.1/catalog/datasets/all-vehicles-model/records?limit=100";
        ResponseEntity<AutodResult> response = restTemplate.exchange(url, HttpMethod.GET, null, AutodResult.class);

        return response.getBody().getResults();
    }

    @GetMapping("saa-autod/{mark}")
    public List<AutoInfo> getAutoBymark(@PathVariable String mark) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://public.opendatasoft.com/api/explore/v2.1/catalog/datasets/all-vehicles-model/records?limit=100";
        ResponseEntity<AutodResult> response = restTemplate.exchange(url, HttpMethod.GET, null, AutodResult.class);

        List<AutoInfo> AutoMark = new ArrayList<>();
        for (AutoInfo a : response.getBody().getResults()) {
            if (a.make.equals(mark)) {
                AutoMark.add(a);
            }
        }
        return AutoMark;
    }

    @GetMapping("saa-autod/votmed")
    public List<String> getAutovotmed() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://public.opendatasoft.com/api/explore/v2.1/catalog/datasets/all-vehicles-model/records?limit=100";
        ResponseEntity<AutodResult> response = restTemplate.exchange(url, HttpMethod.GET, null, AutodResult.class);

        List<String> AutoVotmed = new ArrayList<>();
        for (AutoInfo auto : response.getBody().getResults()) {
            AutoVotmed.add(auto.make + auto.model);
        }
        return AutoVotmed;
    }

    @GetMapping("minhobu")
    public AutoKeskmine minhobu() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://private-anon-4ea94f9306-carsapi1.apiary-mock.com/manufacturers";
        ResponseEntity<AutoKeskmine[]> response = restTemplate.exchange(url, HttpMethod.GET, null, AutoKeskmine[].class);
        double min = Integer.MAX_VALUE;
        AutoKeskmine vaiksem = null;
        for (AutoKeskmine k : response.getBody()) {
            if (k.getAvg_horsepower() < min) {
                min = k.getAvg_horsepower();
                vaiksem = k;
            }
        }
        return vaiksem;

    }

    @GetMapping("maxHind")
    public AutoKeskmine maxhind() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://private-anon-4ea94f9306-carsapi1.apiary-mock.com/manufacturers";
        ResponseEntity<AutoKeskmine[]> response = restTemplate.exchange(url, HttpMethod.GET, null, AutoKeskmine[].class);
        double max = Integer.MIN_VALUE;
        AutoKeskmine suurim = null;
        for (AutoKeskmine k : response.getBody()) {
            if (k.getAvg_price() > max) {
                max = k.getAvg_horsepower();
                suurim = k;
            }
        }
        return suurim;

    }

    @GetMapping("autod/{maxHind}")
    public List<AutoKeskmine> väiksemKuiMaxHind(@PathVariable int maxHind) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://private-anon-4ea94f9306-carsapi1.apiary-mock.com/manufacturers";
        ResponseEntity<AutoKeskmine[]> response = restTemplate.exchange(url, HttpMethod.GET, null, AutoKeskmine[].class);

        List<AutoKeskmine> filtreeritud = new ArrayList<>();
        for (AutoKeskmine k : response.getBody()) {
            if (k.getAvg_price() < maxHind) {
                filtreeritud.add(k);
            }
        }
        return filtreeritud;

    }

    @GetMapping("autod/{maxhobuj6ud}")
    public List<AutoKeskmine> suuremKuiMaxHobuj6ud(@PathVariable int maxhobuj6ud) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://private-anon-4ea94f9306-carsapi1.apiary-mock.com/manufacturers";
        ResponseEntity<AutoKeskmine[]> response = restTemplate.exchange(url, HttpMethod.GET, null, AutoKeskmine[].class);

        List<AutoKeskmine> filtreeritud = new ArrayList<>();
        for (AutoKeskmine k : response.getBody()) {
            if (k.getAvg_horsepower() > maxhobuj6ud) {
                filtreeritud.add(k);
            }
        }
        return filtreeritud;

    }

    @GetMapping("autod/{minHind}/{maxHind}")
    public List<AutoKeskmine> suuremKuiMaxHobuj6ud(@PathVariable int minHind, int maxHind) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://private-anon-4ea94f9306-carsapi1.apiary-mock.com/manufacturers";
        ResponseEntity<AutoKeskmine[]> response = restTemplate.exchange(url, HttpMethod.GET, null, AutoKeskmine[].class);

        List<AutoKeskmine> filtreeritud = new ArrayList<>();
        for (AutoKeskmine k : response.getBody()) {
            if (k.getAvg_price() >= minHind && k.getAvg_price() <= maxHind) {
                filtreeritud.add(k);
            }

        }
        return filtreeritud;
    }
}