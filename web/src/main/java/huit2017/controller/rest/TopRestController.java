package huit2017.controller.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopRestController {

    @RequestMapping(path = "/list")
    public List<String> list() {
       return Arrays.asList("紀伊", "太郎", "紀伊", "花子");
    }
}
