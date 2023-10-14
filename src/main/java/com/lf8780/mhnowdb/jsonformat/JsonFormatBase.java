package com.lf8780.mhnowdb.jsonformat;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class JsonFormatBase implements Serializable{
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "Asia/Hong_Kong")
    protected Date responseDate;

}
