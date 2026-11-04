package com.luka.titanes;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.core.Registry;

public final class TitanesMod implements ModInitializer {
    public static final String MOD_ID = "titanes";
    public static final ResourceKey<JukeboxSong> TITANES_SONG =
            ResourceKey.create(Registries.JUKEBOX_SONG, Identifier.fromNamespaceAndPath(MOD_ID, "titanes"));
    public static final ResourceKey<Item> TITANES_DISC_KEY =
            ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, "titanes_disc"));
    public static final Item TITANES_DISC = Items.register(
            TITANES_DISC_KEY,
            Item::new,
            new Item.Properties().stacksTo(1).jukeboxPlayable(TITANES_SONG)
    );

    @Override
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register(entries -> entries.accept(TITANES_DISC));
    }
}
