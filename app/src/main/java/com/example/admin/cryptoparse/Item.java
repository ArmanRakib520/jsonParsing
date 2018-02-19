package com.example.admin.cryptoparse;


import java.io.Serializable;

public class Item implements Serializable
{
    private String twh_volume_usd;

    private String symbol;

    private String available_supply;

    private String percent_change_1h;

    private String price_usd;

    private String price_btc;

    private String id;

    private String total_supply;

    private String percent_change_24h;

    private String max_supply;

    private String rank;

    private String name;

    private String last_updated;

    private String percent_change_7d;

    private String market_cap_usd;

    public String get24h_volume_usd ()
    {
        return twh_volume_usd;
    }

    public void set24h_volume_usd (String twh_volume_usd)
    {
        this.twh_volume_usd = twh_volume_usd;
    }


    public String getAvailable_supply ()
    {
        return available_supply;
    }

    public void setAvailable_supply (String available_supply)
    {
        this.available_supply = available_supply;
    }


    public String getPrice_usd ()
    {
        return price_usd;
    }

    public void setPrice_usd (String price_usd)
    {
        this.price_usd = price_usd;
    }

    public String getPrice_btc ()
    {
        return price_btc;
    }

    public void setPrice_btc (String price_btc)
    {
        this.price_btc = price_btc;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }



    public String getRank ()
    {
        return rank;
    }

    public void setRank (String rank)
    {
        this.rank = rank;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getLast_updated ()
    {
        return last_updated;
    }

    public void setLast_updated (String last_updated)
    {
        this.last_updated = last_updated;
    }



    public String getMarket_cap_usd ()
    {
        return market_cap_usd;
    }

    public void setMarket_cap_usd (String market_cap_usd)
    {
        this.market_cap_usd = market_cap_usd;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [24h_volume_usd = "+twh_volume_usd+", symbol = "+symbol+", available_supply = "+available_supply+", percent_change_1h = "+percent_change_1h+", price_usd = "+price_usd+", price_btc = "+price_btc+", id = "+id+", total_supply = "+total_supply+", percent_change_24h = "+percent_change_24h+", max_supply = "+max_supply+", rank = "+rank+", name = "+name+", last_updated = "+last_updated+", percent_change_7d = "+percent_change_7d+", market_cap_usd = "+market_cap_usd+"]";
    }
}

