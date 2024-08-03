package me.don.hypixelapitest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public record attributeInfo(int startingBid, Boolean bin) {
    //String uuid,
    //int count,
    //String tag,
    //String itemName,
    //String start,
    //String end,
    //String auctioneerId,
    //String profileId,
    //String coop,
    //String coopMembers,
    //int highestBidAmount,
    //String bids,
    //int anvilUses,
    //ArrayList enchantments,
    //ArrayList nbtData,
    //String itemCreatedAt,
    //String reforge,
    //String category,
    //String tier,
    //ArrayList flatNbt

    @Override
    public String toString() {
        return "attributeInfo[" +
                "startingBid=" + startingBid + ", " +
                "bin=" + bin + ']';
    }

}
