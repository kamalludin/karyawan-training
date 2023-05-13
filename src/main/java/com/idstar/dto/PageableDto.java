package com.idstar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageableDto {
	
	private SortDto sort;
    private int offset;
    private int pageNumber;
    private int pageSize;
    private boolean unpaged;
    private boolean paged;

}
