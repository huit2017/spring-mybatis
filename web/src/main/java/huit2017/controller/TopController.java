package huit2017.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import huit2017.dto.AccountDto;
import huit2017.dto.AccountUserDetails;
import huit2017.dto.top.FinishInDto;
import huit2017.dto.top.FinishOutDto;
import huit2017.dto.top.IndexInDto;
import huit2017.dto.top.IndexOutDto;
import huit2017.service.TopService;

@Controller
public class TopController {

    private Logger logger = LoggerFactory.getLogger(TopController.class);

    @Autowired
    private TopService topService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String index(@AuthenticationPrincipal AccountUserDetails userDetails, @RequestParam(defaultValue = "1") Integer bbsId, Model model) {

        // ユーザ名，パスワードの取得
        String username = userDetails.getUsername();
        String password = userDetails.getPassword();
        logger.debug(String.format("username: %s, password:%s", username, password));
        AccountDto accountDto = userDetails.getAccountDto();

        IndexInDto inDto = new IndexInDto();
        inDto.setBbsId(bbsId);
        IndexOutDto outDto = topService.index(inDto);
        model.addAttribute("title", "タイトル");
        model.addAttribute("message", outDto.getComment());
        return "top/index";
    }

    @RequestMapping(path = "/finish", method = RequestMethod.GET)
    public String finish(@RequestParam(defaultValue = "1") Integer bbsId, Model model) {

        FinishInDto inDto = new FinishInDto();
        inDto.setBbsId(bbsId);
        FinishOutDto outDto = topService.finish(inDto);
        model.addAttribute("title", "タイトル");
        model.addAttribute("message", "登録完了");
        return "top/finish";
    }
}
