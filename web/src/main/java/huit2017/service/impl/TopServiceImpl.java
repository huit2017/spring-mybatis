package huit2017.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import huit2017.dto.top.DetailInDto;
import huit2017.dto.top.DetailOutDto;
import huit2017.dto.top.FinishInDto;
import huit2017.dto.top.FinishOutDto;
import huit2017.dto.top.IndexInDto;
import huit2017.dto.top.IndexOutDto;
import huit2017.entity.Bbs;
import huit2017.entity.User;
import huit2017.mapper.BbsMapper;
import huit2017.mapper.UserMapper;
import huit2017.service.TopService;

@Service
public class TopServiceImpl implements TopService {

    @Autowired
    private BbsMapper bbsMapper;

    @Autowired
    private UserMapper userMapper;

    public IndexOutDto index(IndexInDto inDto) {
        Bbs bbs = bbsMapper.selectByPrimaryKey(inDto.getBbsId());
        IndexOutDto outDto = new IndexOutDto();
        outDto.setComment(bbs.getComment());
        String a = null;
    	if (a.equals("hogehoge")) {
    	    
    	}
        return outDto;
    }

    @Override
    public DetailOutDto detail(DetailInDto inDto) {
        Bbs bbs = bbsMapper.selectByPrimaryKey(inDto.getBbsId());
        DetailOutDto outDto = new DetailOutDto();
        outDto.setComment(bbs.getComment());
        return outDto;
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = RuntimeException.class)
    public FinishOutDto finish(FinishInDto inDto) {

        Date now = new Date();
        Bbs bbs = new Bbs();
        bbs.setUserId(1);
        bbs.setComment("お休み");
        bbs.setCreatedAt(now);;
        bbs.setUpdatedAt(now);
        bbsMapper.insert(bbs);


        User user = new User();
        user.setName("あ");
        user.setCreatedAt(now);
        user.setUpdatedAt(now);
        user.setDeleteFlg((byte) 0);
        userMapper.insert(user);
        return null;
    }
}
