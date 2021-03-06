package gigaherz.enderRift.rift;

import gigaherz.enderRift.EnderRiftMod;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IForgeRegistryEntry;

import javax.annotation.Nullable;

public class RecipeRiftDuplication extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe
{
    {
        setRegistryName(EnderRiftMod.location("rift_duplication"));
    }

    @Override
    public boolean matches(InventoryCrafting crafting, World p_77569_2_)
    {
        if (crafting.getSizeInventory() < 9)
            return false;

        ItemStack stack = crafting.getStackInSlot(4);
        if (stack.getCount() <= 0)
            return false;

        if (stack.getItem() != EnderRiftMod.riftOrb)
            return false;

        NBTTagCompound tag = stack.getTagCompound();
        if (tag == null || !tag.hasKey("RiftId"))
            return false;

        if (!slotHasItem(crafting, 0, Items.MAGMA_CREAM))
            return false;

        if (!slotHasItem(crafting, 1, Items.ENDER_PEARL))
            return false;

        if (!slotHasItem(crafting, 2, Items.MAGMA_CREAM))
            return false;

        if (!slotHasItem(crafting, 3, Items.ENDER_PEARL))
            return false;

        if (!slotHasItem(crafting, 5, Items.ENDER_PEARL))
            return false;

        if (!slotHasItem(crafting, 6, Items.MAGMA_CREAM))
            return false;

        if (!slotHasItem(crafting, 7, Items.ENDER_PEARL))
            return false;

        if (!slotHasItem(crafting, 8, Items.MAGMA_CREAM))
            return false;

        return true;
    }

    private boolean slotHasItem(InventoryCrafting crafting, int slot, Item item)
    {
        ItemStack stack = crafting.getStackInSlot(slot);
        return stack.getItem() == item;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting crafting)
    {
        ItemStack stack = crafting.getStackInSlot(4).copy();
        stack.setCount(2);
        return stack;
    }

    @Override
    public boolean canFit(int width, int height)
    {
        return (width == 3) && (height == 3);
    }

    @Override
    public ItemStack getRecipeOutput()
    {
        return ItemStack.EMPTY;
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(InventoryCrafting inv)
    {
        return NonNullList.withSize(inv.getSizeInventory(), ItemStack.EMPTY);
    }
}