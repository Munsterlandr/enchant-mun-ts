package munsterlandr.munEnchants.enchantment

import munsterlandr.munEnchants.MunEnchants
import net.minecraft.enchantment.Enchantment
import net.minecraft.enchantment.EnchantmentTarget
import net.minecraft.entity.EquipmentSlot
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

class Concealed() : Enchantment(
    Enchantment.Rarity.VERY_RARE,
    EnchantmentTarget.ARMOR,
    arrayOf(EquipmentSlot.CHEST, EquipmentSlot.FEET, EquipmentSlot.HEAD, EquipmentSlot.LEGS)
) {
    companion object {
        val ID = Identifier(MunEnchants.MOD_ID, "concealed")
        fun register() {
            Registry.register(Registry.ENCHANTMENT, ID, Concealed())
        }
    }

    override fun getMaxLevel(): Int {
        return 1
    }

    override fun isTreasure(): Boolean {
        return true
    }


}