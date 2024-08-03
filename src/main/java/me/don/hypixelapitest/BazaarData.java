package me.don.hypixelapitest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public record bazaarReply(int success, Array items) {
    
}
