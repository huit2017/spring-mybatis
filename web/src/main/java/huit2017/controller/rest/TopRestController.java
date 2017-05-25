package huit2017.controller.rest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopRestController {

    @RequestMapping(path = "/list")
    public Map<String, Object> list() {

       Map<String, Object> response = new HashMap<>();
       response.put("a", Arrays.asList("紀伊", "太郎", "紀伊", "花子"));
       response.put("b", Arrays.asList("紀伊", "太郎", "紀伊", "花子"));
       return response;
    }
}
