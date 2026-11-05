package com.luka.titanes;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;

import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.JukeboxSong;

public final class TitanesMod implements ModInitializer {

    public static final String MOD_ID = "titanes";

    public static final ResourceKey<JukeboxSong> TITANES_SONG =
            ResourceKey.create(
                    Registries.JUKEBOX_SONG,
                    Identifier.fromNamespaceAndPath(MOD_ID, "titanes")
            );

    public static final ResourceKey<Item> TITANES_DISC_KEY =
            ResourceKey.create(
                    Registries.ITEM,
                    Identifier.fromNamespaceAndPath(MOD_ID, "titanes_disc")
            );

    public static final Item TITANES_DISC = registerDisc();

    private static Item registerDisc() {
        Item.Properties properties = new Item.Properties()
                .stacksTo(1)
                .jukeboxPlayable(TITANES_SONG)
                .setId(TITANES_DISC_KEY);

        Item item = new Item(properties);

        return Registry.register(
                BuiltInRegistries.ITEM,
                TITANES_DISC_KEY,
                item
        );
    }

    @Override
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(
                CreativeModeTabs.TOOLS_AND_UTILITIES
        ).register(entries -> entries.accept(TITANES_DISC));
    }
}
