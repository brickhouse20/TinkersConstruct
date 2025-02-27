package slimeknights.tconstruct.tools.data;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.materials.MaterialValues;
import slimeknights.tconstruct.tools.TinkerModifiers;

public class MaterialDataProvider extends AbstractMaterialDataProvider {
  public MaterialDataProvider(DataGenerator gen) {
    super(gen);
  }

  @Override
  public String getName() {
    return "Tinker's Construct Materials";
  }

  @Override
  protected void addMaterials() {
    // tier 1
    addMaterialNoFluid(MaterialIds.wood, 1, ORDER_GENERAL, true, 0x8e661b, TinkerModifiers.cultivated.get());
    addMaterialNoFluid(MaterialIds.stone, 1, ORDER_HARVEST, true, 0x999999, TinkerModifiers.stonebound.get());
    addMaterialNoFluid(MaterialIds.flint, 1, ORDER_WEAPON,  true, 0x696969, TinkerModifiers.jagged.get());
    addMaterialNoFluid(MaterialIds.bone,  1, ORDER_SPECIAL, true, 0xE8E5D2, TinkerModifiers.fractured.get());
    // tier 1 - nether
    addMaterialNoFluid(MaterialIds.necroticBone,  1, ORDER_SPECIAL, true, 0x4D4D4D, TinkerModifiers.necrotic.get());
    // tier 2
    addMetalMaterial(MaterialIds.iron, 2, ORDER_GENERAL, TinkerFluids.moltenIron.get(), 0xD8D8D8, TinkerModifiers.sturdy.get());
    addMaterialWithFluid(MaterialIds.copper,        2, ORDER_HARVEST, TinkerFluids.moltenCopper.get(), MaterialValues.INGOT,     true,  0xF98648, TinkerModifiers.dwarven.get());
    addMaterialWithFluid(MaterialIds.searedStone,   2, ORDER_WEAPON, TinkerFluids.searedStone.get(),   MaterialValues.INGOT * 2, false, 0x4F4A47, TinkerModifiers.searing.get());
    addMaterialWithFluid(MaterialIds.scorchedStone, 2, ORDER_NETHER, TinkerFluids.scorchedStone.get(), MaterialValues.INGOT * 2, false, 0x5B4C43, TinkerModifiers.scorching.get());
    addMaterialNoFluid(MaterialIds.slimewood, 2, ORDER_SPECIAL, false, 0x82c873, TinkerModifiers.overgrowth.get(), TinkerModifiers.overslime.get());
    // tier 3
    addMetalMaterial(MaterialIds.slimesteel,    3, ORDER_GENERAL, TinkerFluids.moltenSlimesteel.get(), 0x27C6C6, TinkerModifiers.overcast.get(), TinkerModifiers.overslime.get());
    addMetalMaterial(MaterialIds.tinkersBronze, 3, ORDER_HARVEST, TinkerFluids.moltenTinkersBronze.get(), 0xE8B465, TinkerModifiers.wellMaintained.get());
    addMaterialNoFluid(MaterialIds.nahuatl,     3, ORDER_WEAPON,  false, 0x3B2754, TinkerModifiers.lacerating.get());
    addMetalMaterial(MaterialIds.roseGold,      3, ORDER_SPECIAL, TinkerFluids.moltenRoseGold.get(), 0xF7CDBB, TinkerModifiers.enhanced.get());
    addMetalMaterial(MaterialIds.pigIron,       3, ORDER_SPECIAL, TinkerFluids.moltenPigIron.get(), 0xF0A8A4, TinkerModifiers.tasty.get());
    // tier 3 (nether)
    addMetalMaterial(MaterialIds.cobalt, 3, ORDER_NETHER, TinkerFluids.moltenCobalt.get(), 0x2376dd, TinkerModifiers.lightweight.get());
    // tier 4
    addMetalMaterial(MaterialIds.queensSlime, 4, ORDER_GENERAL, TinkerFluids.moltenQueensSlime.get(), 0x236c45, TinkerModifiers.overlord.get(), TinkerModifiers.overslime.get());
    addMetalMaterial(MaterialIds.hepatizon,   4, ORDER_HARVEST, TinkerFluids.moltenHepatizon.get(),   0x60496b, TinkerModifiers.momentum.get());
    addMetalMaterial(MaterialIds.manyullyn,   4, ORDER_WEAPON,  TinkerFluids.moltenManyullyn.get(),   0x9261cc, TinkerModifiers.insatiable.get());
    //addMetalMaterial(MaterialIds.soulsteel, 4, ORDER_SPECIAL, TinkerFluids.moltenSoulsteel.get(), 0x6a5244);

    // tier 2 (end)
    //addMaterialNoFluid(MaterialIds.endstone, 2, ORDER_END, true, 0xe0d890);

    // tier 2 (mod integration)
    addCompatMetalMaterial(MaterialIds.lead,   2, ORDER_COMPAT, TinkerFluids.moltenLead.get(),   0x575E79, TinkerModifiers.heavy.get());
    addCompatMetalMaterial(MaterialIds.silver, 2, ORDER_COMPAT, TinkerFluids.moltenSilver.get(), 0xD3DFE8, TinkerModifiers.smite.get());
    // tier 3 (mod integration)
    addCompatMetalMaterial(MaterialIds.electrum,   3, ORDER_COMPAT,  TinkerFluids.moltenElectrum.get(),   0xD9C25F, TinkerModifiers.experienced.get());
    addCompatMetalMaterial(MaterialIds.bronze,     3, ORDER_HARVEST, TinkerFluids.moltenBronze.get(),     0xD58F36, TinkerModifiers.wellMaintained2.get());
    addCompatMetalMaterial(MaterialIds.steel,      3, ORDER_GENERAL, TinkerFluids.moltenSteel.get(),      0x959595, TinkerModifiers.ductile.get());
    addCompatMetalMaterial(MaterialIds.constantan, 3, ORDER_COMPAT,  TinkerFluids.moltenConstantan.get(), 0x9C5643, TinkerModifiers.temperate.get());
  }
}
