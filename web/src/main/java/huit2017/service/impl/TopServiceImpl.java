package huit2017.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import huit2017.dto.top.IndexInDto;
import huit2017.dto.top.IndexOutDto;
import huit2017.entity.Bbs;
import huit2017.mapper.BbsMapper;
import huit2017.service.TopService;

@Service
public class TopServiceImpl implements TopService {

    @Autowired
    private BbsMapper bbsMapper;

    public IndexOutDto index(IndexInDto inDto) {
        Bbs bbs = bbsMapper.selectByPrimaryKey(inDto.getBbsId());
        IndexOutDto outDto = new IndexOutDto();
        outDto.setComment(bbs.getComment());
        return outDto;
    }
}
