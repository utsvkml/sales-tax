package com.sample.sales.tax.enums;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonValue;
import com.sample.sales.tax.exception.CustomeException;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum Category {
    BOOKS("book"),
    FOOD("food"),
    MEDICAL("medical"),
    OHTER("other");


    @JsonValue
    private final String lebel;

    public static Category getLableFromEnum(String lebel) throws CustomeException{
        return Arrays.stream(Category.values()).filter(items -> StringUtils.equalsIgnoreCase(items.lebel,lebel))
        .findFirst().orElseThrow(()-> new CustomeException("Uknown Order Category"));
    }

}
