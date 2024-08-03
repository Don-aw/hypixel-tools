package me.don.hypixelapitest;

import java.util.*;

public class Hypixel {

    private final BitsConverter bitsConverter;
    private final AttributePrice ap;

    public Hypixel() {

        bitsConverter = new BitsConverter();
        ap = new AttributePrice();

    }

    public void selectUtil() throws Exception {

        Scanner input = new Scanner(System.in);
        System.out.println("Attribute[a] / Bits converter[b]");
        String choice = input.nextLine();


        //String choice = "b";

        if (Objects.equals(choice, "a")) {

            fetchAttributePrice();

        } else if (Objects.equals(choice, "b")) {

            //bit_convert(api);
            bitsConverter.fetchBazaar();
            bitsConverter.carrot_candy_upgrade();
            bitsConverter.heat_core();

        }

    }

    public static void fetchAttributePrice() throws Exception {

         ;

        System.out.println("Trying to fetch from coflnet api...");

        Map<String, List<Integer>> priceData = ap.fetchAttributes();

        System.out.println(priceData);

    }
}
