package num.NumiMod.common;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import net.minecraft.src.BlockContainer;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockMachine extends BlockContainer{
	//Definitions
	public boolean isActive = false;
	
	public BlockMachine(int id)
    {
		super(id, Material.iron);
		setBlockName("Machine");
		setHardness(3.0F);
		setRequiresSelfNotify();
        setCreativeTab(NumiMod.tabNumiMod);
    }
	
	@Override
	public TileEntity createNewTileEntity(World w) {
	    return null;
	  }
	
	public String getTextureFile()
    {
            return CommonProxy.BLOCKS_PNG;
    }
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return MachineType.makeEntity(metadata);
	}
	
	public int getBlockTexture(IBlockAccess worldAccess, int i, int j, int k, int l) {
		int meta = worldAccess.getBlockMetadata(i, j, k);
	    MachineType type = MachineType.values()[meta];
	    TileEntity te = worldAccess.getBlockTileEntity(i, j, k);
	    TileEntityMachine mte = null;
	    if (te != null && te instanceof TileEntityMachine) {
	    	mte = (TileEntityMachine) te;
	    }
	    if (l == 0 || l == 1) { // Top and Bottom
	    	return type.getTextureRow() * 16 + 3;
	    } else if (mte != null && l == mte.getFacing()) { // Front
	    	if (this.isActive == true){
	    		return type.getTextureRow() * 16 + 1;
	    	}else{
	    		return type.getTextureRow() * 16 + 0;
	    	} 
	    } else { // Back and Sides
	    	if (this.isActive == true){
	    		return type.getTextureRow() * 16 + 22;
	    	}else{
	    		return type.getTextureRow() * 16 + 2;
	    	}
	    }
	    
	}
	  
	@Override
	  public int getBlockTextureFromSideAndMetadata(int i, int j) {
	    MachineType type = MachineType.values()[j];
	    switch (i) {
	    case 0:
	    case 1:
	      return type.getTextureRow() * 16 + 3;
	    case 3:
	    	if (this.isActive == false){
	    		return type.getTextureRow() * 16 + 0;
	    	}else{
	    		return type.getTextureRow() * 16 + 1;
	    	} 
	    default:
	      return type.getTextureRow() * 16 + 2;
	    }
	  }

	@Override
	  public void onBlockAdded(World world, int i, int j, int k) {
	    super.onBlockAdded(world, i, j, k);
	    world.markBlockForUpdate(i, j, k);
	  }

	  @Override
	  public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving) {
	    byte blockFacing = 0;
	    int facing = MathHelper.floor_double((double) ((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
	    if (facing == 0) {
	      blockFacing = 2;
	    }
	    if (facing == 1) {
	      blockFacing = 5;
	    }
	    if (facing == 2) {
	      blockFacing = 3;
	    }
	    if (facing == 3) {
	      blockFacing = 4;
	    }
	    TileEntity te = world.getBlockTileEntity(i, j, k);
	    if (te != null && te instanceof TileEntityMachine) {
	      ((TileEntityMachine) te).setFacing(blockFacing);
	      world.markBlockForUpdate(i, j, k);
	    }
	  }

	  @Override
	  public int damageDropped(int i) {
	    return i;
	  }

	  @Override
	  public void breakBlock(World world, int i, int j, int k, int i1, int i2)
	  {
		TileEntityMachine tileentitymachine = (TileEntityMachine) world.getBlockTileEntity(i, j, k);
	    super.breakBlock(world, i, j, k, i1, i2);
	  }

	@Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
  	@SideOnly(Side.CLIENT)
  	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
  	    for (MachineType type : MachineType.values()) {
  	        if (type.isValidForCreativeMode()) {
  	          par3List.add(new ItemStack(this, 1, type.ordinal()));
  	        }
  	      }
  	}

}