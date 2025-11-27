package com.whale.common.core.application;

import org.springframework.web.bind.annotation.RequestParam;

public class QueryPageDto extends QueryDto {
    public Integer pageNo;
    public Integer pageSize;
}
