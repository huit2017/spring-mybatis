package huit2017.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import huit2017.entity.Bbs;
import huit2017.mapper.BbsMapper;

@Controller
public class TopController {

    @Autowired
    private BbsMapper bbsMapper;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        Bbs bbs = bbsMapper.selectByPrimaryKey(1);
        System.out.println("comment: " + bbs.getComment());
        return "index";
    }
}
