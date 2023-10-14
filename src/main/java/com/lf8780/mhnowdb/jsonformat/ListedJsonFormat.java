package com.lf8780.mhnowdb.jsonformat;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListedJsonFormat extends JsonFormatBase{

    private Integer dataLenght;
    private List<?> responseData;   

    public ListedJsonFormat (List<?> responseData) {
        this.responseData = responseData;
        this.dataLenght = responseData.size();
        this.responseDate = new Date();
    }

}
