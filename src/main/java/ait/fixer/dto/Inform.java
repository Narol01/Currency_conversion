package ait.fixer.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
public class Inform {
    Double rate;

    @Override
    public String toString() {
        return " Unit price=" + rate;
    }
}
