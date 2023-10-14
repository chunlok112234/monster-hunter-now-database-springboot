package com.lf8780.mhnowdb.jsonformat;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasicJsonFormat extends JsonFormatBase{
    
    private Serializable responseData;

    public BasicJsonFormat (Serializable responseData) {
        this.responseData = responseData;
        this.responseDate = new Date();
    }

}
