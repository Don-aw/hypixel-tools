package me.don.hypixelapitest;

import net.hypixel.api.HypixelAPI;

import java.text.DecimalFormat;
import java.util.*;

public class hypixel {

    public static void main(String[] args) throws Exception {

        HypixelAPI api = new HypixelAPI(UUID.fromString(""));


        Scanner input = new Scanner(System.in);
        System.out.println("Attribute[a] / Bits converter[b]");
        String choice = input.nextLine();


        //String choice = "b";

        if (Objects.equals(choice, "a")) {

            fetchAttributePrice();

        } else if (Objects.equals(choice, "b")) {

            bit_convert(api);

        }


    }

    public static void bit_convert(HypixelAPI api) {

        System.out.println("Initiating Fetch...");

        api.getBazaar().whenComplete((bazaarReply, throwable) -> {

            if (throwable != null) {

                System.out.println("A connection error has occurred.\n" + throwable);

            } else {

                DecimalFormat formatter = Bits_converter.formatting();

                Bits_converter.carrot_candy_upgrade(bazaarReply, formatter);
                Bits_converter.heat_core(bazaarReply, formatter);

                Scanner input = new Scanner(System.in);

                System.out.println("\nProceed to crafting? [y/n]");
                String craft = input.nextLine();

                if (Objects.equals(craft, "y")) {

                    System.out.println("What to craft? [ucc]");
                    String recipe_name = input.nextLine();

                    System.out.println("How much? [int]");
                    int amt = input.nextInt();

                    Bits_converter.crafting_recipe(recipe_name, amt);

                } else {

                    System.exit(0);

                }


            }


        });





    }

    public static void fetchAttributePrice() throws Exception {

        AttributePrice ap = new AttributePrice();

        System.out.println("Trying to fetch from coflnet api...");

        Map<String, List<Integer>> priceData = ap.fetchAttributes();

        System.out.println(priceData);

    }
}
