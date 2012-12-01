package num.NumiMod.common;

public enum MachineType {
	OVEN(0, "Oven", TileEntityOven.class),
	FRIDGE(1, "Fridge", TileEntityFridge.class);
	private int textureRow;
	public String friendlyName;
	public Class<? extends TileEntityMachine> clazz;
	
	MachineType(int textureRow, String friendlyName, Class<? extends TileEntityMachine> clazz){
		this.textureRow = textureRow;
		this.friendlyName = friendlyName;
		this.clazz = clazz;
	}
	
	public static TileEntityMachine makeEntity(int metadata) {
		int type = validateMeta(metadata);
		if (type == metadata) {
			TileEntityMachine te;
			try {
				te = values()[type].clazz.newInstance();
				return te;
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public int getTextureRow() {
		return textureRow;
	}
	
	public static int validateMeta(int i) {
		return i;
	}
	
	public boolean isValidForCreativeMode() {
		return validateMeta(ordinal())==ordinal();
	}
}