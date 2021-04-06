package com.wujia.demo_reptile.constant;

import lombok.Data;

/**
 * @author wu_jia
 */
public enum ReptileEnum {
    /**
     * href
     */
    HREF(1,"abs:href"),
    SRC(2, "abs:src")
    ;

    private int code;
    private String message;

    ReptileEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
