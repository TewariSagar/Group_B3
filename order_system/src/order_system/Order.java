package order_system;

public class Order {
	
    public String serial;
    public String itemName;
    public String shippingAddress;
    public Integer quantity;
   
    
    /**
     * 
     * @param itemName
     * @param itemName
     * @param shippingAddress
     * @param quantity
     * 
     * @author charlesc3929
     * @param quantity 
     * 
     * 
     */
    public Order(String serial, String itemName, String shippingAddress, Integer quantity) {

        this.serial = serial;
        this.itemName = itemName;
        this.shippingAddress = shippingAddress;
        this.quantity = quantity;

    }
    
    /**
     * 
     * @author charlesc3929
     * 
     * following methods are straightforward getters and setters
     * There is no setter for itemName, cannot be changed
     * 
     */
    public String getSerial() {
        return serial;
    }
    
    public String getItemName() {
        return itemName;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setItemName (String itemNameSetter) {
        this.itemName = itemNameSetter;
        System.out.println("");
    }

    public void setShippingAddress (String shippingAddressSetter) {
        this.shippingAddress = shippingAddressSetter;
    }

    public void setQuantity (int quantitySetter) {
        this.quantity = quantitySetter;
    }
    
  }