package me.don.hypixelapitest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public record attributeInfo(int startingBid, Boolean bin) {

}
