package huit2017.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import huit2017.dto.top.IndexInDto;
import huit2017.dto.top.IndexOutDto;
import huit2017.service.TopService;

@Controller
public class TopController {

    @Autowired
    private TopService topService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String index(@RequestParam(defaultValue = "1") Integer bbsId, Model model) {

        IndexInDto inDto = new IndexInDto();
        inDto.setBbsId(bbsId);
        IndexOutDto outDto = topService.index(inDto);
        model.addAttribute("title", "タイトル");
        model.addAttribute("message", outDto.getComment());
        return "top/index";
    }
}
