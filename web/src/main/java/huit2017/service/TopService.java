package huit2017.service;

import huit2017.dto.top.DetailInDto;
import huit2017.dto.top.DetailOutDto;
import huit2017.dto.top.FinishInDto;
import huit2017.dto.top.FinishOutDto;
import huit2017.dto.top.IndexInDto;
import huit2017.dto.top.IndexOutDto;

public interface TopService {

    public IndexOutDto index(IndexInDto inDto);

    public DetailOutDto detail(DetailInDto inDto);

    public FinishOutDto finish(FinishInDto inDto);
}
