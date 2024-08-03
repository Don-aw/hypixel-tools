package me.don.hypixelapitest;

import java.util.*;

public class Hypixel {

    private final BitsConverter bitsConverter;
    private final AttributePrice attributePrice;

    public Hypixel() {

        bitsConverter = new BitsConverter();
        attributePrice = new AttributePrice();

    }

    public void selectUtil() throws Exception {

        Scanner input = new Scanner(System.in);
        System.out.println("Attribute[a] / Bits converter[b]");
        String choice = input.nextLine();


        //String choice = "b";

        if (Objects.equals(choice, "a")) {

            attributePrice.fetchAttributes();
            attributePrice.showAttributePrice();

        } else if (Objects.equals(choice, "b")) {

            bitsConverter.fetchBazaar();
            bitsConverter.carrot_candy_upgrade();
            bitsConverter.heat_core();
            bitsConverter.promptCraft();

        }

    }

}
