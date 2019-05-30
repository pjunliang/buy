package com.shop.tools;

public class AuctionCustomException extends  Exception {

    private String message;
    public AuctionCustomException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
