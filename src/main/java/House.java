public class House extends Asset {
    String address;
    int condition;
    int squareFoot;
    int lotSize;

    public House(double originalCost, String dateAcquired, String description, String address, int condition, int squareFoot, int lotSize) {
        super(originalCost, dateAcquired, description);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    public double getValue() {
        // A house's value is determined as
        // $180.00 per square foot (excellent)
        // $130.00 per square foot (good)
        // $90.00 per square foot (fair)
        // $80.00 per square foot (poor)
        // PLUS 25 cents per square foot of lot size

        return switch (condition) {
            case 1 -> (180 * squareFoot) + (25 * lotSize);
            case 2 -> (130 * squareFoot) + (25 * lotSize);
            case 3 -> (90 * squareFoot) + (25 * lotSize);
            default -> (80 * squareFoot) + (25 * lotSize);
        };
    }
}
