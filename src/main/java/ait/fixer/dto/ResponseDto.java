package ait.fixer.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
public class ResponseDto {
    Inform info;
    ReqQuery query;
    Double result;
    boolean success;
}
