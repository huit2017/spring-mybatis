package huit2017.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import huit2017.entity.Bbs;
import huit2017.service.TopService;

@Controller
public class TopController {

    @Autowired
    private TopService topService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        Bbs bbs = topService.index();
        model.addAttribute("title", "タイトル");
        model.addAttribute("message", bbs.getComment());
        return "top/index";
    }
}
