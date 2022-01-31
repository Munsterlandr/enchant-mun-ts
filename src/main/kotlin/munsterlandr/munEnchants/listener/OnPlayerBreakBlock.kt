package munsterlandr.munEnchants.listener

import munsterlandr.munEnchants.enchantment.Forbidden
import net.fabricmc.fabric.api.event.player.AttackBlockCallback
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.World
import net.minecraft.world.explosion.Explosion

object OnPlayerBreakBlock: AttackBlockCallback {
    override fun interact(
        player: PlayerEntity?,
        world: World?,
        hand: Hand?,
        pos: BlockPos?,
        direction: Direction?
    ): ActionResult {
        if (!player!!.isSpectator) {
            for (item in player!!.itemsHand) {
                println(item)
                if (item.enchantments.contains(EnchantmentHelper.createNbt(Forbidden.ID, 1))) {
                    Explosion(world, player, player.x, player.y, player.z, 5.0.toFloat())
                }
            }
        }
        return ActionResult.PASS
    }

}