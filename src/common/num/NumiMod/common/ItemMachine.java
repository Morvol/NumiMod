package num.NumiMod.common;

import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class ItemMachine extends ItemBlock
{
	public ItemMachine(int par1, Block block) 
	{
		super(par1);
		setHasSubtypes(true);
	}
 
	public String getItemNameIS(ItemStack i){
		switch(i.getItemDamage()){
		case 0:return "Oven";
		case 1:return "Fridge";
		default:return "";
		}
		}
 
	public int getMetadata(int par1)
	{
		return par1;
    }
}
