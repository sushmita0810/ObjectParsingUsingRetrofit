package com.sushmita.jsonparsingthroughretrofit;

import java.util.HashMap;
import java.util.Map;

public class UserResponse
{
    private String source;
    private String sch_date;
    private String trucktype;
    private String destination;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSch_date() {
        return sch_date;
    }

    public void setSch_date(String sch_date) {
        this.sch_date = sch_date;
    }

    public String getTrucktype() {
        return trucktype;
    }

    public void setTrucktype(String trucktype) {
        this.trucktype = trucktype;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
