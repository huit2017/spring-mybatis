package huit2017.controller.rest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import huit2017.request.BbsRequest;

@RestController
public class TopRestController {

    @RequestMapping(path = "/list")
    public Map<String, Object> list(@RequestBody BbsRequest request) {

       Map<String, Object> response = new HashMap<>();
       response.put("a", Arrays.asList("紀伊", "太郎", "紀伊", "花子"));
       response.put("b", Arrays.asList("紀伊", "太郎", "紀伊", "花子"));
       return response;
    }
}
