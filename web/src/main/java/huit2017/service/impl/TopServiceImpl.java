package huit2017.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import huit2017.entity.Bbs;
import huit2017.mapper.BbsMapper;
import huit2017.service.TopService;

@Service
public class TopServiceImpl implements TopService {

    @Autowired
    private BbsMapper bbsMapper;

    @Override
    public Bbs index() {
        Bbs bbs = bbsMapper.selectByPrimaryKey(1);
        return bbs;
    }
}
