package munsterlandr.munEnchants.enchantment

import munsterlandr.munEnchants.MunEnchants
import net.minecraft.enchantment.Enchantment
import net.minecraft.enchantment.EnchantmentTarget
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.entity.EquipmentSlot
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.mob.HostileEntity
import net.minecraft.entity.mob.SkeletonEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier
import net.minecraft.util.math.Vec3d
import net.minecraft.util.registry.Registry
import net.minecraft.world.World

class Beheading(): Enchantment(
    Rarity.UNCOMMON,
    EnchantmentTarget.WEAPON,
    arrayOf(EquipmentSlot.OFFHAND, EquipmentSlot.MAINHAND)
) {
    companion object {
        val ID = Identifier(MunEnchants.MOD_ID, "beheading")

        fun register() {
            Registry.register(Registry.ENCHANTMENT, ID, Beheading())
        }
    }

    override fun getMaxLevel(): Int {
        return 5
    }

    override fun getMinLevel(): Int {
        return 1
    }

    override fun isCursed(): Boolean {
        return false
    }

    override fun isTreasure(): Boolean {
        return false
    }

    override fun onTargetDamaged(user: LivingEntity?, target: Entity?, level: Int) {
        if (target!!.isLiving && !target.isAlive) {
            val loc = target.pos
            val world = target.world
            if (target.isPlayer) {
                val actualTarget = target as PlayerEntity
                TODO("Finish this shit")
            } else if (target.type == EntityType.SKELETON) {

            } else if (target.type == EntityType.WITHER_SKELETON) {

            } else if (target.type == EntityType.CREEPER) {

            }
        }
    }

    private fun dropHead(head: ItemStack, loc: Vec3d, world: World) {

    }
}