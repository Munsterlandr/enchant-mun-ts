package munsterlandr.munEnchants.listener

import munsterlandr.munEnchants.enchantment.Forbidden
import net.fabricmc.fabric.api.event.player.UseItemCallback
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtHelper
import net.minecraft.nbt.NbtIo
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World
import net.minecraft.world.explosion.Explosion

object OnPlayerUseItem: UseItemCallback {
    override fun interact(player: PlayerEntity?, world: World?, hand: Hand?): TypedActionResult<ItemStack> {
        if (player?.activeItem?.enchantments!!.contains(EnchantmentHelper.createNbt(Forbidden.ID, 1))) {
            Explosion(player.world, player, player.x, player.y, player.z, 5.0.toFloat())
            return TypedActionResult(ActionResult.SUCCESS, ItemStack.EMPTY)
        } else {
            return TypedActionResult.pass(ItemStack.EMPTY)
        }
    }
}