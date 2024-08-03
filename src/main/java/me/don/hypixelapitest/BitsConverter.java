package me.don.hypixelapitest;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.util.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.time.Duration;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BitsConverter {

    private final HttpClient client;
    private final ObjectMapper objectMapper;
    private final DecimalFormat formatter;
    private final DecimalFormatSymbols symbols;
    private BazaarData bazaarData;

    public BitsConverter() {

        client = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper();
        formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        symbols = formatter.getDecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        formatter.setDecimalFormatSymbols(symbols);

    }

    public void fetchBazaar() {

        String BASE_URL = "https://api.hypixel.net/v2/skyblock/bazaar";

        HttpRequest request = HttpRequest.newBuilder()
                .timeout(Duration.ofSeconds(5))
                .uri(URI.create(BASE_URL))
                //.header("Accept", "application/json")
                .GET()
                .build();
        try {

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //System.out.println(response.body().substring(0, 100));

            bazaarData = objectMapper.readValue(response.body(), BazaarData.class);

        } catch (HttpTimeoutException e) {
            System.out.println("Connection timeout");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void carrot_candy_upgrade() {

            //temp holder for summing
            double total = 0;

            // calculate enchanted golden carrot price/unit
            for(int i = 0; i < 3; i++) {
                total += bazaarData.getProduct("ENCHANTED_GOLDEN_CARROT").getBuy_summary().get(i).getPricePerUnit();
            }
            double egc_cost = Math.round(total / 3);
            //System.out.println("Enchanted Golden Carrot Ave. Price: " + egc_cost);

            //calculate enchanted carrot price/unit
            total = 0;
            for(int i = 0; i < 3; i++) {
                total += bazaarData.getProduct("ENCHANTED_CARROT").getBuy_summary().get(i).getPricePerUnit();
            }
            double ec_cost = Math.round(total / 3);
            //System.out.println("Enchanted Carrot Ave. Price: " + formatter.format(ec_cost));

            //calculate simple carrot candy price/unit
            total = 0;
            for(int i = 0; i < 3; i++) {
                total += bazaarData.getProduct("SIMPLE_CARROT_CANDY").getBuy_summary().get(i).getPricePerUnit();
            }
            double scc_cost = Math.round(total / 3);
            //System.out.println("Simple Carrot Candy Ave. Price: " + formatter.format(scc_cost));

            //calculate cost for crafting 10 ultimate carrot candies
            double ucc_craft_cost = Math.round(egc_cost * 192 + ec_cost * 2560 + 8 * scc_cost);
            //System.out.println("Total cost to craft 10 ultimate: " + formatter.format(ucc_craft_cost));

            //finding the ultimate carrot candy price
            total = 0;
            for(int i = 0; i < 3; i++) {
                total += bazaarData.getProduct("ULTIMATE_CARROT_CANDY").getBuy_summary().get(i).getPricePerUnit();
            }
            double ucc_cost = Math.round(total / 3);
            //System.out.println("Ultimate Carrot Candy Ave. Price: " + formatter.format(ucc_cost));
            //hence calculating the ultimate carrot candy upgrade price and the bit conversion
            double uccu_cost = 10 * ucc_cost - ucc_craft_cost;
            System.out.println("\nUltimate Carrot Candy Upgrade is worth: " + formatter.format(uccu_cost));
            System.out.println("Which equates to: " + Math.round(uccu_cost/8000) + "c/b");


    }

    public void heat_core() {

        //calculate enchanted lava bucket price
        double total = 0;
        for(int i = 0; i < 3; i++) {
            total += bazaarData.getProduct("ENCHANTED_LAVA_BUCKET").getBuy_summary().get(i).getPricePerUnit();
        }
        double elb_cost = Math.round(total / 3);
        //System.out.println("Enchanted Lava Bucket Ave. Price: " + formatter.format(elb_cost));

        //calculate magma bucket price
        total = 0;
        for(int i = 0; i < 3; i++) {
            total += bazaarData.getProduct("MAGMA_BUCKET").getBuy_summary().get(i).getPricePerUnit();
        }
        double mb_cost = Math.round(total / 3);
        //System.out.println("Magma Bucket Ave. Price: " + formatter.format(mb_cost));

        double hc_cost = mb_cost - 2 * elb_cost;
        System.out.println("\nHeat Core is worth: " + hc_cost);
        System.out.println("Which equates to: " + Math.round(hc_cost / 3000) + "c/b");

    }

    public void promptCraft() {

        Scanner input = new Scanner(System.in);

        System.out.println("\nProceed to crafting? [y/n]");
        String craft = input.nextLine();
        if (Objects.equals(craft, "n"))
            System.exit(0);

        System.out.println("What to craft?");
        String recipe_name = input.nextLine();

        System.out.println("How much? [int]");
        int amt = input.nextInt();

        //Leaves room for adding for crafting recipes if needed
        switch(recipe_name){

            case "ucc": craftUltimateCarrotCandy(amt);
                        break;
            default:    System.out.println("Invalid crafting option." + recipe_name);

        }

    }

    private void craftUltimateCarrotCandy(int amt) {

        System.out.println("\nRequired Ench Golden Carrot:    " + amt * 192);
        System.out.println("Required Ench Carrot:           " + amt * 2560);
        System.out.println("Required Simple Candy:          " + amt * 8);

    }

}
