package com.melirate.dynamodb.Requests;

public class AllWeightRequest {
    private String id;
    private String Authorization;

    public AllWeightRequest() {

    }

    public AllWeightRequest(String id, String Authorization) {
        this.id = id;
        this.Authorization = Authorization;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthorization() {
        return Authorization;
    }

    public void setAuthorization(String Authorization) {
        this.Authorization = Authorization;
    }
}
