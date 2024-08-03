package me.don.hypixelapitest;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class BazaarData{
    private long lastUpdated;
    private Map<String, Product> products;

    public BazaarData() {
    }

    public Map<String, Product> getProducts() {
        return this.products;
    }

    public Product getProduct(String productId) {
        return (Product)this.products.get(productId);
    }

    public String toString() {
        return "BazaarReply{lastUpdated=" + this.lastUpdated + ", products=" + this.products + "} " + super.toString();
    }

    public static class Product {
        private String product_id;
        private List<Summary> sell_summary;
        private List<Summary> buy_summary;
        private Status quick_status;

        public Product() {
        }

        public String getProduct_id() {
            return this.product_id;
        }

        public List<Summary> getSell_summary() {
            return this.sell_summary;
        }

        public List<Summary> getBuy_summary() {
            return this.buy_summary;
        }

        public Status getQuick_status() {
            return this.quick_status;
        }

        public String toString() {
            return "Product{product_id='" + this.product_id + ", sell_summary=" + this.sell_summary + ", buy_summary=" + this.buy_summary + ", quick_status=" + this.quick_status + "}";
        }

        public static class Status {
            private String productId;
            private double sellPrice;
            private int sellVolume;
            private int sellMovingWeek;
            private int sellOrders;
            private double buyPrice;
            private int buyVolume;
            private int buyMovingWeek;
            private int buyOrders;

            public Status() {
            }

            public String getProductId() {
                return this.productId;
            }

            public double getSellPrice() {
                return this.sellPrice;
            }

            public int getSellVolume() {
                return this.sellVolume;
            }

            public int getSellMovingWeek() {
                return this.sellMovingWeek;
            }

            public int getSellOrders() {
                return this.sellOrders;
            }

            public double getBuyPrice() {
                return this.buyPrice;
            }

            public int getBuyVolume() {
                return this.buyVolume;
            }

            public int getBuyMovingWeek() {
                return this.buyMovingWeek;
            }

            public int getBuyOrders() {
                return this.buyOrders;
            }

            public String toString() {
                return "Status{product_id='" + this.productId + ", sellPrice=" + this.sellPrice + ", sellVolume=" + this.sellVolume + ", sellMovingWeek=" + this.sellMovingWeek + ", sellOrders=" + this.sellOrders + ", buyPrice=" + this.buyPrice + ", buyVolume=" + this.buyVolume + ", buyMovingWeek=" + this.buyMovingWeek + ", buyOrders=" + this.buyOrders + "}";
            }
        }

        public static class Summary {
            private int amount;
            private double pricePerUnit;
            private int orders;

            public Summary() {
            }

            public int getAmount() {
                return this.amount;
            }

            public double getPricePerUnit() {
                return this.pricePerUnit;
            }

            public int getOrders() {
                return this.orders;
            }

            public String toString() {
                return "Summary{amount=" + this.amount + ", pricePerUnit=" + this.pricePerUnit + ", orders=" + this.orders + "}";
            }
        }
    }
}