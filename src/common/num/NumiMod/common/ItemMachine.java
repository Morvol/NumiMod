package num.NumiMod.common;

import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class ItemMachine extends ItemBlock{
	
	public ItemMachine(int id){
		super(id);
		setMaxDamage(0);
		setHasSubtypes(true);
	}
 
	@Override
	public int getMetadata(int i){
	  return MachineType.validateMeta(i);
	}
	
	@Override
	public String getItemNameIS(ItemStack itemstack) {
		return MachineType.values()[itemstack.getItemDamage()].name();
	}
}
