package ee.tlu.salat;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RestTemplateController {
    @GetMapping("saa-postitused")
    public List<Post> getPosts(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<Post[]> response= restTemplate.exchange(url, HttpMethod.GET, null, Post[].class );

        return List.of(response.getBody());
    }
    @GetMapping("saa-postitused/{kasutajaId}")
    public List<Post> getUserPosts(@PathVariable int kasutajaId){

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<Post[]> response= restTemplate.exchange(url, HttpMethod.GET, null, Post[].class );

        List<Post> kasutajaostitused = new ArrayList<>();
        for (Post p:response.getBody()){
            if(p.getUserId()==kasutajaId){
                kasutajaostitused.add(p);
            }
        }

        return List.of(response.getBody());
    }

}
