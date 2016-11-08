package warehouse_system.inventory;

class Item{
	
	private int id;
	private String name;
	private int weight;
	private int[] size;
	private int quantity;
	private int shelfID;
	private int row;
	
	public Item(int id, String name, int weight, int[] size, int quantity, int shelfID, int row) {
		super();
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.size = size;
		this.quantity=quantity;
		this.shelfID = shelfID;
		this.row = row;
	}

	public int getShelfID() {
		return shelfID;
	}

	public void setShelfID(int shelfID) {
		this.shelfID = shelfID;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setSize(int[] size) {
		this.size = size;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public int[] getSize() {
		return size;
	}
	public int getquantity(){
		return quantity;
	}
	public void setQuantity(int quantity){
		this.quantity=quantity;
	}
}