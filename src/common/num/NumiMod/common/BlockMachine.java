package num.NumiMod.common;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import num.NumiMod.client.ClientProxy;

public class BlockMachine extends Block
{
	//Definitions
	public static boolean powered = false;
	public BlockMachine(int par1, int par2)
    {
        super(par1, par2, Material.rock);
        this.setCreativeTab(NumiMod.tabNumiMod);
        this.setRequiresSelfNotify();
    }
    
    public int getBlockTextureFromSideAndMetadata(int par1, int par2) 
    {
    	if (par2 == 0) 
    	{
    		switch(par1){
    			case 0:
    				return 3;
    			case 1:
    				return 3;
    			case 4:
    				if(powered == false){
    					return 0;
    				}else{
    					return 1;
    				}
    			default:
    				return 2;
    			}
        }else{
        	switch(par1){
        		case 0:
        			return 3+16;
        		case 1:
        			return 3+16;
        		case 4:
        			if(powered == false){
        				return 0+16;
        			}else{
        				return 1+16;
        			}
        		default:
        			return 2+16;
        		}
        }
    }
    
    public String getTextureFile()
    {
            return CommonProxy.BLOCKS_PNG;
    }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
    	return this.blockID;
    }
    
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < 2; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }

    
    public int damageDropped(int j) 
    {
    	return j;
    }
}