package com.idstar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationDto {
	
	private String content;
	private PageableDto pageable;
    private boolean last;
    private int totalElements;
    private int totalPages;
    private int size;
    private int number;
    private SortDto sort;
    private boolean first;
    private int numberOfElements;
    private boolean empty;

}
