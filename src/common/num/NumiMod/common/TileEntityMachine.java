package num.NumiMod.common;

import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;

public class TileEntityMachine extends TileEntity{
	private byte facing;
	
	public TileEntityMachine(MachineType type) {
		super();
	}
	
	public byte getFacing() {
		return this.facing;
	}
	
	public void setFacing(byte blockFacing) {
		    this.facing = blockFacing;
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
