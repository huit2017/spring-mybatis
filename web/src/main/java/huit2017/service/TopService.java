package huit2017.service;

import huit2017.dto.top.FinishInDto;
import huit2017.dto.top.FinishOutDto;
import huit2017.dto.top.IndexInDto;
import huit2017.dto.top.IndexOutDto;

public interface TopService {

    public IndexOutDto index(IndexInDto inDto);

    public FinishOutDto finish(FinishInDto inDto);
}
