package me.don.hypixelapitest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttributePrice {

    private final HttpClient client;
    private final ObjectMapper objectMapper;
    private Map<String, List<Integer>> attributeLowestBin;

    public AttributePrice() {
        client = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper();
        attributeLowestBin = new HashMap<String, List<Integer>>();

    }

    public void fetchAttributes() throws Exception{

        String[] attributeNames = {"mana_pool", "double_hook", "lifeline", "vitality", "blazing_fortune", "veteran"};

        System.out.println("Trying to fetch from coflnet api...");

        for (String attributeName : attributeNames) {

            List<Integer> tierLBin = new ArrayList<Integer>();

            for (int i = 0; i <= 2; i++) {

                int tier = i + 1;
                String BASE_URL = "https://sky.coflnet.com/api/auctions/tag/attribute_shard/active/bin?" + attributeName + "=" + tier;

                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URL)).GET().build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                try {
                    List<attributeInfo> attributeinfos = objectMapper.readValue(response.body(), new TypeReference<>() {});
                    tierLBin.add(attributeinfos.getFirst().startingBid());
                } catch (Exception e) {
                    System.out.println(attributeName + " tier " + tier + " is not on the auction house.");
                    tierLBin.add(null);
                }

                //Thread.sleep(100);
                //System.out.println("loading " + attributeName + ", " + tier + " out of 3...");


            }

            attributeLowestBin.put(attributeName, tierLBin);

        }
    }

    public void showAttributePrice() {

        System.out.println(attributeLowestBin);

    }
}
