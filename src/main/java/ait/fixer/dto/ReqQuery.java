package ait.fixer.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
public class ReqQuery {
    int amount;
    String from;
    String to;

    @Override
    public String toString() {
        return "Request information" +
                "\n Quantity= " + amount +
                "\n You are selling " + from +
                "\n You are buying  " + to ;
    }
}
