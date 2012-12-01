package num.NumiMod.common;

import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;

public class TileEntityMachine extends TileEntity{
	private byte facing;
	private MachineType type;

	
	public TileEntityMachine(MachineType type) {
		super();
	}
	
	public byte getFacing() {
		return this.facing;
	}
	
	public void setFacing(byte blockFacing) {
		    this.facing = blockFacing;
	}
	public TileEntityMachine updateFromMetadata(int l) {
	if (worldObj != null && worldObj.isRemote) {
		if (l != type.ordinal()) {
				worldObj.setBlockTileEntity(xCoord, yCoord, zCoord, MachineType.makeEntity(l));
				return (TileEntityMachine) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord);
				}
		}
	return this;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbttagcompound){
		super.readFromNBT(nbttagcompound);
		facing = nbttagcompound.getByte("facing");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbttagcompound){
		super.writeToNBT(nbttagcompound);
		nbttagcompound.setByte("facing", facing);
	}
	  
	@Override
	public void updateEntity() {
	   super.updateEntity();
	}
}
