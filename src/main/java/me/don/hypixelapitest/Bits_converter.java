package me.don.hypixelapitest;

import java.util.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

import net.hypixel.api.HypixelAPI;
import net.hypixel.api.reply.skyblock.BazaarReply;

public class Bits_converter {

    public static DecimalFormat formatting() {

        // Create an instance of DecimalFormat for US locale
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);

        // Get the DecimalFormatSymbols instance associated with this formatter
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

        //setting seperater
        symbols.setGroupingSeparator(',');
        formatter.setDecimalFormatSymbols(symbols);

        return formatter;

    }

    public static void carrot_candy_upgrade(BazaarReply bazaarReply, DecimalFormat formatter) {

            //temp holder for summing
            double total = 0;

            // calculate enchanted golden carrot price/unit
            for(int i = 0; i < 3; i++) {
                total += bazaarReply.getProduct("ENCHANTED_GOLDEN_CARROT").getBuySummary().get(i).getPricePerUnit();
            }
            double egc_cost = Math.round(total / 3);
            //System.out.println("Enchanted Golden Carrot Ave. Price: " + egc_cost);

            //calculate enchanted carrot price/unit
            total = 0;
            for(int i = 0; i < 3; i++) {
                total += bazaarReply.getProduct("ENCHANTED_CARROT").getBuySummary().get(i).getPricePerUnit();
            }
            double ec_cost = Math.round(total / 3);
            //System.out.println("Enchanted Carrot Ave. Price: " + formatter.format(ec_cost));

            //calculate simple carrot candy price/unit
            total = 0;
            for(int i = 0; i < 3; i++) {
                total += bazaarReply.getProduct("SIMPLE_CARROT_CANDY").getBuySummary().get(i).getPricePerUnit();
            }
            double scc_cost = Math.round(total / 3);
            //System.out.println("Simple Carrot Candy Ave. Price: " + formatter.format(scc_cost));

            //calculate cost for crafting 10 ultimate carrot candies
            double ucc_craft_cost = Math.round(egc_cost * 192 + ec_cost * 2560 + 8 * scc_cost);
            //System.out.println("Total cost to craft 10 ultimate: " + formatter.format(ucc_craft_cost));

            //finding the ultimate carrot candy price
            total = 0;
            for(int i = 0; i < 3; i++) {
                total += bazaarReply.getProduct("ULTIMATE_CARROT_CANDY").getBuySummary().get(i).getPricePerUnit();
            }
            double ucc_cost = Math.round(total / 3);
            //System.out.println("Ultimate Carrot Candy Ave. Price: " + formatter.format(ucc_cost));

            //hence calculating the ultimate carrot candy upgrade price and the bit conversion
            double uccu_cost = 10 * ucc_cost - ucc_craft_cost;
            System.out.println("\nUltimate Carrot Candy Upgrade is worth: " + formatter.format(uccu_cost));
            System.out.println("Which equates to: " + Math.round(uccu_cost/8000) + "c/b");


    }

    public static void heat_core(BazaarReply bazaarReply, DecimalFormat formatter) {

        //calculate enchanted lava bucket price
        double total = 0;
        for(int i = 0; i < 3; i++) {
            total += bazaarReply.getProduct("ENCHANTED_LAVA_BUCKET").getBuySummary().get(i).getPricePerUnit();
        }
        double elb_cost = Math.round(total / 3);
        //System.out.println("Enchanted Lava Bucket Ave. Price: " + formatter.format(elb_cost));

        //calculate magma bucket price
        total = 0;
        for(int i = 0; i < 3; i++) {
            total += bazaarReply.getProduct("MAGMA_BUCKET").getBuySummary().get(i).getPricePerUnit();
        }
        double mb_cost = Math.round(total / 3);
        //System.out.println("Magma Bucket Ave. Price: " + formatter.format(mb_cost));

        double hc_cost = mb_cost - 2 * elb_cost;
        System.out.println("\nHeat Core is worth: " + hc_cost);
        System.out.println("Which equates to: " + Math.round(hc_cost / 3000) + "c/b");

    }

    public static void crafting_recipe(String recipe_name, int amt) {

        if (Objects.equals(recipe_name, "ucc")) {

            System.out.println("\nRequired Ench Golden Carrot:    " + amt * 192);
            System.out.println("Required Ench Carrot:           " + amt * 2560);
            System.out.println("Required Simple Candy:          " + amt * 8);

        }


    }

}
