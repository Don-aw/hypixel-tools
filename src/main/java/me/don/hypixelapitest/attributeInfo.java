package me.don.hypixelapitest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record attributeInfo(int startingBid, Boolean bin) {

}
